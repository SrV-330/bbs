package com.wsf.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Page;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring-dao.xml",
	"classpath:spring-service.xml"})
public class PostHeadServiceTest {

	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private PostHeadService hds;
	@Resource
	private UserService us;
	
	@Test
	public void testGetPostHeadById() throws Exception{

		PostHead hd=null;
		User u=us.queryUserById("1");
		List<PostHead> l=null;
		int i=0;
		i=hds.setGoodById("1","1",u);
		logger.info("SetGood={}",i);
		hd=hds.getPostHeadById("1");
		logger.info("PostHead={}",hd);
		Page page=new Page(1);
		l=hds.getPostHeadByPage(page);
		logger.info("PostHead={}",l);
		
	}
}
