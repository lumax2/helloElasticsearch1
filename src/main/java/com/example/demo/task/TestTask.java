package com.example.demo.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jdk.management.resource.ResourceContextFactory.isEnabled;

/**
 * Created by Hao on 2018/3/16.
 */
public class TestTask {
    private static final Logger LOG = LoggerFactory.getLogger(TestTask.class);

    public void run(){
        if(LOG.isInfoEnabled()){
            LOG.info("quartz 测试任务开始执行");
        }
        System.out.println("quartz run......");
    }

}
