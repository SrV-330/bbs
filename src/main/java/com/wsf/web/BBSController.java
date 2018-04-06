package com.wsf.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wsf.entity.Page;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;
import com.wsf.service.PostHeadService;
import com.wsf.service.UserService;
import com.wsf.util.Tool;


@Controller
@RequestMapping("/")
public class BBSController {
	
	@Autowired
	private PostHeadService phs;
	
	@Autowired
	private UserService us;
	
	
	@RequestMapping(value={"/home"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String home(
			Model model,
			HttpServletRequest request
			){
		int i=1;
		Page page=new Page(i);
		page.setUrl("/home");
		System.out.println("page="+page.getCurrentPage());
		List<PostHead> l=null;
		l=phs.getPostHeadByPage(page);
		
		model.addAttribute("PostHeadList", l);
		model.addAttribute("page",page);
		
		return "home";
	}
	@RequestMapping(value={"/home/{pn}"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String homeByPage(
			@PathVariable(value="pn")String pn, 
			Model model,
			HttpServletRequest request
			){
		int i=1;
		
		
		if(!Tool.isNullOrEmpty(pn)){
			i=Integer.parseInt(pn);
		}
		Page page=new Page(i);
		page.setUrl("/home");
		System.out.println("page="+page.getCurrentPage());
		List<PostHead> l=null;
		l=phs.getPostHeadByPage(page);
		
		model.addAttribute("PostHeadList", l);
		model.addAttribute("page",page);
		
		return "home";
	}
	
	@RequestMapping(value={"/","/index.html","/index"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String test(){
		return "index";
	}

	@RequestMapping(value={"/notfound404"},
			method={RequestMethod.GET,RequestMethod.POST})
	public String notFound404(){
		return "notfound404";
	}
	
}
