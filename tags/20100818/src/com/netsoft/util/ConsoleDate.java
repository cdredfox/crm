package com.netsoft.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * 
 * @作者 　　杨飞（猪崽崽）
 * @工程名　NetSoftCRM
 * @文件名　ConsoleDate.java
 * @编写日期　Dec 23, 2006
 * @功能说明　对日期进行操作的各种转换操作的工具类
 */
public class ConsoleDate {
    /**
     * 
     * @功能说明　把传进来的字符串转换成对应的日期 
     *   	    请注意字符格式为：yyyy-mm-dd
     * @返回类型　Date
     * @param str1
     * @return
     */ 
	public static Date String2Date(String str1)
     {
          try {
        	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        	return sf.parse(str1);
        } catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
     }
	
	/**
	 * 
	 * @功能说明　把传进来的日期转换为对应格式的字符串 yyyy-MM-dd
	 * @返回类型　String
	 * @param date
	 * @return
	 */
	public static String Date2String(Date date)
	{
		try {
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			return sf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
     * 日期增加
     * @param isoString 日期字符串
     * @param fmt 格式
     * @param field 年/月/日 Calendar.YEAR/Calendar.MONTH/Calendar.DATE
     * @param amount 增加数量
     * @return
     * @throws ParseException
     */
    public static final Date dateIncrease(String isoString,int field, int amount)
    {

        try
        {
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(String2Date(isoString));
            cal.add(field, amount);
            return cal.getTime();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    
    /**
     * 求两个日期之间相差的天数
     * @param curDate 要比较的日期
     * @param endDate 做为对比的日期
     * @return
     */
    public static int getDateDay(Date curDate,Date endDate)
    {
    	Long cur=curDate.getTime();
    	Long end=endDate.getTime();
    	int day=(int) ((end-cur)/(1000*60*60*24));
    	return day;
    }
    /**
     * 得到中国时区的系统时间 XP补丁后会有一个BUG,会默认得到的是GMT+0的时间，所以要这
     * 这样取，才对。因为要修改注册表，不可能让每个用户修改，所以在这里强制使用GMT+8
     * @return
     */
    public static Date getChineseCurrentDate(){
    	TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		TimeZone.setDefault(tz);
		return new Date();
    }
    
}
