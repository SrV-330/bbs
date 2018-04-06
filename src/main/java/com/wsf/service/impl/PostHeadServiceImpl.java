package com.wsf.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsf.dao.PostHeadDao;
import com.wsf.dao.UserDao;
import com.wsf.entity.Page;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;
import com.wsf.service.PostHeadService;


@Service
public class PostHeadServiceImpl implements PostHeadService {

	@Autowired
	private PostHeadDao phd;
	
	@Autowired
	private UserDao ud;
	@Autowired
	private SimpleDateFormat sdf;
	
	public int addPostHead(String title,String simple,String content,User user) {
		// TODO Auto-generated method stub
		int i=0;
		PostHead hd=null;
		User u=null;
		try {
			u=ud.query(user);
			if(u!=null&&u.getIsGag()==User.UNGAG){
				hd=new PostHead(title,
						PostHead.getDetail(simple),
						content,
						user,
						sdf.format(new Date()),
						PostHead.UNTOP,
						PostHead.UNGOOD,
						PostHead.UNDEL,
						PostHead.UNLOCK
						);
				i=phd.insert(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<PostHead> getPostHeadByPage(Page page) {
		// TODO Auto-generated method stub
		List<PostHead> l=null;
		try {
			
			
			if(page!=null&&page.getCurrentPage()>0){
				PostHead hd=new PostHead();
				hd.setIsDel(PostHead.UNDEL);
				long total=phd.count(hd);
				l=phd.queryByPage((page.getCurrentPage()-1)*Page.PAGER_RECORD, Page.PAGER_RECORD);
				page.setRecordCount((int)total);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public PostHead getPostHeadById(String id) {
		// TODO Auto-generated method stub
		PostHead hd=null;
		try {
			hd=phd.queryById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hd;
	}

	public int deletePostHeadById(String id,String isDel,User user) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		PostHead hd=null;
		PostHead hd1=null;
		
		
		try {
			
			u=ud.query(user);
			if(u!=null){
				hd1=phd.queryById(Long.parseLong(id));
				if(u.getUserType()==User.ADMIN||u.getUid()==hd1.getLz().getUid()){
					hd=new PostHead();
					hd.setHdid(Long.parseLong(id));
					hd.setIsDel(Integer.parseInt(isDel));
					i=phd.update(hd);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int lockPostHeadById(String id,String isLock,User user) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		PostHead hd=null;
		try {
			u=ud.query(user);
			if(u!=null&&u.getUserType()==User.ADMIN){
				hd=new PostHead();
				hd.setHdid(Long.parseLong(id));
				hd.setIsLock(Integer.parseInt(isLock));
				i=phd.update(hd);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int setTopById(String id,String isTop,User user) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		PostHead hd=null;
		try {
			u=ud.query(user);
			if(u!=null&&u.getUserType()==User.ADMIN){
				hd=new PostHead();
				hd.setHdid(Long.parseLong(id));
				hd.setIsTop(Integer.parseInt(isTop));
				i=phd.update(hd);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int setGoodById(String id,String isGood,User user) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		PostHead hd=null;
		try {
			u=ud.query(user);
			if(u!=null&&u.getUserType()==User.ADMIN){
				hd=new PostHead();
				hd.setHdid(Long.parseLong(id));
				hd.setIsGood(Integer.parseInt(isGood));
				i=phd.update(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<PostHead> getPostHeadByPage(PostHead hd, Page page) {
		// TODO Auto-generated method stub
		List<PostHead> l=null;
		try {
			
			
			if(page!=null&&page.getCurrentPage()>0){
				
				long total=phd.count(hd);
				l=phd.queryByPageByPostHead(hd,(page.getCurrentPage()-1)*Page.PAGER_RECORD, Page.PAGER_RECORD);
				page.setRecordCount((int)total);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
