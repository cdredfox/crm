package com.netsoft.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

public class MySqlData {

	/**
	 * ���ݼ���һ��sql�ļ��Ƿ�����������ļ��õ�һ���жϷ������Ѹ�sql�ļ��ֱ��ü��±���ultra
	 * edit�򿪣�������������ľ�����û�����룬����������������Դ�ļ�������sql�ļ��ı����ʽ��Σ�Ҳ����db�ı����ʽ��Σ�
	 */
	public String backup(String path) {

		String user = "root"; // ���ݿ��ʺ�
		String password = "snnuiabc"; // ��½����
		String database = "crm"; // ��Ҫ���ݵ����ݿ���
		String filepath = path + "crm" + ConsoleDate.Date2String(new Date())
				+ ".sql"; // ���ݵ�·����ַ

		String stmt1 = "mysqldump " + database + " -u " + user + " -p"
				+ password + " --default-character-set=UTF8 --result-file="
				+ filepath;
		// --default-character-set�����Ϊ�㰲װ���ݿ�ʱ��ѡ������ԣ�����˵�㰲װMySQL���õ�Ĭ�ϵ�UTF-8�����
		// ����ΪUTF8������gb2312�Ļ�Ӧ��Ϊgb2312,��������ò��ԵĻ�������ultraedit��������ݺ��sql�ļ�ʱ��
		// ���Ĳ�����ʾ���롣

		try {
			Runtime.getRuntime().exec(stmt1);
			System.out.println("�����ѵ������ļ�" + filepath + "��");
			return "�ļ����ݳɹ�����ŵ�ַΪ:" + filepath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "�ļ�����ʧ�ܣ������Ի�����ϵ����Ա!";

	}

	/**
	 * ����
	 * 
	 */
	public String load(String path) {

		// �½����ݿ�finacing
		String stmt1 = "mysqladmin -u root -psnnuiabc create crm";
		// -p����ӵ����������
		String stmt2 = "mysql -u root -psnnuiabc crm < " + path;
		String[] cmd = { "cmd", "/c", stmt2 };

		try {
			Runtime.getRuntime().exec(stmt1);
			Runtime.getRuntime().exec(cmd);
			System.out.println("�����Ѵ� " + path + " ���뵽���ݿ���");
			return "�����Ѵ� " + path + " ���뵽���ݿ���!��������������";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "���ݻָ�ʧ�ܣ������Ի�����ϵ����Ա";

	}
}
