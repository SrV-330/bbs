package com.wsf.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsf.dao.MsgDao;
import com.wsf.dao.PostDao;
import com.wsf.dao.PostHeadDao;
import com.wsf.dao.UserDao;
import com.wsf.entity.Msg;
import com.wsf.entity.Page;
import com.wsf.entity.Post;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;
import com.wsf.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Resource
	private UserDao ud;
	@Resource
	private PostHeadDao phd;
	@Resource
	private PostDao pd; 
	@Resource
	private MsgDao md;
	@Resource
	private SimpleDateFormat sdf;
	
	public Post getPostById(String id) {
		// TODO Auto-generated method stub
		Post p=null;
		try {
			p=pd.queryById(Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	
	public List<Post> getPostByPage(Page page,String id) {
		// TODO Auto-generated method stub
		
		List<Post> l=null;
		try {
		if(page!=null&&page.getCurrentPage()>0){
			
			l=pd.queryByHdid(Long.parseLong(id), 
					(page.getCurrentPage()-1)*Page.GROUP_RECORD, 
					Page.GROUP_RECORD);
			Post post=new Post();
			post.setHd(phd.queryById(Long.parseLong(id)));
			post.setIsDel(Post.UNDEL);
			long total=pd.count(post);
			System.out.println(total);
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

	public List<Post> getReplyByPage(Page page,String id) {
		// TODO Auto-generated method stub
		List<Post> l=null;
		try {
			if(page!=null&&page.getCurrentPage()>0){
				l=pd.queryByCid(Long.parseLong(id),
						(page.getCurrentPage()-1)*Page.PAGER_RECORD, 
						Page.PAGER_RECORD);
				
				Post post=new Post();
				post.setC(pd.queryById(Long.parseLong(id)));
				post.setIsDel(Post.UNDEL);
				long total=pd.count(post);
				
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

	public int deletePostById(String id, User user) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		Post p=null;
		try {
			u=ud.query(user);
			p=pd.queryById(Long.parseLong(id));
			
			if(u!=null&&(u.getUserType()==User.ADMIN||p.getRpu().getUid()==u.getUid())){
				
				Post post=new Post();
				post.setPid(p.getPid());
				post.setIsDel(Post.DEL);
				post.setZan(p.getZan());
				i=pd.update(post);
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return i;
	}
	@Transactional
	public int addPost(PostHead postHead,String content, User user) {
		// TODO Auto-generated method stub
		
		int i=0,j=0,k=0;
		Msg m=null;
		Post post=null;
		try {
			//u=ud.query(user);
			if(user!=null&&user.getIsGag()==User.UNGAG){
				//hd=phd.queryById(Long.parseLong(hdid));
				if(postHead!=null&&postHead.getIsDel()==PostHead.UNDEL&&postHead.getIsLock()==PostHead.UNLOCK){
					
					
					post=new Post(
							content,
							sdf.format(new Date()),
							postHead,
							user,
							Post.REPLYTOLZ,
							0,
							Post.UNDEL
							);
					m=new Msg(user,
							postHead.getLz(),
							postHead,
							post,
							sdf.format(new Date()),
							Msg.MTOLZ,
							Msg.UNGLANCE,
							Msg.UNCHECK
							);
					//j=md.insert(m);
					i=pd.insert(post);
					k=i;
				}
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}

	@Transactional
	public int addReply(PostHead postHead,String content, User rpu, Post c, User cz, User rp) {
		// TODO Auto-generated method stub
		int i=0,k=0,k1=0,k2=0,k3=0;
		//User u=null;
		//User rp=null,cz=null;
		//Post c=null;
		//PostHead hd=null;
		Post post=null;
		Msg m1=null,m2=null,m3=null;
		try {
			//u=ud.query(rpu);
			if(rpu!=null&&rpu.getIsGag()==User.UNGAG){
				//hd=phd.queryById(Long.parseLong(hdid));
				if(postHead!=null&&postHead.getIsDel()==PostHead.UNDEL&&postHead.getIsLock()==PostHead.UNLOCK){
					//c=pd.queryById(Long.parseLong(cid));
					if(c!=null&&c.getIsDel()==Post.UNDEL){
						//cz=ud.queryById(Long.parseLong(czid));
						//rp=ud.queryById(Long.parseLong(rpid));
						if(cz!=null&&rp!=null){
							
								post=new Post(
										content,
										sdf.format(new Date()),
										postHead,
										c,
										cz,
										rp,
										rpu,
										Post.REPLYTOLZ,
										0,
										Post.UNDEL
										);
								m1=new Msg(rpu,
										postHead.getLz(),
										postHead,
										post,
										sdf.format(new Date()),
										Msg.MTOLZ,
										Msg.UNGLANCE,
										Msg.UNCHECK);
								m2=new Msg(rpu,
										cz,
										postHead,
										post,
										sdf.format(new Date()),
										Msg.MTOCZ,
										Msg.UNGLANCE,
										Msg.UNCHECK);
								m3=new Msg(rpu,
										rp,
										postHead,
										post,
										sdf.format(new Date()),
										Msg.MTOCZ,
										Msg.UNGLANCE,
										Msg.UNCHECK);
								k1=md.insert(m1);
								k2=md.insert(m2);
								k3=md.insert(m3);
								i=pd.insert(post);
								k=k1&k2&k3&i;
						}
					}
				}
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	

	@Transactional
	public int addReply(PostHead postHead,String content, User rpu, Post c, User cz) {
		// TODO Auto-generated method stub
		int i=0,k=0,k1=0,k2=0;
		//User u=null;
		//User rp=null,cz=null;
		//Post c=null;
		//PostHead hd=null;
		Post post=null;
		Msg m1=null,m2=null;
		try {
			//u=ud.query(rpu);
			if(rpu!=null&&rpu.getIsGag()==User.UNGAG){
				//hd=phd.queryById(Long.parseLong(hdid));
				if(postHead!=null&&postHead.getIsDel()==PostHead.UNDEL&&postHead.getIsLock()==PostHead.UNLOCK){
					//c=pd.queryById(Long.parseLong(cid));
					if(c!=null&&c.getIsDel()==Post.UNDEL){
						//cz=ud.queryById(Long.parseLong(czid));
						//rp=ud.queryById(Long.parseLong(rpid));
						if(cz!=null){
							
								post=new Post(
										content,
										sdf.format(new Date()),
										postHead,
										c,
										cz,
										
										rpu,
										Post.REPLYTOUSER,
										0,
										Post.UNDEL
										);
								/*m1=new Msg(rpu,
										postHead.getLz(),
										postHead,
										post,
										sdf.format(new Date()),
										Msg.MTOLZ,
										Msg.UNGLANCE,
										Msg.UNCHECK);
								m2=new Msg(rpu,
										cz,
										postHead,
										post,
										sdf.format(new Date()),
										Msg.MTOCZ,
										Msg.UNGLANCE,
										Msg.UNCHECK);
								/*m3=new Msg(rpu,
										rp,
										postHead,
										post,
										sdf.format(new Date()),
										Msg.MTOCZ,
										Msg.UNGLANCE,
										Msg.UNCHECK);*/
								//k1=md.insert(m1);
								//k2=md.insert(m2);
								//k3=md.insert(m3);
								i=pd.insert(post);
								k=i;
						}
					}
				}
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public List<Post> locationPostByPage(Page page,String id,String cid) {
		List<Post> l=null;
		try {
		if(page!=null&&page.getCurrentPage()>0){
			Post post=new Post();
			post.setHd(phd.queryById(Long.parseLong(id)));
			post.setIsDel(Post.UNDEL);
			long total=pd.count(post);
			page.setRecordCount((int)total);
			
			
			Post p=null;
			p=pd.queryById(Long.parseLong(cid));
			int start=(page.getCurrentPage()-1);
			boolean flag=false;
			for(l=new ArrayList();!flag&&start<page.getGroupList().size();start++){
				l=pd.queryByHdid(Long.parseLong(id), 
						start*Page.PAGER_RECORD, 
						Page.GROUP_RECORD);
				for(Post pt:l){
					if(pt.getPid()==p.getPid()){
						flag=true;
						page.setCurrentPage(start+1);
						break;
					}
				}
				if(flag){
					break;
				}
			}
			if(!flag){
				page.setCurrentPage(1);
			}
			
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


	public List<Post> getPostByPage(Post post, Page page) {
		// TODO Auto-generated method stub
		List<Post> l=null;
		try {
		if(page!=null&&page.getCurrentPage()>0){
			
			l=pd.queryByPage(post,(page.getCurrentPage()-1)*Page.GROUP_RECORD, 
					Page.GROUP_RECORD);
					
			
			long total=pd.count(post);
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


	public int undeletePostById(String id, User user) {
		// TODO Auto-generated method stub
		int i=0;
		User u=null;
		Post p=null;
		try {
			u=ud.query(user);
			p=pd.queryById(Long.parseLong(id));
			
			if(u!=null&&(u.getUserType()==User.ADMIN||p.getRpu().getUid()==u.getUid())){
				
				Post post=new Post();
				post.setPid(p.getPid());
				post.setIsDel(Post.UNDEL);
				post.setZan(p.getZan());
				i=pd.update(post);
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return i;
	}


	public List<Post> getPostByKw(Page page, List<String> list) {
		// TODO Auto-generated method stub
		List<Post> l=null;
		try {
		if(page!=null&&page.getCurrentPage()>0){
			
			l=pd.queryByKw(list,(page.getCurrentPage()-1)*Page.GROUP_RECORD, 
					Page.GROUP_RECORD);
					
			
			long total=pd.countByKw(list);
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
