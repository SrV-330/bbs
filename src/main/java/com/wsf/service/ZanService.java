package com.wsf.service;

import java.util.List;

import com.wsf.entity.Page;
import com.wsf.entity.Post;
import com.wsf.entity.User;
import com.wsf.entity.Zan;

public interface ZanService {

	public Zan getZanById(String id);
	public List<Zan> getZanByPage(Zan zan,Page page);
	public List<Zan> getZanByZuid(String id);
	public List<Zan> getZan(Zan zan);
	public int zanPost(Post post,String zanType,User user,Zan zan);
	
}
