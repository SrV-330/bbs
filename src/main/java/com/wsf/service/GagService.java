package com.wsf.service;

import java.util.List;

import com.wsf.entity.Gag;
import com.wsf.entity.Page;
import com.wsf.entity.User;

public interface GagService {
	public Gag getGagById(String id);
	public List<Gag> getGagByGuid(String id);
	public List<Gag> getGagByOuid(String id);
	public List<Gag> getGagByPage(Gag gag,Page page);
	public List<Gag> getTopGagByGuid(String id);
	public int gagUser(User gu,User ou,Gag gag,String startTime,String endTime,String gagType,String gagRs);
	public int ungagUser(User gu,User ou,Gag gag);
	public int ungagUser(User gu,Gag gag);
}
