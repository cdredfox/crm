package com.netsoft.util;

public class ArraysCopy {
	public static int size=0;
	public static Object[] copy(Object[] taget,Object[] source)
	{
		 for(int i=0;i<source.length;i++)
		 {
			 taget[size]=source[i];
			 size++;
		 }
		 return taget;
	}
	
	public static void main(String[] args) {
		Integer[] taget=new Integer[10];
		Integer[] a=new Integer[]{1,2,3,4};
		Integer[] b=new Integer[]{5,6,7,8};
		ArraysCopy.copy(taget, a);
		ArraysCopy.copy(taget, b);
		
		for(int i=0;i<taget.length;i++)
		 {
			System.out.println(taget[i]);
		 }
	}
}
