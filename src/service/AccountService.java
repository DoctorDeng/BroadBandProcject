package service;

import java.util.ArrayList;
import java.util.List;

import bean.Bussiness;
import bean.viewBean.AccountViewBean;
import dao.impl.AccountViewDaoImpl;

public class AccountService {
	//账务账号页面获取数据类
	
	int pageSize = 5;
	
	public List<AccountViewBean> getAccountViewBean(int currentPage){
		List<AccountViewBean> l = new ArrayList<AccountViewBean>();
		l = new AccountViewDaoImpl().getAccountViewBean(currentPage, pageSize);
		return l;
	}
	
	public boolean addBussinessAccount(Bussiness a){
		return new AccountViewDaoImpl().addBussinessAccount(a);
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
