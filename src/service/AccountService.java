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
import mapper.BussinessMapper;
import mapper.CustomerMapper;
import mapper.OsMapper;
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
				a.setCountPage(countPage%pageSize==0?(countPage/5):(countPage/5+1));
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
			//int countPage = cm.countCustomer();
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
				//a1.setCountPage(countPage);
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
		c.setPauseTime(a.getPauseTime());
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);	
			OsMapper om = ss.getMapper(OsMapper.class);
			cm.updateCustomer(c);
			/** 当要设置状态为0（暂停）时，同时将关联的其他业务账号状态设为暂停**/
			if("0".equals(c.getStatus())){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}			
		return b;
	}
		
	public int getCountPage() {
		int countPage = -1;
		SqlSession ss = null;
		try
		{
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);	
			countPage = cm.countCustomer();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}	
		return countPage;
	}
	
}
