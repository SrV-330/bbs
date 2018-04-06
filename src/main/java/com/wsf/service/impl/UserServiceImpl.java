package com.wsf.service.impl;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsf.dao.UserDao;
import com.wsf.entity.Page;
import com.wsf.entity.User;
import com.wsf.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao ud;
	@Autowired
	private SimpleDateFormat sdf;

	public User queryUserById(String id) {
		// TODO Auto-generated method stub
		User u=null;
		try {
			u=ud.queryById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public User queryUserByName(String name) {
		// TODO Auto-generated method stub
		User u=null;
		try {
			u=ud.queryByName(name);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}

	public User queryUserByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		User user=new User();
		User u=null;
		user.setUserName(name);
		user.setUserPwd(pwd);
		try {
			u=ud.query(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public int addUser(String name,String pwd) {
		// TODO Auto-generated method stub
		int i=0;
		User user=null;
		try {
			user=new User(name,pwd,User.USER,sdf.format(new Date()),User.UNGAG);
			i=ud.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int gagUserById(String id) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		User u1=null;
		
		try {
			u=ud.queryById(Long.parseLong(id));
		
			if(u!=null&&u.getIsGag()!=User.GAG){
				u1=new User();
				u1.setUid(Long.parseLong(id));
				u1.setIsGag(User.GAG);
				i=ud.update(u1);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int ungagUserById(String id) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		User u1=null;
		
		try {
			u=ud.queryById(Long.parseLong(id));
		
			if(u!=null&&u.getIsGag()!=User.UNGAG){
				u1=new User();
				u1.setUid(Long.parseLong(id));
				u1.setIsGag(User.UNGAG);
				i=ud.update(u1);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public User queryUser(User user) {
		// TODO Auto-generated method stub
		User u=null;
		
		try {
			if(user!=null){
				u=ud.query(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	public List<User> queryByPage(User user, Page page) {
		// TODO Auto-generated method stub
		List<User> l=null;
		try {
			if(page!=null&&page.getCurrentPage()>0){
				
				l=ud.queryByPage(user, (page.getCurrentPage()-1)*Page.PAGER_RECORD, 
						Page.PAGER_RECORD);
				page.setRecordCount((int)ud.count(user));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}


	
	

}
