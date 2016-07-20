package dao;

import java.util.List;

import bean.Customer;
public interface CustomerDao {
	/**
	 * 查询所有的用户信息
	 */
	public List<Customer>  findAll();
	/**
	 *查询一个用户信息
	 */
	public Customer findOne(int CustomerId);
	
	/**
	 * 增加用户信息
	 */
	public int add(Customer customer);
	
	/**
	 * 删除用户信息
	 */
	
	public boolean del(Customer customer);
	/**
	 * 修改用户信息
	 */
	
	public boolean update(Customer customer);
	
}