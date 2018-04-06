package com.wsf.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsf.entity.PostHead;
import com.wsf.entity.User;
import com.wsf.eto.LoginJson;
import com.wsf.service.PostHeadService;
import com.wsf.service.UserService;

@Controller
@RequestMapping("/posthead")
public class PostHeadController {
	
	@Autowired
	private PostHeadService phs;
	@Autowired
	private UserService us;
	
	@Autowired
	private LoginJson lj;
	
	@RequestMapping(value={"/remove"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson removePostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.deletePostHeadById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.DEL), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("删除成功！");
			return lj;
		}
		
		return lj;
	}
	
	@RequestMapping(value={"/unremove"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson unremovePostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.deletePostHeadById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.UNDEL), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("恢复成功！");
			return lj;
		}
		
		return lj;
	}
	
	
	
	@RequestMapping(value={"/good"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson goodPostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.setGoodById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.GOOD), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("加精成功！");
			return lj;
		}
		
		return lj;
	}
	
	@RequestMapping(value={"/ungood"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson ungoodPostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.setGoodById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.UNGOOD), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("撤销成功！");
			return lj;
		}
		
		return lj;
	}
	
	
	@RequestMapping(value={"/lock"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson lockPostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.lockPostHeadById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.LOCK), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("加锁成功！");
			return lj;
		}
		
		return lj;
	}
	@RequestMapping(value={"/unlock"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson unlockPostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.lockPostHeadById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.UNLOCK), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("撤销成功！");
			return lj;
		}
		
		return lj;
	}
	
	@RequestMapping(value={"/up"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson upPostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.setTopById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.TOP), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("置顶成功！");
			return lj;
		}
		
		return lj;
	}
	
	
	@RequestMapping(value={"/down"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson downPostHeadByHdid(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		i=phs.setTopById(
				Long.toString(hd.getHdid()),
				Integer.toString(PostHead.UNTOP), 
				user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("撤销成功！");
			return lj;
		}
		
		return lj;
	}
	@RequestMapping(value={"/add"},
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson addPostHead(@RequestBody PostHead hd,
			HttpServletRequest request){
		int i=0;
		User user=(User)request.getSession().getAttribute("user");
		user=us.queryUserById(Long.toString(user.getUid()));
		request.getSession().setAttribute("user",user);
		if(user==null||user.getIsGag()==User.GAG){
			lj.setRes("0");
			lj.setErr("用户被禁言！");
			return lj;
		}
		i=phs.addPostHead(hd.getHeadTitle(),hd.getHeadSimple(), hd.getHeadDetail(), user);
		if(i>0){
			lj.setRes("1");
			lj.setErr("发帖成功！");
			return lj;
		}
		
		return lj;
	}
	
	
	
	

}
