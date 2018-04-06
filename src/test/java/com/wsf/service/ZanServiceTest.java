package com.wsf.service;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Post;
import com.wsf.entity.User;
import com.wsf.entity.Zan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring-dao.xml",
	"classpath:spring-service.xml"})
public class ZanServiceTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	@Resource
	private ZanService zs;
	
	@Resource
	private PostService ps;
	
	@Resource
	private UserService us;
	
	
	
	@Resource
	private SimpleDateFormat sdf;
	
	@Test
	public void testZanPost() throws Exception{
		Post post=ps.getPostById("1");
		logger.info("POST.ZAN={}",post.getZan());
		String zanType=Long.toString(Zan.ZANUP);
		User user=us.queryUserById("1");
		Zan zan=new Zan(user,post);
		Zan z=zs.getZan(zan).get(0);
		z=new Zan(z.getZid(),z.getZanType());
		logger.info("ZID={}",z.getZid());
		int i=0;
		i=zs.zanPost(post, zanType, user, z);
		logger.info("ZanPost={}",i);
		
		
	}
}
