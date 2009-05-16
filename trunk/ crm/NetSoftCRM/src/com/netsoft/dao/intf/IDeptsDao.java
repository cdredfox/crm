package com.netsoft.dao.intf;

import java.io.Serializable;
import java.util.List;

import com.netsoft.dao.pojos.Depts;

/**
 * 
 * @功能说明　根据传进来的部门对象取得相应的POJO对象
 * @返回类型　boolean
 * @param depts
 * @return 
 */
public interface IDeptsDao {
	/*添加一个部门*/
	public abstract boolean addDept(Depts depts);
	/*删除一个部门*/
	public abstract boolean deleteDept(Depts depts);
	/*根据id删除部门*/
	public abstract boolean deleteDeptById(Class cl,Serializable id);
	/*修改一个部门*/
	public abstract boolean updateDept(Depts depts);
	/*获取所有部门*/
	public List<Depts> getAllDepts();
	/**根据部门ID查找部门对象*/
	public Depts getDeptsById(int id);
	
	/**
	 * 根据员工查找其所属的部门
	 * @param id
	 * @return
	 */
	public List getDeptsByEid(int id);
}
