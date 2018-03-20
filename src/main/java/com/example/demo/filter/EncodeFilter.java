package com.example.demo.filter;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Hao on 2018/3/16.
 */
@WebFilter
public class EncodeFilter implements Filter {
    private String encode="utf-8";
    @Override
    public void init(FilterConfig fc) throws ServletException {
        System.out.println(encode);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //设置响应编码格式
        response.setContentType("text/html;charset="+encode);
        //创建装饰后的对象
        MyRequest req = new MyRequest((HttpServletRequest)request);
        chain.doFilter(req, response);
    }
    class MyRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        private Map<String,String[]> map = null;
        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }
        @Override
        public Map<String,String[]> getParameterMap() {
            if(map==null){
                //判断提交方法
                if("POST".equals(request.getMethod())){
                    try {
                        request.setCharacterEncoding(encode);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    map = request.getParameterMap();
                    return map;
                }else if("GET".equals(request.getMethod())){
                    //调用request获取form提交的所有输入框的值
                    map = request.getParameterMap();
                    for(Map.Entry<String, String[]> entry:map.entrySet()){
                        String vals[]= entry.getValue();
                        if(vals!=null){
                            for(int i = 0;i<vals.length;i++){
                                try {
                                    vals[i] = new String(vals[i].getBytes("ISO8859-1"),encode);
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    return map;
                }else{
                    map = request.getParameterMap();
                    return map;
                }
            }else{
                return map;
            }
        }
        @Override
        public String[] getParameterValues(String name) {
            return getParameterMap().get(name);
        }
        @Override
        public String getParameter(String name) {
            return getParameterValues(name)==null?null:getParameterValues(name)[0];
        }
    }
    @Override
    public void destroy() {

    }
}
