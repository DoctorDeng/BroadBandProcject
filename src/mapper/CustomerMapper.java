package mapper;

import java.util.List;
import java.util.Map;

import bean.Customer;

public interface CustomerMapper {

	/**
	 * 查找所有记录
	 * @return
	 */
	public List<Customer> selectAllCustomer(Map page);
	
	/**
	 * 根据ID查找
	 */
	public Customer selectCustomerById(int id);
	
	/**
	 * 添加记录
	 */
	public boolean insertCustomer(Customer customer);
	
	/**
	 * 删除记录
	 */
	public void deleteCustomer(int id);
	
	/**
	 * 修改记录（根据ID修改）
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 根据身份证号码查询customer
	 */
	public Customer selectCustomerByIdNumber(String idNumber);
	
	/**
	 * 根据输入的条件搜索customer
	 */
	public List<Customer> selectCustomerByCondition(Map customer);
	
	/**
	 * 查询所有记录条数
	 */
	public int countCustomer(Map map);
}
