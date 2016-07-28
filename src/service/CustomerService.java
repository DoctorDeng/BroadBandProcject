package service;

import bean.Customer;
import bean.vo.ServiceAddViewBean;

public class CustomerService {
	/**
	 * CustomerID的取出
	 */
	public Customer customerIdUtil(ServiceAddViewBean serviceAddViewBean){
		int customerId = serviceAddViewBean.getCustomerId();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return customer;
	}
}
