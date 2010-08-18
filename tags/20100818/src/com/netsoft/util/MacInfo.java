package com.netsoft.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.netsoft.exception.BusinessException;

/**
 * 取机器的网卡mac地址
 * 
 * @author yangfei
 * 
 */
public class MacInfo {

	private static Logger log = Logger.getLogger(MacInfo.class);

	public static String getMacNo() throws BusinessException {
		String os = System.getProperty("os.name");
		try {
			if (os.startsWith("Windows")) {
				return getMacByWindows();
			} else if (os.startsWith("Linux")) {
				return getMacByLinux();
			} else {
				// 未知的操作系统，暂不支持
				return null;
			}
		} catch (BusinessException e) {
			throw e;
		} catch (Exception ex) {
			log.error("MacInfo.getMacNo未知错误!", ex);
			throw new BusinessException("MacInfo.getMacNo未知错误!", ex);
		}

	}

	private static String getMacByWindows() throws BusinessException {
		String command = "cmd.exe /c ipconfig /all";
		String address = "";
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(proc
					.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("Physical Address") > 0) {
					int index = line.indexOf(":");
					index += 2;
					address = line.substring(index);
					break;
				}
			}
			br.close();
			
			return address.trim();

		} catch (IOException e) {
			log.error("MacInfo.getMacByWindows出错!", e);
			throw new BusinessException("MacInfo.getMacByWindows出错!", e);
		}
	}

	private static String getMacByLinux() throws BusinessException {
		String command = "/bin/sh -c ifconfig -a";
		String address = "";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(p
					.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("HWaddr") > 0) {
					int index = line.indexOf("HWaddr") + "HWaddr".length();
					address = line.substring(index);
					break;
				}
			}
			br.close();
			return address.trim();
		} catch (IOException e) {
			log.error("MacInfo.getMacByLinux!", e);
			throw new BusinessException("MacInfo.getMacByLinux出错!", e);
		}

	}

}
