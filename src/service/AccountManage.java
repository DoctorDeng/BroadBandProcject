package service;

import java.util.List;

import bean.Admin;
import bean.Power;
import dao.impl.AdminDaoImpl;
import dao.impl.AdminPowerDaoImpl;

public class AccountManage {
	private AdminDaoImpl  adminDao;
	private AdminPowerDaoImpl adminPowerDao;
	
	public AccountManage () {
		adminDao      = new AdminDaoImpl();
		adminPowerDao = new AdminPowerDaoImpl();
	}
	/**
	 * 
	 * @param adminAccount
	 * @param password
	 * @return
	 */
	public Admin login(String adminAccount, String password) {
		Admin admin = adminDao.verifyAdminByAccount(adminAccount, password);
		
		if (null == admin) {
			return null;
		} else {
			admin.setPowerList(adminPowerDao.findPowersById(admin.getAdminId()));
		}
		return admin;
	}
	
}
