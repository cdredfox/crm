package com.netsoft.util;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
public class CheckUser {
	private static Logger log=Logger.getLogger(CheckUser.class);
	public static String JUMP_URL="logout";
	public static boolean checkSession(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		if(session.getAttribute("Employees")==null)
		{
			request.setAttribute("message","<font color='red'>�Բ���!���ĵ�¼�Ѿ�ʧЧ,�����µ�¼���в���</font>");
			return false;
		}
		return true;
	}

}
