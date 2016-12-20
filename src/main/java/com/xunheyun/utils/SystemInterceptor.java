package com.xunheyun.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

	Logger logger = Logger.getLogger(getClass());
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        

		Object object = request.getSession().getAttribute("user");

		if (object == null){
			response.sendRedirect("/login/page");
			return false;
		}

        return super.preHandle(request, response, handler);
    }
}
