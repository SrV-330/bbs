package com.wsf.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
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
import com.wsf.eto.LoginJson;
import com.wsf.service.PostHeadService;
import com.wsf.service.PostService;
import com.wsf.service.UserService;
import com.wsf.service.ZanService;
import com.wsf.util.Tool;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService us;
	@Autowired
	private ZanService zs;
	@Autowired
	private PostHeadService phs;
	@Autowired
	private PostService ps;
	
	@RequestMapping(value="/login",
			method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public LoginJson login(@RequestParam(value= "userName",required=false)String userName,
			@RequestParam(value="userPwd",required=false)String userPwd,
			@RequestParam(value="isrem",required=false)String isrem,
			HttpServletResponse response,
			ModelMap modelMap,
			HttpServletRequest request
			){
		
		LoginJson lj=new LoginJson("0", "服务器错误");
		
		User user=null;

		if(request.getSession().getAttribute("user")!=null){
			lj=new LoginJson("1","欢迎回来");
			return lj;
			
		}
		user=us.queryUserByNameAndPwd(userName, userPwd);
		if(user!=null){
			
			request.getSession().setAttribute("user", user);
			if(isrem!=null){
				Cookie c=new Cookie("userPwd",user.getUserPwd());
				c.setMaxAge(50*365*24*60*60*1000);
				c.setPath("/");
				
				response.addCookie(c);
				c=new Cookie("userName", user.getUserName());
				c.setMaxAge(50*365*24*60*60*1000);
				c.setPath("/");
				response.addCookie(c);
			}
			lj=new LoginJson("1","欢迎回来");

			return lj;
		}else{
			lj=new LoginJson("2","用户名或密码错误!");
			return lj;

		}
		
	}
	
	
	@RequestMapping(value="/autologin",
			method={RequestMethod.POST,RequestMethod.GET})
	public String autoLogin(
			@CookieValue(value="userName",required=false)String userName,
			@CookieValue(value="userPwd",required=false)String userPwd,
			HttpServletRequest request,
			HttpServletResponse response){
		
		User user=null;
		if(!Tool.isNullOrEmpty(userName,userPwd)){
			user=us.queryUserByNameAndPwd(userName, userPwd);
			if(user!=null){
				request.getSession().setAttribute("user", user);
				System.out.println(user);
				Cookie c=new Cookie("userPwd",user.getUserPwd());
				c.setMaxAge(50*365*24*60*60*1000);
				c.setPath("/");
				
				response.addCookie(c);
				c=new Cookie("userName", user.getUserName());
				c.setMaxAge(50*365*24*60*60*1000);
				c.setPath("/");
				response.addCookie(c);
				
				return "forward:/home";
			}
		}
		
		
		
		return "redirect:/home";
		
	}
	
	
	
	@RequestMapping(value="/logoff",
			method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public LoginJson logoff(
			HttpServletRequest request,HttpServletResponse response){
		
		LoginJson lj=new LoginJson("0", "服务器错误！");
		if(request.getSession().getAttribute("user")!=null){
			
			/*Cookie c=new Cookie("userPwd",null);
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);
			c=new Cookie("userName", null);
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);*/
			
			request.getSession().removeAttribute("user");
			lj.setErr("已退出！");
			lj.setRes("1");
			return lj;
			
		}
		return lj;
		
		
		
	}
	
	@RequestMapping(value="/gotoreg",
			method={RequestMethod.POST,RequestMethod.GET})
	public String gotoRegister(){
		return "reg";
	}
	
	
	@RequestMapping(value="/reg",
			method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public LoginJson register(@RequestBody User user){
		int i=0;
		LoginJson rj=new LoginJson("0", "服务器错误！");
		if(user!=null&&!Tool.isNullOrEmpty(user.getUserName(),user.getUserPwd())){
			if(user.getUserName().trim().length()>7
					||user.getUserPwd().length()<3
					||user.getUserPwd().length()>16){
				rj.setErr("用户名或密码错误！");
				return rj;
			}
			
			//user.setUserType(User.USER);
			//user.setRegTime(sdf.format(new Date()));
			//user.setIsGag(User.UNGAG);
			i=us.addUser(user.getUserName().trim(), user.getUserPwd());
			if(i>0){
				rj.setRes(Integer.toString(i));
				rj.setErr("注册成功！");
				return rj;
			}
			rj.setRes(Integer.toString(i));
			rj.setErr("注册失败！");
			return rj;
		}
		rj.setErr("用户名或密码错误！");
		return rj;
	}
	
	@RequestMapping(value="/vailregname",
			method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public LoginJson vailRegName(@RequestBody User user){
		LoginJson rj=new LoginJson("0", "服务器错误！");
		User u=null;
		if(user!=null&&!Tool.isNullOrEmpty(user.getUserName())){
			u=us.queryUserByName(user.getUserName().trim());
			if(u!=null){
				rj.setRes("2");
				
				rj.setErr("此用户已存在！");
				return rj;
			}
			rj.setRes("1");
			rj.setErr("");
		}
		return rj;
		
	}
	
	@RequestMapping(value={"/zan"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getZansByUid(HttpServletRequest request,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		Zan zan=new Zan();
		zan.setZu(user);
		int i=1;
		Page page=new Page(i);
		List<Zan> l=null;
		l=zs.getZanByPage(zan, page);
		page.setUrl("/user/zan");
		model.addAttribute("ZanList",l);
		model.addAttribute("page", page);
		return "userzan";
	}
	
	
	@RequestMapping(value={"/zan/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getZansByUidByPage(HttpServletRequest request,
			@PathVariable("pn")String pn,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		Zan zan=new Zan();
		zan.setZu(user);
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<Zan> l=null;
		l=zs.getZanByPage(zan, page);
		page.setUrl("/user/zan");
		model.addAttribute("ZanList",l);
		model.addAttribute("page", page);
		return "userzan";
	}
	
	
	
	
	@RequestMapping(value={"/posthead"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostHeadsByUid(HttpServletRequest request,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		PostHead hd=new PostHead();
		hd.setLz(user);
		hd.setIsDel(PostHead.UNDEL);
		int i=1;
		Page page=new Page(i);
		List<PostHead> l=null;
		l=phs.getPostHeadByPage(hd,page);
		page.setUrl("/user/posthead");
		model.addAttribute("PostHeadList",l);
		model.addAttribute("page", page);
		return "userposthead";
	}
	
	@RequestMapping(value={"posthead/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostHeadsByUidByPage(HttpServletRequest request,
			@PathVariable("pn")String pn,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		PostHead hd=new PostHead();
		hd.setLz(user);
		hd.setIsDel(PostHead.UNDEL);
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<PostHead> l=null;
		l=phs.getPostHeadByPage(hd,page);
		page.setUrl("/user/posthead");
		model.addAttribute("PostHeadList",l);
		model.addAttribute("page", page);
		return "userposthead";
	}
	
	
	@RequestMapping(value={"/reply"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostsByUid(HttpServletRequest request,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		
		Post post=new Post();
		post.setRpu(user);
		post.setIsDel(Post.UNDEL);
		int i=1;
		Page page=new Page(i);
		List<Post> l=null;
		l=ps.getPostByPage(post, page);
		page.setUrl("/user/reply");
		model.addAttribute("PostList",l);
		model.addAttribute("page", page);
		return "userreply";
	}
	
	@RequestMapping(value={"/reply/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String getPostsByUidByPage(HttpServletRequest request,
			@PathVariable("pn")String pn,
			Model model){
		User user=(User)request.getSession().getAttribute("user");
		
		Post post=new Post();
		post.setRpu(user);
		post.setIsDel(Post.UNDEL);
		int i=1;
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		List<Post> l=null;
		l=ps.getPostByPage(post, page);
		page.setUrl("/user/reply");
		model.addAttribute("PostList",l);
		model.addAttribute("page", page);
		return "userreply";
	}
	
	
	
	
	@RequestMapping(value="/test",
			method={RequestMethod.GET,RequestMethod.POST})
	public String test(){
		return "index";
	}
}
