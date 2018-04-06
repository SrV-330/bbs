package com.wsf.dao;

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
@ContextConfiguration(locations="classpath*:spring-dao.xml")
public class UserDaoTest {
	
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserDao ud;
	
	@Resource
	private SimpleDateFormat sdf;

	@Test
	public void testQueryById() throws Exception{
		User u=null;
		/*
		u=new User();
		u.setUserName("admin");
		u.setUserPwd("admin");
		User user=ud.query(u);
		logger.info("User={}",user);
		*/
		
		u=new User();
		u.setUserName("user");
		u.setUserPwd("user");
		u.setRegTime(sdf.format(new Date()));
		u.setUserType(User.USER);
		u.setIsGag(User.UNGAG);
		int i=ud.insert(u);
		logger.info("Insert={}",i);
	}
	
	

}
