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
	 * 登陆方法
	 * @param adminAccount 管理员账号
	 * @param password     管理员密码
	 * @return             用户名或密码错误返回null，正确返回一个Admin对象
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
