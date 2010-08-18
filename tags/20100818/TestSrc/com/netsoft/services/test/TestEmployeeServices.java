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
		assertEquals(4, list.size());
		Integer topId=48;
		Integer[] eids=new Integer[]{50,51,53};
		boolean flag=qemployee.batchUpdateEmployye(eids, topId);
		assertEquals(true, flag);
		list=qemployee.getEmployeesByTopId(48);
		assertEquals(3, list.size());
	}

}
