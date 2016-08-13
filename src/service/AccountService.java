package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import bean.Customer;
import bean.Os;
import bean.vo.AccountViewBean;
import mapper.CustomerMapper;
import mapper.OsMapper;
import util.SqlSessionUtil;

public class AccountService {
	//账务账号页面获取数据类
	
	int pageSize = 5;
	private static Logger logger = Logger.getLogger(AccountService.class);
	
	/*public List<AccountViewBean> getAccountViewBean(int currentPage){
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
		for(AccountViewBean acc:l){
			logger.debug(acc.getBussinessName());
		}
		return l;
	}*/
	
	public List<AccountViewBean> searchAccountViewBean(AccountViewBean a,int currentPage){
		Map page = new HashMap();
		int startPage = (currentPage-1)*pageSize;
		page.put("startPage", startPage);
		page.put("pageSize", pageSize);
		page.put("idNumber", a.getIdNumber());
		page.put("customerName", a.getBussinessName());
		page.put("customerAccount", a.getLoginAccount());
		page.put("status", a.getStatus());
//		System.out.println(a.getLoginAccount());
		List<AccountViewBean> la = new ArrayList<AccountViewBean>();
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			List<Customer> lc =  cm.selectCustomerByCondition(page);
			//int countPage = cm.countCustomer();
			for(Customer c:lc){
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
	/**
	 * 添加账务账号，成功返回1，身份证号码已注册返回0，其他错误返回-1
	 * @param a
	 * @return
	 */
	public int addBussinessAccount(AccountViewBean a){
		int  b = -1;
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
		Map map = new HashMap();
		map.put("startPage", 0);
		map.put("pageSize", 1);
		map.put("idNumber", a.getIdNumber());
		List<Customer> lc;
		boolean bo;
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			lc = cm.selectCustomerByCondition(map);
			if(!lc.isEmpty()) {
				return 0;
			}
			cm.insertCustomer(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally{
			ss.commit();
			ss.close();
		}
		return 1;
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
			if("0".equals(c.getStatus())){
				//当要设置状态为0（暂停）时，同时将关联的其他业务账号状态设为暂停
				Os os = new Os();
				os.setCustomerId(c.getCustomerId());
				os.setStatus(c.getStatus());
				om.updateOsByCustomerId(os);
			}else if ("1".equals(c.getStatus())) {
				//开通账务账号时，删除暂停时间
				c.setPauseTime("--");
			} else if("2".equals(c.getStatus())) {
				//删除账号时，将其下关联的业务账号状态改为删除（3）
				Os os = new Os();
				os.setCustomerId(c.getCustomerId());
				os.setStatus(c.getStatus());
				om.updateOsByCustomerId(os);
				c.setDelTime(a.getDelTime());
			}
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
		
	public int getCountPage(AccountViewBean a) {
		int countPage = -1;
		Map page = new HashMap();
		page.put("idNumber", a.getIdNumber());
		page.put("customerName", a.getBussinessName());
		page.put("customerAccount", a.getLoginAccount());
		page.put("status", a.getStatus());
		SqlSession ss = null;
		try
		{
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);	
			countPage = cm.countCustomer(page);
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
	
	public AccountViewBean getDetail(int bussinessId) {
		AccountViewBean a = new AccountViewBean();
		SqlSession ss = null;
		try {
			ss = SqlSessionUtil.getSqlSession();
			CustomerMapper cm = ss.getMapper(CustomerMapper.class);						
			Customer c =  cm.selectCustomerById(bussinessId);			
			a.setBussinessId(c.getCustomerId());
			a.setBussinessName(c.getCustomerName());
			a.setCreateTime(c.getCreateTime());
			a.setIdNumber(c.getIdNumber());
			a.setLastLoginTime(c.getLastLoginTime());
			a.setLoginAccount(c.getCustomerAccount());
			a.setPassword(c.getPassword());
			a.setPhone(c.getPhone());
			a.setStatus(c.getStatus());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ss.commit();
			ss.close();
		}
		return a;
	}
	
}
