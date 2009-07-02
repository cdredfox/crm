package com.netsoft.services.test;

import java.util.List;

import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.services.intf.IEmployeeServices;
import com.netsoft.test.framework.SuperTestCase;

public class TestEmployeeServices extends SuperTestCase {

	@Override
	public void testMethod() throws Exception {
		IEmployeeServices qemployee=(IEmployeeServices) context.getBean("IEmployeeServices");
		IEmployeeDao employee=(IEmployeeDao) context.getBean("IEmployeeDao");
		List list=qemployee.getEmployeesByTopId(48);
		Integer[] i={49,50};
		//employee.batchUpdateEmployye(i, 48);
		System.out.println(list.size());
	}

}
