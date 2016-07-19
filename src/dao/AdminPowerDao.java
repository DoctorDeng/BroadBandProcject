package dao;

import java.util.List;

import bean.AdminPower;

public interface AdminPowerDao {
	/**
	 * 查找所有管理员的权限
	 * @return
	 */
	public List<AdminPower> findAll();
	/**
	 * 修改管理员的权限
	 */
	public boolean update(AdminPower adminpower);
	
	/**
	 * 删除管理员的权限
	 */
	
	public boolean del(AdminPower adminpower);
	
	/**
	 * 增加管理员权限
	 */
	public boolean add(AdminPower adminpower);
}
