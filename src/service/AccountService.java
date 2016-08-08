package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Bussiness;
import bean.Customer;
import bean.vo.AccountViewBean;
import mapper.CustomerMapper;
import util.SqlSessionUtil;

public class AccountService {
	//账务账号页面获取数据类
	
	int pageSize = 5;
	
	public List<AccountViewBean> getAccountViewBean(int currentPage){
		List<AccountViewBean> l = new ArrayList<AccountViewBean>();
		Map<String,Integer> page = new HashMap<String,Integer>();
		int startPage = (currentPage-1)*pageSize;
		page.put("startPage", startPage);
		page.put("pageSize", pageSize);
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			List<Customer> lc =  cm.selectCustomerByCondition(page);
			int countPage = cm.countCustomer();
			for(Customer c:lc){
//				if("2".equals(c.getStatus())){
//					continue;
//				}
				AccountViewBean a = new AccountViewBean();
				a.setBussinessId(c.getCustomerId());
				a.setBussinessName(c.getCustomerName());
				a.setCreateTime(c.getCreateTime());
				a.setIdNumber(c.getIdNumber());
				a.setLastLoginTime(c.getLastLoginTime());
				a.setLoginAccount(c.getCustomerAccount());
				a.setPassword(c.getPassword());
				a.setPhone(c.getPhone());
				a.setStatus(c.getStatus());
				a.setCountPage(countPage);
				l.add(a);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}
		return l;
	}
	
	public List<AccountViewBean> searchAccountViewBean(AccountViewBean a,int currentPage){
		Customer customer = new Customer();
		if(!"不验证".equals(a.getIdNumber())){
			customer.setIdNumber(a.getIdNumber());
		}
		customer.setStatus(a.getStatus());
		if(!"不验证".equals(a.getBussinessName())){
			customer.setCustomerName(a.getBussinessName());
		}
		customer.setCustomerAccount(a.getLoginAccount());
		Map page = new HashMap();
		int startPage = (currentPage-1)*pageSize;
		page.put("startPage", startPage);
		page.put("pageSize", pageSize);
		List<AccountViewBean> la = new ArrayList<AccountViewBean>();
		page.put("idNumber", a.getIdNumber());
		page.put("customerName", a.getBussinessName());
		page.put("customerAccount", a.getLoginAccount());
		page.put("status", a.getStatus());
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			List<Customer> lc =  cm.selectCustomerByCondition(page);
			int countPage = cm.countCustomer();
			for(Customer c:lc){
//				if("2".equals(c.getStatus())){
//					continue;
//				}
				AccountViewBean a1 = new AccountViewBean();
				a1.setBussinessId(c.getCustomerId());
				a1.setBussinessName(c.getCustomerName());
				a1.setCreateTime(c.getCreateTime());
				a1.setIdNumber(c.getIdNumber());
				a1.setLastLoginTime(c.getLastLoginTime());
				a1.setLoginAccount(c.getCustomerAccount());
				a1.setPassword(c.getPassword());
				a1.setPhone(c.getPhone());
				a1.setStatus(c.getStatus());
				a1.setCountPage(countPage);
				la.add(a1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}
		return la;
	}
	
	public boolean addBussinessAccount(AccountViewBean a){
		boolean b = true;
		Customer c = new Customer();
		c.setCreateTime(a.getCreateTime());
		c.setCustomerAccount(a.getLoginAccount());
		c.setCustomerId(a.getBussinessId());
		c.setCustomerName(a.getBussinessName());
		c.setIdNumber(a.getIdNumber());
		c.setLastLoginTime(a.getLastLoginTime());
		c.setPassword(a.getPassword());
		c.setPhone(a.getPhone());
		c.setStatus(a.getStatus());
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			cm.insertCustomer(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}
		return b;
	}
	
	public boolean updateBussinessAccount(AccountViewBean a){
		boolean b = true;
		Customer c = new Customer();
		c.setCreateTime(a.getCreateTime());
		c.setCustomerAccount(a.getLoginAccount());
		c.setCustomerId(a.getBussinessId());
		c.setCustomerName(a.getBussinessName());
		c.setIdNumber(a.getIdNumber());
		c.setLastLoginTime(a.getLastLoginTime());
		c.setPassword(a.getPassword());
		c.setPhone(a.getPhone());
		c.setStatus(a.getStatus());
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			cm.updateCustomer(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}			
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
