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
				throw new ServletException("读取版本验证文件出错!版本验证为NULL");
			} else {
				if(!MD5.isPassword(MacInfo.getMacNo(), prop.getProperty("Mac")))
				{
					log.error("在非授权机器上使用本系统!请联系相关人员");
					throw new ServletException("在非授权机器上使用本系统！请联系相关人员");
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
						log.error("您的试用版本已经过期了！请联系相关人员");
						throw new ServletException("您的试用版本已经过期了！请联系相关人员");
					}

				}
			}
		} catch (BusinessException e) {
			throw new ServletException("主Action初始化方法出错", e);
		} catch (Exception e) {
			throw new ServletException("主Action未知错误", e);
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
			log.error("加载版本验证文件出错！文件不存在", e);

		} catch (IOException e) {
			log.error("加载版本验证文件出错！文件读取出错", e);
			e.printStackTrace();
		}
		return null;

	}

}
