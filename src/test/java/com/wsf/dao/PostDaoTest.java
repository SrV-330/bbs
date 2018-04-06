package com.wsf.dao;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class PostDaoTest {

	@Resource
	private PostDao pd;
	
	@Test
	public void testQueryByHdid() throws Exception{
		
		Post p= pd.queryById(1);
		List<Post> l=pd.queryByHdid(1, 0, 5);
		System.out.println(p);
		System.out.println(l);
		
	}
}
