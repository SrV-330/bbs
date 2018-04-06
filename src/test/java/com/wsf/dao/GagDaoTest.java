package com.wsf.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Gag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class GagDaoTest {

	@Resource
	private GagDao gd;
	
	@Test
	public void testQueryById() throws Exception{
		Gag g=null; 
		g=gd.queryById(1);
		System.out.println(g==null);
	}
	
}
