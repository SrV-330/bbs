package com.wsf.service;

import java.util.List;


import com.wsf.entity.Page;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;

public interface PostHeadService {
	public int addPostHead(String title,String simple,String content,User user);
	public List<PostHead> getPostHeadByPage(Page page);
	public List<PostHead> getPostHeadByPage(PostHead hd,Page page);
	public PostHead getPostHeadById(String id);
	public int deletePostHeadById(String id,String isDel,User user);
	public int lockPostHeadById(String id,String isLock,User user);
	public int setTopById(String id,String isTop,User user);
	public int setGoodById(String id,String isGood,User user);
}
