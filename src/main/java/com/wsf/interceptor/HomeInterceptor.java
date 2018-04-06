package com.wsf.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wsf.entity.Page;
import com.wsf.entity.PostHead;
import com.wsf.service.PostHeadService;

public class HomeInterceptor implements HandlerInterceptor {

	
	@Autowired
	private PostHeadService phs;
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		
		List<PostHead> l=null,l1=null;
		PostHead hd=new PostHead();
		hd.setIsGood(PostHead.GOOD);
		Page page=new Page(1);
		l=phs.getPostHeadByPage(hd, page);
		
		hd=new PostHead();
		hd.setIsTop(PostHead.TOP);
		l1=phs.getPostHeadByPage(hd, page);
		request.setAttribute("HotPostHeadList", l);
		request.setAttribute("TopPostHeadList", l1);
		return true;
	}

}
