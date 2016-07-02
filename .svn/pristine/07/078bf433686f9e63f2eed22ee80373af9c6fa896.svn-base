package com.ideal.spdb.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:验证身份防止非法登录</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-9-1
 * @version 1.0
 */
public class CheckLoginFilter implements Filter {

	public void destroy() {

	}

	/**
	 * 如果是未登录非法访问页面就直接直接跳到登录页面
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		if(null!=session){
			String identityCard = (String) session.getAttribute("identityCard");
			if (Constants.IDENTITYCARD.equals(identityCard)) {
				arg2.doFilter(arg0, arg1);
			} else {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
