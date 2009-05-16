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
			logger.info("request�е�ֵ��: "+request.getParameter("taget"));
			logger.info("request�е�menuidֵ��: "+request.getParameter("menuid"));
			HttpServletRequest sr = (HttpServletRequest)request;
            HttpSession session = sr.getSession();    //���session
           logger.info("�����ַ��:"+sr.getRequestURI().toString());
           if(sr.getParameter("taget")!=null);
           {
        	   request.setAttribute("menus",sr.getParameter("taget"));
           }
           
           if(sr.getParameter("menuid")!=null)
           {
        	   session.setAttribute("mid",sr.getParameter("menuid"));
           }
           
           //�ж��û��Ƿ��¼�����û�У�
           if(session.getAttribute("Employees")==null){
                    
                    //��ｵ�ǰ��URL
                    String strURL=sr.getRequestURL().toString();
                    
                    //�ж��Ƿ�Ϊindex.jsp                     
                    if(strURL.indexOf("login.jsp") == -1 && strURL.indexOf("url_mid_jump.jsp")==-1){
                    	logger.info("û�е�½��������Ĳ���login.jspҳ�档����ǿ��ת������תҳ��");  
                            try {
                            ((HttpServletRequest)request).getRequestDispatcher("jsp/url_mid_jump.jsp").forward(request, response);  //ת������תҳ�����û���¼
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
            
		logger.info("url���سɹ����˵�ַ");
		filterChain.doFilter(request, response);
		} catch (Exception e) {
		logger.error("url����������ʧ���ˣ�",e);
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("�޸�bug");
		this.filterConfig = arg0;
	}
}
