package com.netsoft.exception;

/**
 * 封装的业务异常类
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
