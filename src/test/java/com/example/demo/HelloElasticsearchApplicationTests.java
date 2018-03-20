package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloElasticsearchApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Test
	public void contextLoads() {


	}

	@Test
	public void testJDBC(){
		List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from user");
		System.out.println("查询结果： "+result.size());

	}

}
