package com.wsf.service;

import java.util.List;

import com.wsf.entity.Msg;
import com.wsf.entity.Page;

public interface MsgService {
	
	public List<Msg> getMsgByTuid(String id);
	public List<Msg> getMsgByPage(Msg msg,Page pgae);
	public int addMsg(Msg msg);
	public int glanceMsgByMid(Msg msg,List<Long> mids);
	public int checkMsgByMid(Msg msg,List<Long> mids);

}
