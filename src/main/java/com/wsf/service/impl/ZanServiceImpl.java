package com.wsf.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsf.dao.MsgDao;
import com.wsf.dao.PostDao;
import com.wsf.dao.ZanDao;
import com.wsf.entity.Msg;
import com.wsf.entity.Page;
import com.wsf.entity.Post;
import com.wsf.entity.User;
import com.wsf.entity.Zan;
import com.wsf.service.ZanService;

@Service
public class ZanServiceImpl implements ZanService {

	@Autowired
	private ZanDao zd;
		
	@Autowired
	private PostDao pd;
	
	@Autowired
	private MsgDao md;
	
	@Resource
	private SimpleDateFormat sdf;
	
	public Zan getZanById(String id) {
		// TODO Auto-generated method stub
		Zan z=null;
		try {
			z=zd.queryById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return z;
	}

	public List<Zan> getZanByZuid(String id) {
		// TODO Auto-generated method stub
		List<Zan> l=null;
		try {
			l=zd.queryByZuid(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public List<Zan> getZan(Zan zan) {
		// TODO Auto-generated method stub
		List<Zan> l=null;
		try {
			l=zd.query(zan);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return l;
	}
	@Transactional
	public int zanPost(Post post, String zanType, User user,Zan zan) {
		// TODO Auto-generated method stub
		Zan z=null;//,z1=null;
		
		Post p=null;//,p1=null;
		Msg m=null;
		//List<Zan> l=null;
		int i=0,j=0,k=0,k1=0;
		try {
			//p=pd.queryById(Long.parseLong(pid));
		
			if(post!=null&&post.getIsDel()==Post.UNDEL){
				
				//z=new Zan(user,post);
				//l=zd.query(z);
				//if(l!=null&&l.size()>0){
					//z1=l.get(0);
				//}
				int ztp=Integer.parseInt(zanType);
				if(zan==null){
					if(ztp==Zan.ZANNO){
						z=new Zan(user,post,ztp);
						k=zd.insert(z);
					}
					if(ztp==Zan.ZANUP||ztp==Zan.ZANDOWN){
						z=new Zan(user,post,ztp);
						p=new Post();
						p.setPid(post.getPid());
						p.setZan((post.getZan()+ztp));
						m=new Msg(
								user,
								post.getCz(),
								post.getHd(),
								post,
								sdf.format(new Date()),
								Msg.MZAN,
								Msg.UNGLANCE,
								Msg.UNCHECK
								);
						//k1=md.insert(m);
						i=zd.insert(z);
						j=pd.update(p);
						k=i&j;
					}
				}
				else{
					if(ztp==zan.getZanType()){
						z=new Zan(zan.getZid(),Zan.ZANNO);
						p=new Post();
						p.setPid(post.getPid());
						p.setZan((post.getZan()-ztp));
						i=zd.update(z);
						j=pd.update(p);
						k=i&j;
					}else{
						z=new Zan(zan.getZid(),ztp);
						p=new Post();
						p.setPid(post.getPid());
						p.setZan((post.getZan()+ztp-zan.getZanType()));
						i=zd.update(z);
						j=pd.update(p);
						k=i&j;
					}
						
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}

	public List<Zan> getZanByPage(Zan zan, Page page) {
		// TODO Auto-generated method stub
		
		List<Zan> l=null;
		try {
			if(page.getCurrentPage()>0){
				
				l=zd.queryByPage(zan,(page.getCurrentPage()-1)*Page.PAGER_RECORD, Page.PAGER_RECORD);
				page.setPageCount((int)zd.count(zan));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	

}
