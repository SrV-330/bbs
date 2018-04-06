package com.wsf.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Zan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class ZanDaoTest {

	@Resource
	private ZanDao zd;
	
	@Test
	public void testQureyById() throws Exception{
		Zan z=null;
		z=zd.queryById(1);
		List<Zan> l=null;
		System.out.println(z==null);
		l=zd.queryByZpid(1);
		System.out.println(l==null);
		l=zd.queryByZuid(1);
		System.out.println(l==null);
	}
}
