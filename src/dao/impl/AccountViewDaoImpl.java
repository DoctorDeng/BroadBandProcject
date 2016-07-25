package dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import bean.Bussiness;
import bean.viewBean.AccountViewBean;
import util.DBHelper;

public class AccountViewDaoImpl {
	/**
	 * 根据传入的当前页数返回account_list.html页面的分页现实数据
	 * @param pageIndex
	 * @return
	 */
	public List<AccountViewBean> getAccountViewBean(int currentPage,int pageSize){
		List<AccountViewBean> l = new ArrayList<AccountViewBean>();
		String sql = "select a.bussinessId,a.loginAccount,a.createTime,a.status,a.lastLoginTime,"
				+ "c.idNumber,c.customerName from bussiness a,customer c where a.customerId=c.customerId"
				+ " limit "+(currentPage-1)*pageSize+","+pageSize;
		System.out.println(sql);
		String[] fields = null;
		List<Map<String,Object>> list = DBHelper.find(sql, fields);
		for(Map<String,Object> m:list){
			AccountViewBean a = new AccountViewBean();
			a.setBussinessId(Integer.parseInt(m.get("bussinessId").toString()));
			a.setBussinessName(m.get("customerName").toString());
			a.setIdNumber(m.get("idNumber").toString());
			a.setLoginAccount(m.get("loginAccount").toString());
			a.setStatus(m.get("status").toString());
			a.setCreateTime(m.get("createTime").toString());
			a.setLastLoginTime(m.get("lastLoginTime").toString());
			l.add(a);
		}	
		return l;
	}
	
	public List<AccountViewBean> searchAccountViewBean(AccountViewBean ac,int currentPage,int pageSize){
		List<AccountViewBean> l = new ArrayList<AccountViewBean>();
		StringBuffer sql = new StringBuffer("select a.bussinessId,a.loginAccount,a.createTime,a.status,a.lastLoginTime,"
				+ "c.idNumber,c.customerName from bussiness a,customer c where a.customerId=c.customerId");
		if(!(ac.getIdNumber()==null||"".equals(ac.getIdNumber())||"不验证".equals(ac.getIdNumber()))){
			sql.append(" and c.idNumber like '"+ac.getIdNumber()+"'");
		}
		if(!(ac.getBussinessName()==null||"".equals(ac.getBussinessName())||"不验证".equals(ac.getBussinessName()))){
			sql.append(" and c.customerName like'%"+ac.getBussinessName()+"%'");
		}
		if(!(ac.getLoginAccount()==null||!"".equals(ac.getLoginAccount())||"不验证".equals(ac.getLoginAccount()))){
			sql.append(" and a.loginAccount like '%"+ac.getLoginAccount()+"%'");
		}
		String status = ac.getStatus();
		if(status!=null&&"-1".equals(status)){
			sql.append(" and a.status="+ac.getStatus());
		}
		sql.append(" limit "+(currentPage-1)*pageSize+","+pageSize);
		System.out.println(sql.toString());
		String[] fields = null;
		List<Map<String,Object>> list = DBHelper.find(sql.toString(), fields);
		for(Map<String,Object> m:list){
			AccountViewBean a = new AccountViewBean();
			a.setBussinessId(Integer.parseInt(m.get("bussinessId").toString()));
			a.setBussinessName(m.get("customerName").toString());
			a.setIdNumber(m.get("idNumber").toString());
			a.setLoginAccount(m.get("loginAccount").toString());
			a.setStatus(m.get("status").toString());
			a.setCreateTime(m.get("createTime").toString());
			a.setLastLoginTime(m.get("lastLoginTime").toString());
			l.add(a);
		}	
		return l;
	}
	
}
