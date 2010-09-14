package com.netsoft.util;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

public class MySqlData {
    private Logger log=Logger.getLogger(this.getClass());
	/**
	 * 备份检验一个sql文件是否可以做导入文件用的一个判断方法：把该sql文件分别用记事本和ultra
	 * edit打开，如果看到的中文均正常没有乱码，则可以用来做导入的源文件（不管sql文件的编码格式如何，也不管db的编码格式如何）
	 */
	public String backup(String path) {

		String mysqlPath="D:\\CRM\\MySql\\bin\\";
		String user = "root"; // 数据库帐号
		String password = "snnuiabc"; // 登陆密码
		String database = "crm"; // 需要备份的数据库名
		String filepath = path + "crm" + ConsoleDate.Date2String(new Date())
				+ ".sql"; // 备份的路径地址

		String stmt1 = mysqlPath+"mysqldump " + database + " -u " + user + " -p"
				+ password + " --default-character-set=UTF8 --result-file="
				+ filepath;
		// --default-character-set这儿设为你安装数据库时所选择的语言，比如说你安装MySQL里用的默认的UTF-8，这儿
		// 就设为UTF8，若是gb2312的话应设为gb2312,如果这儿设得不对的话，你用ultraedit打开这个备份后的sql文件时，
		// 中文部分显示乱码。

		try {
			Runtime.getRuntime().exec(stmt1);
			System.out.println("数据已导出到文件" + filepath + "中");
			return "文件备份成功！存放地址为:" + filepath;
		} catch (Exception e) {
			log.error("数据库备份失败：",e);
			e.printStackTrace();
		}
		return "文件备份失败，请重试或者联系管理员!";

	}

	/**
	 * 导入
	 * 
	 */
	public String load(String path) {

		String mysqlPath="D:\\CRM\\MySql\\bin\\";
		// 新建数据库
		String stmt1 =  mysqlPath+"mysqladmin -u root -psnnuiabc create crm";
		// -p后面加的是你的密码
		String stmt2 = mysqlPath+"mysql -u root -psnnuiabc crm < " + path;
		String[] cmd = { "cmd", "/c", stmt2 };

		try {
			Runtime.getRuntime().exec(stmt1);
			Runtime.getRuntime().exec(cmd);
			System.out.println("数据已从 " + path + " 导入到数据库中");
			return "数据已从 " + path + " 导入到数据库中!请重启服务器！";
		} catch (Exception e) {
			log.error("数据库还原失败：",e);
			e.printStackTrace();
		}
		return "数据恢复失败！请重试或者联系管理员";

	}
}
