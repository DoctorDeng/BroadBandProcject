package service;

import java.util.ArrayList;
import java.util.List;

import bean.viewBean.AccountViewBean;
import dao.impl.AdminInforDaoImpl;
import dao.impl.AccountViewDaoImpl;

public class AccountService {
	//账务账号页面获取数据类
	
	int pageSize = 5;
	
	public List<AccountViewBean> getAdminInforViewBean(int currentPage){
		List<AccountViewBean> l = new ArrayList<AccountViewBean>();
		l = new AccountViewDaoImpl().getAdminInforViewBean(currentPage, pageSize);
		return l;
	}
	
	/*public static void main(String[] args){
		System.out.println("测试开始.....");
		List<AdminInforViewBean> l = new AdminInforService().getAdminInforViewBean(1);
        for(AdminInforViewBean a:l){
        	System.out.println(a.getAdminId());
        	System.out.println(a.getIdNumber());
        	System.out.println(a.getCreateTime());
        	System.out.println(a.getAdminAccount());
        	System.out.println(a.getStatus());
        	System.out.println(a.getName());
        }
        System.out.println("测试结束.");
	}*/
	
	
}
