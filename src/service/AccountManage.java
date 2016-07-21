package service;

import dao.impl.AdminDaoImpl;

public class AccountManage {
	private AdminDaoImpl  adminDao;
	
	public AccountManage () {
		adminDao = new AdminDaoImpl()
	}
	
	public boolean login(String adminAccount, String password) {
		
	}
}
