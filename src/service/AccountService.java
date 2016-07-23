package service;

import java.util.ArrayList;
import java.util.List;

import bean.Bussiness;
import bean.Customer;
import bean.viewBean.AccountViewBean;
import dao.impl.AccountViewDaoImpl;
import dao.impl.BussinessDaoImpl;
import dao.impl.CustomerDaoImpl;

public class AccountService {
	//账务账号页面获取数据类
	
	int pageSize = 5;
	
	public List<AccountViewBean> getAccountViewBean(int currentPage){
		List<AccountViewBean> l = new ArrayList<AccountViewBean>();
		l = new AccountViewDaoImpl().getAccountViewBean(currentPage, pageSize);
		return l;
	}
	
	public boolean addBussinessAccount(AccountViewBean a){
		boolean b = true;
		Customer customer = new Customer();
		customer.setCustomerName(a.getBussinessName());
		customer.setIdNumber(a.getIdNumber());
		customer.setPhone(a.getPhone());
		CustomerDaoImpl c = new CustomerDaoImpl();
		b = b&&c.add(customer);
		int customerId = c.findByIdNumber(a.getIdNumber()).getCustomerId();
		Bussiness bussiness = new Bussiness();
		bussiness.setCreateTime(a.getCreateTime());
		bussiness.setCustomerId(customerId);
		bussiness.setLastLoginTime(a.getLastLoginTime());
		bussiness.setLoginAccount(a.getLoginAccount());
		bussiness.setPassword(a.getPassword());
		bussiness.setStatus(a.getStatus());
		b = b&&new BussinessDaoImpl().add(bussiness);
		return b;
	}
	
	public boolean updateBussinessAccount(AccountViewBean a){
		boolean b = true;
		Bussiness bussiness = new Bussiness();
		bussiness.setBussinessId(a.getBussinessId());		
		bussiness.setLoginAccount(a.getLoginAccount());
		bussiness.setPassword(a.getPassword());
		BussinessDaoImpl bu = new BussinessDaoImpl();
		b = b&&bu.update(bussiness);
		int customerId = bu.findOne(a.getBussinessId()).getCustomerId();
		System.out.println("业务账号ID："+customerId);
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(a.getBussinessName());
		customer.setIdNumber(a.getIdNumber());
		customer.setPhone(a.getPhone());
		b = b&&new CustomerDaoImpl().update(customer);				
		return b;
	}
	
	/*public static void main(String[] args){
		System.out.println("测试开始.....");
		List<AccountViewBean> l = new AccountService().getAccountViewBean(1);
        for(AccountViewBean a:l){
        	System.out.println(a.getBussinessId());
        	System.out.println(a.getBussinessName());
        	System.out.println(a.getIdNumber());
        	System.out.println(a.getLoginAccount());
        	System.out.println(a.getStatus());
        	System.out.println(a.getCreateTime());
        	System.out.println(a.getLastLoginTime());
        }
        System.out.println("测试结束.");
	}*/
	
	
}
