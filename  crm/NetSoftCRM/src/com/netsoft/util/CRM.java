package com.netsoft.util;

import java.util.HashSet;

/**
 * 
 * @作者 杨飞（猪崽崽）
 * @工程名 NetSoftCRM
 * @文件名 CRM.java
 * @编写日期 Dec 23, 2006
 * @功能说明 这个类专门用来放项目要用到的各种静态常量与静态方法 写静态常量的时候。请用文档注解标明作用
 */
public class CRM {
	/** 用来标识用户是否有权限登录的名字 */
	public static final String LOGIN_ROLES = "登录角色";
	/**
	 * 是否有权限进行客户名称，电话修改的 权限ID
	 */
	public static final int MODI_CUSTOMER_NAME_ID = 23;
	/**
	 * 是否有权限进行撤消客户的彻底删除操作的 权限ID
	 */
	public static final int DEL_CUSTOMER_TRUE_ID = 25;
	
	/**
	 * 是否有权限进行论坛，留言的管理
	 */
	public static final int BBS_MANAGE_ID=26;
	/**
	 * 是否有权限查看所有人的内网反馈信息报表
	 */
	public static final int VIEW_FEEDBACK_ID=28;
	
	/**
	 * 是否有权限删除客户反馈信息
	 */
	public static final int DEL_FEEDBACK_ID=31;
	/**
	 * 每面记录数，用于分页
	 */
	public static final int PAGE_SIZE=20;
	
	/**
	 * BBS每页显示的记录数
	 */
	public static final int BBS_PAGE_SIZE=10;
	/**
	 * 流言本的固定编号
	 */
	public static final int NOTE_BOOK_ID=1;
	
	
	public int getTopInt(double num)
	{
		
		return 0;
	}
}
