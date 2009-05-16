package com.netsoft.exception;

/**
 * ��װ��ҵ���쳣��
 * @author yangfei
 *
 */
public class BusinessException extends Exception {
	
	public BusinessException()
	{
		super();
	}
	
	public BusinessException(String message)
	{
		super(message);
	}

	public BusinessException(String message,Throwable throwable)
	{
		super(message,throwable);
	}
	
	public BusinessException(Throwable throwable)
	{
		super(throwable);
	}
}
