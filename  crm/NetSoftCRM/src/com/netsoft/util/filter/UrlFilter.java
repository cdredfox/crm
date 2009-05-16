package com.netsoft.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class UrlFilter extends HttpServlet implements Filter {
	  private FilterConfig filterConfig;
	Logger logger=Logger.getLogger(this.getClass());
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		try {
			logger.info("request中的值是: "+request.getParameter("taget"));
			logger.info("request中的menuid值是: "+request.getParameter("menuid"));
			HttpServletRequest sr = (HttpServletRequest)request;
            HttpSession session = sr.getSession();    //获得session
           logger.info("请求地址是:"+sr.getRequestURI().toString());
           if(sr.getParameter("taget")!=null);
           {
        	   request.setAttribute("menus",sr.getParameter("taget"));
           }
           
           if(sr.getParameter("menuid")!=null)
           {
        	   session.setAttribute("mid",sr.getParameter("menuid"));
           }
           
           //判断用户是否登录，如果没有，
           if(session.getAttribute("Employees")==null){
                    
                    //获锝当前的URL
                    String strURL=sr.getRequestURL().toString();
                    
                    //判断是否为index.jsp                     
                    if(strURL.indexOf("login.jsp") == -1 && strURL.indexOf("url_mid_jump.jsp")==-1){
                    	logger.info("没有登陆并且请求的不是login.jsp页面。拦截强制转发到跳转页面");  
                            try {
                            ((HttpServletRequest)request).getRequestDispatcher("jsp/url_mid_jump.jsp").forward(request, response);  //转发到跳转页面让用户登录
                              filterChain.doFilter(request, response);
                              return;
                            }
                            catch (ServletException sx) {
                              filterConfig.getServletContext().log(sx.getMessage());
                            }
                            catch (IOException iox) {
                              filterConfig.getServletContext().log(iox.getMessage());
                            }
                            
                    }
                 
            }      
            
		logger.info("url拦截成功过滤地址");
		filterChain.doFilter(request, response);
		} catch (Exception e) {
		logger.error("url拦截器运行失败了！",e);
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("修复bug");
		this.filterConfig = arg0;
	}
}
