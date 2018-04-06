package com.wsf.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring-dao.xml",
	"classpath:spring-service.xml"})
public class UserServiceTest {

	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserService us;
	@Resource
	private SimpleDateFormat sdf;
	
	@Test
	public void testQueryUserById() throws Exception{
		User u=null;
		//u=us.queryUserById("1");
		//System.out.println(u==null);
		u=us.queryUserByName(null);
		logger.info("User={}",u);
		u=us.queryUserById(null);
		logger.info("User={}",u);
		System.out.println(sdf.format(new Date()));
		
		
	}
}
