package com.wsf.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class MsgDaoTest {
	
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private MsgDao md;
	@Resource
	private UserDao ud;
	@Resource
	private PostHeadDao phd;
	@Resource
	private PostDao pd;
	@Resource
	private SimpleDateFormat sdf;
	
	@Test
	public void testqueryByTuid() throws Exception{
		Msg msg=null;
		msg=new Msg();/*
		msg.setFu(ud.queryById(2));
		msg.setTu(ud.queryById(1));
		
		msg.setmType(Msg.MZAN);
		msg.setMtime(sdf.format(new Date()));
		msg.setRphd(phd.queryById(1));
		msg.setRpp(pd.queryById(1));
		msg.setIsCheck(Msg.UNCHECK);
		msg.setIsGlance(Msg.UNGLANCE);*/
		//msg.setMid(1);
		msg.setTu(ud.queryById(1));
		msg.setIsGlance(Msg.UNGLANCE);
		int i=0;
		//i=md.update(msg);
		List<Long> mids=new ArrayList<Long>();
		List<Msg> l=null;
		l=md.queryByTuid(1);
		logger.info("l={}",l);
		
		for(Msg m:l){
			mids.add(m.getMid());
		}
		
		i=md.updateByMid(msg, mids);
		logger.info("i={}",i);
		//List<Msg> l=null;
		l=md.queryByTuid(1);
		logger.info("l={}",l);
	}

}
