package com.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	private List<String> allowedPath;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("...before...");
		
		// 如果配置了路径，直接到达主页，如果没有配置允许访问的路径则跳转到登陆页面
		String url = request.getRequestURI().toString();
		System.out.println(url);
		for(String path:allowedPath){
			if(url.endsWith(path)){
				return true;
			}
		}
		
		response.sendRedirect("redirect:/login.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("...after...");

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("...done...");
	}
	
	public void setAllowedPath(List allowedPath) {
		this.allowedPath = allowedPath;
	}

}
