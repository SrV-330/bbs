package com.wsf.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsf.dao.MsgDao;
import com.wsf.entity.Msg;
import com.wsf.entity.Page;
import com.wsf.service.MsgService;

@Service
public class MsgServiceImpl implements MsgService {

	@Resource
	private MsgDao md;
	
	
	public List<Msg> getMsgByTuid(String id) {
		// TODO Auto-generated method stub
		List<Msg> l=null;
		try {
			l=md.queryByTuid(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public List<Msg> getMsgByPage(Msg msg, Page page) {
		// TODO Auto-generated method stub
		
		List<Msg> l=null;
		try {
			l=md.queryByPage(msg, (page.getCurrentPage()-1)*Page.GROUP_RECORD, Page.GROUP_RECORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	public int addMsg(Msg msg) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i=md.insert(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int glanceMsgByMid(Msg msg, List<Long> mids) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i=md.updateByMid(msg, mids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int checkMsgByMid(Msg msg, List<Long> mids) {
		// TODO Auto-generated method stub
		int i=0;
		
		try {
			i=md.updateByMid(msg, mids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
