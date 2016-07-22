package service;

import java.util.List;

import bean.Customer;
import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;

public class CustomerManage {
	/**
	 * CustomerID的取出
	 */
	public Customer customerIdUtil(){
		Customer customer = new Customer();
		BussinessViewBeanDaoImpl bvbd = new BussinessViewBeanDaoImpl();
		List<ServiceAddViewBean> lv = bvbd.find();
		for(ServiceAddViewBean sab : lv){
		int customerId = sab.getCustomerId();
		customer.setCustomerId(customerId);
		}
		return customer;	
	}
}
