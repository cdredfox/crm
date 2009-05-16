package com.netsoft.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 
 * @���� ������ɣ������̣�
 * @��������NetSoftCRM
 * @�ļ�����ConsoleDate.java
 * @��д���ڡ�Dec 23, 2006
 * @����˵���������ڽ��в����ĸ���ת�������Ĺ�����
 */
public class ConsoleDate {
    /**
     * 
     * @����˵�����Ѵ��������ַ���ת���ɶ�Ӧ������ 
     *   	    ��ע���ַ���ʽΪ��yyyy-mm-dd
     * @�������͡�Date
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
	 * @����˵�����Ѵ�����������ת��Ϊ��Ӧ��ʽ���ַ��� yyyy-MM-dd
	 * @�������͡�String
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
     * ��������
     * @param isoString �����ַ���
     * @param fmt ��ʽ
     * @param field ��/��/�� Calendar.YEAR/Calendar.MONTH/Calendar.DATE
     * @param amount ��������
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
     * ����������֮����������
     * @param curDate Ҫ�Ƚϵ�����
     * @param endDate ��Ϊ�Աȵ�����
     * @return
     */
    public static int getDateDay(Date curDate,Date endDate)
    {
    	Long cur=curDate.getTime();
    	Long end=endDate.getTime();
    	int day=(int) ((end-cur)/(1000*60*60*24));
    	return day;
    }
}
