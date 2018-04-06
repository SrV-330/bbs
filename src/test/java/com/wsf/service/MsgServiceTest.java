package com.wsf.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsf.entity.Msg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring-dao.xml",
	"classpath:spring-service.xml"})
public class MsgServiceTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserService us;
	
	@Resource
	private SimpleDateFormat sdf;
	
	@Resource
	private MsgService ms;
	
	@Test
	public void TestGetMsgByTuid() throws Exception{
		List<Msg> l=null;
		l=ms.getMsgByTuid("1");
		logger.info("Msgs={}",l);
	}
	

}
