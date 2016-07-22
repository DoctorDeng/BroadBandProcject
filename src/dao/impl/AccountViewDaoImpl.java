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
		String sql = "select * from bussiness";
		String[] fields = null;
		List<Map<String,Object>> list = DBHelper.find(sql, fields);
		for(Map<String,Object> m:list){
			AccountViewBean a = new AccountViewBean();
			a.setBussinessId(Integer.parseInt(m.get("bussinessId").toString()));
			a.setBussinessName(m.get("bussinessName").toString());
			a.setIdNumber(m.get("idNumber").toString());
			a.setLoginAccount(m.get("loginAccount").toString());
			a.setStatus(m.get("status").toString());
			a.setCreateTime(m.get("createTime").toString());
			a.setLastLoginTime(m.get("lastLoginTime").toString());
			l.add(a);
		}	
		return l;
	}
	/**
	 * 增加账务账号对应account_add页面业务
	 * @param a
	 * @return
	 */
	public boolean addBussinessAccount(AccountViewBean a){
		String sql = "insert into bussiness (idNumber,loginAccount,createTime,status,lastLoginTime,password) values(?,?,?,?,?,?);";
		String[] fields = {
				a.getIdNumber(),a.getLoginAccount(),
				a.getCreateTime(),a.getStatus(),a.getLastLoginTime(),a.getPassword()};
		System.out.println(sql);
		int rs = DBHelper.update(sql, fields);
		if(rs<1){
			return false;
		}else{
			return true;
		}
		
	}
	
}
