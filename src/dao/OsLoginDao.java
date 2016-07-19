package dao;

import java.util.List;

import bean.Oslogin;

public interface OsLoginDao {

	/**
	 * 查找所有os账号
	 */
	public List<Oslogin> findAll();

	/**
	 * 查找一个os账号
	 * @param osloginId
	 * @return
	 */
	public Oslogin findOne(int osloginId);
	
	
	/**
	 * 添加一个os账号
	 * @param oslogin
	 * @return
	 */	
	public boolean add(Oslogin oslogin);
	
	
	/**
	 *  删除一个os账号
	 */
	public boolean del(int osloginId);
	
	
	/**
	 *修改os账号
	 */
	public boolean update(Oslogin oslogin);
	
	
	
	
}
