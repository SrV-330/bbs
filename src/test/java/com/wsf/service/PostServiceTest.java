package com.wsf.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring-dao.xml",
	"classpath:spring-service.xml"})
public class PostServiceTest {

	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private PostService ps;
	
	@Test
	public void testGetPostById() throws Exception{
		Post p=null;
		p=ps.getPostById("1");
		logger.info("Post={}",p);
	}
}
