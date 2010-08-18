package com.netsoft.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;

public class CurrentPages {
	public static List CurrentPage(int page,int size,List list)
	{
		try {
			if(page*size>list.size())
			{
			 return list.subList((page*size)-size,list.size());
			}
			return list.subList((page*size)-size,page*size);
		} catch (Exception e) {
			return null;
		}
		
	}
	
//	public static void main(String[] args) {
//		List list=new ArrayList();
//		for(int i=0;i<100;i++)
//		{
//			list.add(i);
//		}
//	     
//		CurrentPages cp=new CurrentPages();
//		List<Integer> li=cp.CurrentPage(2, 3, list);
//		for (Integer integer : li) {
//			System.out.println(integer);
//		}
//	}
}
