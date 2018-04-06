package com.wsf.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Gag;
import com.wsf.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring-dao.xml",
	"classpath:spring-service.xml"})
public class GagServiceTest {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	@Resource
	private GagService gs;
	
	@Resource
	private UserService us;
	
	@Resource
	private SimpleDateFormat sdf;
	
	@Resource
	private Calendar cld;
	
	@Test
	public void testGagUser() throws Exception{
		Gag gag=null;
		User gu=null;
		gu=us.queryUserById("2");
		User ou=null;
		
		ou=us.queryUserById("1");
		
		Date now=new Date();
		//cld=Calendar.getInstance();
		cld.add(Calendar.MINUTE,3);
		Date aft=cld.getTime();
		List<Gag> l=null;
		l=gs.getTopGagByGuid(Long.toString(gu.getUid()));
		if(l!=null&&l.size()>0)
			gag=l.get(0);
		//gag=new Gag(gu,ou,sdf.format(now),sdf.format(aft),Gag.GAG,1);
		logger.info("Gu={}",gu);
		logger.info("Ou={}",ou);
		logger.info("Gag={}",gag);
		int i=gs.gagUser(gu, ou,gag, sdf.format(now), sdf.format(aft),Integer.toString(Gag.GAG),"1");
		logger.info("GagUser={}",i);
		
	}
	
	
}
