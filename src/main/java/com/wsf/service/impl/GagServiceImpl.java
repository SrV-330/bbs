package com.wsf.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsf.dao.GagDao;
import com.wsf.dao.UserDao;
import com.wsf.entity.Gag;
import com.wsf.entity.Page;
import com.wsf.entity.User;
import com.wsf.service.GagService;
import com.wsf.util.Tool;

@Service
public class GagServiceImpl implements GagService {

	@Autowired
	private GagDao gd;
	
	@Autowired
	private UserDao ud;
	
	
	@Autowired
	private SimpleDateFormat sdf;
	
	public Gag getGagById(String id) {
		// TODO Auto-generated method stub
		
		Gag g=null;
		
		try {
			g=gd.queryById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return g;
	}

	public List<Gag> getGagByGuid(String id) {
		// TODO Auto-generated method stub
		
		List<Gag> l=null;
		
		try {
			l=gd.queryByGuid(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	public List<Gag> getGagByOuid(String id) {
		// TODO Auto-generated method stub
		
		List<Gag> l=null;
		
		try {
			l=gd.queryByOuid(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	@Transactional
	public int gagUser(User gu, User ou,Gag gag,String startTime,String endTime,String gagType,String gagRs) {
		// TODO Auto-generated method stub
		
		int i=0,j=0,k=0;
		User u=null;
		Gag g=null;
		try {
			if(gag==null){
				if(ou!=null&&ou.getUserType()==User.ADMIN){
					if(gu!=null&&gu.getIsGag()!=User.GAG){
						if(!Tool.isNullOrEmpty(startTime,endTime,gagType,gagRs)){
							Date s=sdf.parse(startTime);
							Date e=sdf.parse(endTime);
							if(s.before(e)&&(Integer.parseInt(gagType)==Gag.GAG||Integer.parseInt(gagType)==Gag.UNGAG)){
								g=new Gag(gu,ou,startTime,endTime,
										Integer.parseInt(gagType),
										Integer.parseInt(gagRs));
								u=new User();
								u.setUid(gu.getUid());
								u.setIsGag(User.GAG);
								i=gd.insert(g);
								j=ud.update(u);
								k=i&j;
								System.out.println("i:"+i);
								System.out.println("j:"+j);
							}
						}
					}
				}
			}else{
				Date now=new Date();
				Date e= sdf.parse(gag.getEndTime());
				int m=0;
				if(e.before(now)){
					m=ungagUser(gu,ou,gag);
					
					g=new Gag(gu,ou,startTime,endTime,
							Integer.parseInt(gagType),
							Integer.parseInt(gagRs));
					u=new User();
					u.setUid(gu.getUid());
					u.setIsGag(User.GAG);
					i=gd.insert(g);
					j=ud.update(u);
					k=i&j&m;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return k;
	}
	@Transactional
	public int ungagUser(User gu,User ou,Gag gag) {
		// TODO Auto-generated method stub
		int i=0,j=0,k=0;
		User u=null;
		Gag g=null;
		//List<Gag> l=null;
		try {
			//u=ud.query(ou);
			if(gag!=null&&gag.getGagType()==Gag.GAG){
				if(ou!=null&&ou.getUserType()==User.ADMIN){
					//u1=ud.query(gu);
					if(gu!=null&&gu.getIsGag()!=User.UNGAG){
						//l=gd.queryTopByGuid(gu.getUid(),0,1);
						//if(l!=null&&l.size()>0){
						
						//g=l.get(0);
						g=new Gag(gag.getGid(),Gag.UNGAG);
						u=new User();
						u.setUid(gu.getUid());
						u.setIsGag(User.UNGAG);
						i=gd.update(g);
						j=ud.update(u);
						k=i&j;
						//}
						
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return k;
	}
	@Transactional
	public int ungagUser(User gu,Gag gag) {
		// TODO Auto-generated method stub
		int i=0,j=0,k=0;
		User u=null;
		//List<Gag> l=null;
		Gag g=null;
		Date date=null;
		Date now=null;
		try {
			//u=ud.query(gu);
			if(gag!=null&&gag.getGagType()==Gag.GAG){
				if(gu!=null&&gu.getIsGag()==User.GAG){
					//l=gd.queryTopByGuid(gu.getUid(), 0,1);
					//if(l!=null &&l.size()>0){
						//g=l.get(0);
						
					date=sdf.parse(gag.getEndTime());
					
					now=new Date();
					if(date.before(now)){
						g=new Gag(gag.getGid(),Gag.UNGAG);
						u=new User();
						u.setUid(gu.getUid());
						u.setIsGag(User.UNGAG);
						i=gd.update(g);
						j=ud.update(u);
						k=i&j;
						
					}
								
					//}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}

	public List<Gag> getTopGagByGuid(String id) {
		// TODO Auto-generated method stub
List<Gag> l=null;
		
		try {
			l=gd.queryTopByGuid(Long.parseLong(id),0,1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	public List<Gag> getGagByPage(Gag gag, Page page) {
		// TODO Auto-generated method stub
		List<Gag> l=null;
		try {
			if(page!=null&&page.getCurrentPage()>0){
				
				l=gd.queryByPage(gag, (page.getCurrentPage()-1)*Page.PAGER_RECORD, Page.PAGER_RECORD);
				page.setRecordCount((int)gd.count(gag));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
