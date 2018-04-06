package com.wsf.service;


import java.util.List;

import com.wsf.entity.Page;
import com.wsf.entity.User;

public interface UserService {
	public User queryUserById(String id);
	public User queryUserByName(String name);
	public User queryUserByNameAndPwd(String name,String pwd);
	public User queryUser(User user);
	public int gagUserById(String id);
	public int ungagUserById(String id);
	public int addUser(String name,String pwd);
	public List<User> queryByPage(User user,Page page);
	

}
