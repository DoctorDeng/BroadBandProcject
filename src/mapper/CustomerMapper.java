package mapper;

import java.util.List;

import bean.Customer;

public interface CustomerMapper {

	/**
	 * 查找所有记录
	 * @return
	 */
	public List<Customer> selectAllCustomer();
	
	/**
	 * 根据ID查找
	 */
	public Customer selectCustomerById(int id);
	
	/**
	 * 添加记录
	 */
	public void insertCustomer(Customer customer);
	
	/**
	 * 删除记录
	 */
	public void deleteCustomer(int id);
	
	/**
	 * 修改记录（根据ID修改）
	 */
	public void updateCustomer(Customer customer);
	
}
