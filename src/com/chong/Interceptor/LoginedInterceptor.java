package com.chong.Interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginedInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("����springmvc������");
		Object user = request.getSession().getAttribute("username");
		System.out.println("����:"+user);
	    if (user == null) {
	      System.out.println("��δ��¼��������¼ҳ��");
	      // ��ת����¼ҳ��
	      request.getRequestDispatcher("/WEB-INF/jsps/admin/login.jsp").forward(request, response);  
	      return false;
	    }
	    
	    return true;
	  }
	
	}
