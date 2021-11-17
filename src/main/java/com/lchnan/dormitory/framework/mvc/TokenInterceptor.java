package com.lchnan.dormitory.framework.mvc;

import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.framework.exception.exc;
import com.lchnan.dormitory.framework.jwt.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader(JwtUtil.token);
		//根据token获取用户对象
		User user = JwtUtil.getUser(token);
		if(user == null){
			throw new exc("超时或不合法的token");
		}
		String newToken = JwtUtil.sign(user);
		response.setHeader(JwtUtil.token,newToken);
		request.setAttribute("user",user);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
