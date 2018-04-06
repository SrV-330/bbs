package com.wsf.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.PostHead;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class PostHeadDaoTest {

	@Resource
	private PostHeadDao phd;
	
	@Test
	public void testQueryById() throws Exception{
		//System.out.println(phd==null);
		PostHead hd1=new PostHead();
		hd1.setIsTop(1);
		hd1.setHeadTitle("标题");
		//PostHead hd= phd.queryById(1);
		PostHead hd=phd.query(hd1);
		System.out.println(hd.toString());
	}
}
