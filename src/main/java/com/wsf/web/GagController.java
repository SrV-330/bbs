package com.wsf.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsf.entity.Gag;
import com.wsf.entity.User;
import com.wsf.eto.LoginJson;
import com.wsf.service.GagService;
import com.wsf.service.UserService;

@Controller
@RequestMapping("/gag")
public class GagController {
	
	@Autowired
	private GagService gs;
	@Autowired
	private UserService us;
	
	@Autowired
	private LoginJson lj;
	
	@Autowired
	private SimpleDateFormat sdf;
	
	
	@RequestMapping(value="/gaguser",
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson gagUserByUid(
			@RequestBody Gag gag,
			HttpServletRequest request){
		int i=0;
		Date now=null,to=null;
		User ou=(User)request.getSession().getAttribute("user");
		User gu=null;
		List<Gag> l=null;
		Gag g=null;
		if(ou!=null&&ou.getUserType()==User.ADMIN){
			gu=us.queryUserById(Long.toString(gag.getGu().getUid()));
			if(gu!=null){
				l=gs.getTopGagByGuid(Long.toString(gu.getUid()));
				if(l!=null&&l.size()>0){
					g=l.get(0);	
				}
				
				now=new Date();
				long l1=Long.parseLong(gag.getEndTime())*60L*1000L;
				to=new Date(now.getTime()+l1);
				i=gs.gagUser(gu, ou, g, sdf.format(now), 
						sdf.format(to), 
						Integer.toString(gag.getGagType()), 
						Integer.toString(gag.getGagRs()));
				
				
				
			}
		}
		System.out.println("==============="+i);
		if(i>0){
			lj.setRes("1");
			lj.setErr("禁言用户"+gu.getUserName()+"到"+sdf.format(to)+"!");
		}
		
		return lj;
	}
	
	@RequestMapping(value="/ungaguser",
			method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public LoginJson ungagUserByUid(
			@RequestBody Gag gag,
			HttpServletRequest request){
		int i=0;
		User ou=(User)request.getSession().getAttribute("user");
		User gu=null;
		List<Gag> l=null;
		Gag g=null;
		if(ou!=null&&ou.getUserType()==User.ADMIN){
			gu=us.queryUserById(Long.toString(gag.getGu().getUid()));
			if(gu!=null){
				l=gs.getTopGagByGuid(Long.toString(gu.getUid()));
				if(l!=null&&l.size()>0){
					g=l.get(0);
				}
				i=gs.ungagUser(gu, ou, g);
				
			}
		}
		
		if(i>0){
			lj.setRes("1");
			lj.setErr("解禁用户"+gu.getUserName()+"!");
		}
		
		return lj;
	}
	
	

}
