package com.wsf.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsf.entity.Page;
import com.wsf.entity.Post;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;
import com.wsf.entity.Zan;
import com.wsf.eto.CommentJson;
import com.wsf.eto.LoginJson;
import com.wsf.service.PostHeadService;
import com.wsf.service.PostService;
import com.wsf.service.UserService;
import com.wsf.service.ZanService;
import com.wsf.util.Tool;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private PostHeadService phs;
	@Autowired
	private ZanService zs;
	@Autowired
	private UserService us;
	@Autowired
	private LoginJson lj;
	
	@RequestMapping(value={ "/postdetail/{hdid}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostByPid(
			@PathVariable("hdid")String hdid,
			@RequestParam(value="cid",required=false) String cid,
			Model model,
			HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		PostHead phd=null; 
		int i=1;
		Page page=new Page(i);
		List<Post> l=null;
		phd=phs.getPostHeadById(hdid);
		if(!Tool.isNullOrEmpty(cid)){
			l=ps.locationPostByPage(page, Long.toString(phd.getHdid()), cid);
			
		}
		else{
			l=ps.getPostByPage(page, Long.toString(phd.getHdid()));
		}
		List<Zan> lz=new ArrayList<Zan>();
		if(l!=null && l.size()>0&&user!=null){
			for(Post pt : l){
				Zan z=null;
				List<Zan> lt=null;
				Zan zan=new Zan();
				zan.setZu(user);
				zan.setZp(pt);
				
				lt=zs.getZan(zan);
				if(lt!=null &&lt.size()>0){
					z=lt.get(0);
				}
				lz.add(z);
			}
		}
		
		
		page.setUrl("/post/postdetail/"+hdid);
		
		page.getGroupList();
		model.addAttribute("PostHead", phd);
		model.addAttribute("PostList", l);
		model.addAttribute("page",page);
		model.addAttribute("ZanList", lz);
		return "postdetail";
	}
	
	@RequestMapping(value={ "/postdetail/{hdid}/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostPageByPid(
			@PathVariable("hdid")String hdid,
			@PathVariable("pn")String pn,
			Model model,
			HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		PostHead phd=null; 
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<Post> l=null;
		phd=phs.getPostHeadById(hdid);
		l=ps.getPostByPage(page, Long.toString(phd.getHdid()));
		
		List<Zan> lz=new ArrayList<Zan>();
		if(l!=null && l.size()>0&&user!=null){
			for(Post pt : l){
				Zan z=null;
				List<Zan> lt=null;
				Zan zan=new Zan();
				zan.setZu(user);
				zan.setZp(pt);
				
				lt=zs.getZan(zan);
				if(lt!=null &&lt.size()>0){
					z=lt.get(0);
				}
				lz.add(z);
			}
		}
		
		
		page.setUrl("/post/postdetail/"+hdid);
		page.getGroupList();
		model.addAttribute("PostHead", phd);
		model.addAttribute("PostList", l);
		model.addAttribute("page",page);
		model.addAttribute("ZanList", lz);
		return "postdetail";
	}
	
	@RequestMapping(value={ "/postdetail/reply"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public CommentJson getReplyByPid(
			@RequestBody Post post,
			Model model){
		int i=1;
		List<Post> l=null;
		
		Page page=new Page(i);
		
		l=ps.getReplyByPage(page, Long.toString(post.getPid()));
		
		System.out.println(l);
		
		CommentJson cj=new CommentJson();
		cj.setPage(page);
		cj.setPosts(l);
		return cj;
	}
	
	
	@RequestMapping(value={ "/postdetail/reply/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public CommentJson getReplyByPidByPage(
			@RequestBody Post post,
			@PathVariable("pn")String pn,
			Model model){
		int i=1;
		List<Post> l=null;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		
		Page page=new Page(i);
		
		l=ps.getReplyByPage(page, Long.toString(post.getPid()));
		System.out.println(l);
		
		CommentJson cj=new CommentJson();
		cj.setPage(page);
		cj.setPosts(l);
		return cj;
	}
	
	
	
	@RequestMapping(value={ "/postdetail/reply/del"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson delReplyByPid(
			@RequestBody Post post,
			Model model,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=ps.deletePostById(Long.toString(post.getPid()), user);
		if(i>0){
			lj.setErr("删除成功！");
			lj.setRes("1");
		}
		return lj;
	}
	
	@RequestMapping(value={ "/postdetail/reply/undel"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson undelReplyByPid(
			@RequestBody Post post,
			Model model,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=ps.undeletePostById(Long.toString(post.getPid()), user);
		if(i>0){
			lj.setErr("恢复成功！");
			lj.setRes("1");
		}
		return lj;
	}
	
	
	@RequestMapping(value={ "/postdetail/reply/add"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson addReplyByPid(
			@RequestBody Post post,
			Model model,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		user=us.queryUserById(Long.toString(user.getUid()));
		request.getSession().setAttribute("user",user);
		PostHead hd=null;
		Post p=null;
		p=ps.getPostById(Long.toString(post.getPid()));
		hd=phs.getPostHeadById(Long.toString(p.getHd().getHdid()));
		
		
		if(user.getIsGag()==User.GAG){
			lj.setErr("您被禁言中！");
			lj.setRes("0");
			return lj;
		}
		if(hd.getIsDel()==PostHead.DEL||p.getIsDel()==Post.DEL){
			lj.setErr("帖子被删除！");
			lj.setRes("2");
			return lj;
		}
		if(hd.getIsLock()==PostHead.LOCK){
			lj.setErr("帖子被锁！");
			lj.setRes("3");
			return lj;
		}
		//i=ps.addPost(hd, post.getPostContent(), user);
		i=ps.addReply(hd, post.getPostContent(), user, p, p.getRpu());
		if(i>0){
			lj.setErr("发送成功！");
			lj.setRes("1");
		}
		return lj;
	}
	
	@RequestMapping(value={ "/postdetail/zan"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson zanReplyByPid(
			@RequestBody Zan zan,
			Model model,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		PostHead hd=null;
		Post p=null;
		p=ps.getPostById(Long.toString(zan.getZp().getPid()));
		
		hd=phs.getPostHeadById(Long.toString(p.getHd().getHdid()));
		Zan z=null,z1=null;
		z1=new Zan();
		z1.setZp(p);
		z1.setZu(user);
		List<Zan> l=null;
		l=zs.getZan(z1);
		if(l!=null&&l.size()>0){
			z=l.get(0);
		}
		if(hd.getIsDel()==PostHead.DEL||p.getIsDel()==Post.DEL){
			lj.setErr("帖子被删除！");
			lj.setRes("2");
			return lj;
		}
		
		//i=ps.addPost(hd, post.getPostContent(), user);
		i=zs.zanPost(p, Integer.toString(zan.getZanType()), user, z);
		if(i>0){
			lj.setErr("成功！");
			lj.setRes("1");
		}
		return lj;
	}
	
	@RequestMapping(value={ "/add"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson addPost(
			@RequestBody Post post,
			Model model,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		user=us.queryUserById(Long.toString(user.getUid()));
		request.getSession().setAttribute("user",user);
		if(user==null||user.getIsGag()==User.GAG){
			lj.setErr("您被禁言！");
			lj.setRes("0");
			return lj;
		}
		PostHead hd=null;
		hd=phs.getPostHeadById(Long.toString(post.getHd().getHdid()));
		if(hd==null||hd.getIsDel()==PostHead.DEL){
			lj.setErr("帖子被删！");
			lj.setRes("0");
			return lj;
		}
		if(hd.getIsLock()==PostHead.LOCK){
			lj.setErr("帖子被锁！");
			lj.setRes("0");
			return lj;
		}
		
		i=ps.addPost(hd, post.getPostContent(), user);
		if(i>0){
			lj.setErr("发帖成功！");
			lj.setRes("1");
		}
		return lj;
	}
	
	@RequestMapping(value={ "/search"},
			method={RequestMethod.POST,RequestMethod.GET})
	public String getPostByKw(
			Model model,
			HttpServletRequest request,
			@RequestParam(value="kw",required=false) String kw
			){
		int i=1;
		List<Post> l=null;
		String[] kws=null;
		try {
			kw=new String(kw.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			if(!Tool.isNullOrEmpty(kw)){
				kw=java.net.URLDecoder.decode(kw,"UTF-8");
				System.out.println("kw="+kw);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */ 
		
		System.out.println("kw="+kw);
		Page page=new Page(i);
		if(!Tool.isNullOrEmpty(kw)){
			kw=kw.trim();
			kws=kw.split(" ");
		}
		List<String> kwl=new ArrayList();
		if(kws!=null&&kws.length>0){
			for(String s:kws){
				kwl.add(s);
			}
		}
		if(kwl.size()>0){
			l=ps.getPostByKw(page, kwl);
		}
		String url="/post/search";
		
		page.setUrl(url);
		page.setParam("?kw="+kw);
		model.addAttribute("PostList", l);
		model.addAttribute("page", page);
		
		
		return "search";
	}
	
	
	@RequestMapping(value={ "/search/{pn}"},
			method={RequestMethod.POST,RequestMethod.GET})
	public String getPostByKwByPage(
			@PathVariable("pn")String pn,
			Model model,
			HttpServletRequest request,
			@RequestParam(value="kw",required=false) String kw){
		int i=1;
		List<Post> l=null;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		String[] kws=null;
		
		try {
			kw=new String(kw.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			if(!Tool.isNullOrEmpty(kw)){
			kw=java.net.URLDecoder.decode(kw,"UTF-8");}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */  
		Page page=new Page(i);
		if(!Tool.isNullOrEmpty(kw)){
			kw=kw.trim();
			kws=kw.split(" ");
		}
		List<String> kwl=new ArrayList();
		if(kws!=null&&kws.length>0){
			for(String s:kws){
				kwl.add(s);
			}
		}
		if(kwl.size()>0){
			l=ps.getPostByKw(page, kwl);
		}
		String url="/post/search";
		
		
		page.setUrl(url);
		page.setParam("?kw="+kw);
		model.addAttribute("PostList", l);
		model.addAttribute("page", page);
		
		
		return "search";
	}
	
	

}
