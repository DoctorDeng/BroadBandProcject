package dao;

import java.util.List;

import bean.Oslogin;

public interface OsLoginDao {

	public List<Oslogin> findAll();
	/*
	 * 查找所有os账号
	 */
	
	public Oslogin findOne(int osloginId);
	/*
	 * 查找一个os账号
	 */
	
	public boolean add(Oslogin oslogin);
	/*
	 * 添加一个os账号
	 */
	public boolean del(int osloginId);
	/*
	 * 删除一个os账号
	 */
	
	public boolean update(Oslogin oslogin);
	/*
	 * 修改os账号
	 */
	
}
