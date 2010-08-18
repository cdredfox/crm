package com.netsoft.test.framework;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public abstract class SuperTestCase extends TestCase {

	public ApplicationContext context=null;
	@Override
	protected void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","servicesContext.xml"});
	}

	@Override
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	protected abstract void testMethod() throws Exception;
}
