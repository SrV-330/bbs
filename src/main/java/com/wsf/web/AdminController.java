package com.wsf.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsf.entity.Gag;
import com.wsf.entity.Page;
import com.wsf.entity.Post;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;
import com.wsf.service.GagService;
import com.wsf.service.PostHeadService;
import com.wsf.service.PostService;
import com.wsf.service.UserService;
import com.wsf.util.Tool;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService us;
	@Autowired
	private PostHeadService phs;
	@Autowired
	private PostService ps;
	@Autowired
	private GagService gs;
	
	@RequestMapping(value={"/posthead"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostHeadsByUid(HttpServletRequest request,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		PostHead hd=new PostHead();
		hd.setLz(user);
		hd.setIsDel(PostHead.DEL);
		int i=1;
		Page page=new Page(i);
		List<PostHead> l=null;
		l=phs.getPostHeadByPage(hd,page);
		page.setUrl("/admin/posthead");
		model.addAttribute("PostHeadList",l);
		model.addAttribute("page", page);
		return "adminposthead";
	}
	
	@RequestMapping(value={"posthead/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostHeadsByUidByPage(HttpServletRequest request,
			@PathVariable("pn")String pn,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		PostHead hd=new PostHead();
		hd.setLz(user);
		hd.setIsDel(PostHead.DEL);
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<PostHead> l=null;
		l=phs.getPostHeadByPage(hd,page);
		page.setUrl("/admin/posthead");
		model.addAttribute("PostHeadList",l);
		model.addAttribute("page", page);
		return "adminposthead";
	}
	
	
	@RequestMapping(value={"/reply"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostsByUid(HttpServletRequest request,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		
		Post post=new Post();
		//post.setPostType(Post.REPLYTOUSER);
		post.setIsDel(Post.DEL);
		int i=1;
		Page page=new Page(i);
		List<Post> l=null;
		l=ps.getPostByPage(post, page);
		page.setUrl("/admin/reply");
		model.addAttribute("PostList",l);
		model.addAttribute("page", page);
		return "adminreply";
	}
	
	
	@RequestMapping(value={"/reply/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostsByUidByPage(HttpServletRequest request,
			@PathVariable("pn")String pn,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		
		Post post=new Post();
		//post.setPostType(Post.REPLYTOUSER);
		post.setIsDel(Post.DEL);
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<Post> l=null;
		l=ps.getPostByPage(post, page);
		page.setUrl("/admin/reply");
		model.addAttribute("PostList",l);
		model.addAttribute("page", page);
		return "adminreply";
	}
	
	
	@RequestMapping(value={"/gaguser"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getGagUsersByUid(HttpServletRequest request,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		
		Gag gag=new Gag();
		gag.setGagType(Gag.GAG);
		
		int i=1;
		Page page=new Page(i);
		List<Gag> l=null;
		l=gs.getGagByPage(gag, page);
		page.setUrl("/admin/gaguser");
		model.addAttribute("GagList",l);
		model.addAttribute("page", page);
		return "admingaguser";
	}
	
	
	@RequestMapping(value={"/gaguser/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getGagUsersByUidByPage(HttpServletRequest request,
			String pn,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		
		Gag gag=new Gag();
		gag.setGagType(Gag.GAG);
		
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<Gag> l=null;
		l=gs.getGagByPage(gag, page);
		page.setUrl("/admin/gaguser");
		model.addAttribute("GagList",l);
		model.addAttribute("page", page);
		return "admingaguser";
	}
	

}
