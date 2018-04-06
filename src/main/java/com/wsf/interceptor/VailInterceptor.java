package com.wsf.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.wsf.entity.Gag;
import com.wsf.entity.User;
import com.wsf.eto.LoginJson;
import com.wsf.service.GagService;

public class VailInterceptor implements HandlerInterceptor {

	@Autowired
	private GagService gag; 
	
	@Autowired
	private LoginJson lj;
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView view)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");
		List<Gag> l=null;
		if(user==null){
			lj.setErr("用户未登录！");
			lj.setRes("-1");
			response.setContentType("application/json; charset=utf-8");
			String json=JSONObject.toJSONString(lj);
			response.getWriter().write(json);
			return false;
		}
		l=gag.getTopGagByGuid(Long.toString(user.getUid()));
		if(l!=null&&l.size()>0){
			
			gag.ungagUser(user, l.get(0));
		}
		
		return true;
	}

}
