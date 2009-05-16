package com.netsoft.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;

import com.netsoft.exception.BusinessException;
import com.netsoft.util.ConsoleDate;
import com.netsoft.util.MD5;
import com.netsoft.util.MacInfo;

public class CRMActionServlet extends ActionServlet {

	@Override
	public void init() throws ServletException {
		try {
			Properties prop = getVersion();
			if (prop == null) {
				throw new ServletException("��ȡ�汾��֤�ļ�����!�汾��֤ΪNULL");
			} else {
				if(!MD5.isPassword(MacInfo.getMacNo(), prop.getProperty("Mac")))
				{
					log.error("�ڷ���Ȩ������ʹ�ñ�ϵͳ!����ϵ�����Ա");
					throw new ServletException("�ڷ���Ȩ������ʹ�ñ�ϵͳ������ϵ�����Ա");
				}
				if ("no".equals(prop.getProperty("lastDate"))) {
					super.init();
				} else {
					String date = prop.getProperty("lastDate");
					int day = ConsoleDate.getDateDay(new Date(), ConsoleDate
							.String2Date(date));
					if (day >= 0) {
						super.init();
					} else {
						log.error("�������ð汾�Ѿ������ˣ�����ϵ�����Ա");
						throw new ServletException("�������ð汾�Ѿ������ˣ�����ϵ�����Ա");
					}

				}
			}
		} catch (BusinessException e) {
			throw new ServletException("��Action��ʼ����������", e);
		} catch (Exception e) {
			throw new ServletException("��Actionδ֪����", e);
		}

	}

	private Properties getVersion() {
		Properties prop = new Properties();
		String path = super.getServletContext().getRealPath("/");
		path = path + "/WEB-INF/";
		try {
			prop.load(new FileInputStream(path + "Version.properties"));

			return prop;
		} catch (FileNotFoundException e) {
			log.error("���ذ汾��֤�ļ������ļ�������", e);

		} catch (IOException e) {
			log.error("���ذ汾��֤�ļ������ļ���ȡ����", e);
			e.printStackTrace();
		}
		return null;

	}

}
