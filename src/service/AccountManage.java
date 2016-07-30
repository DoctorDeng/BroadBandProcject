package service;

import bean.Admin;
import mapper.impl.AdminDaoImpl;
import mapper.impl.AdminPowerDaoImpl;

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
	/**
	 * 更改管理员账号密码 
	 * @param adminId           管理员ID
	 * @param newPassword       新的管理员账号密码
	 * @return
	 */
	public boolean changePassword(int adminId,String newPassword) {
		return adminDao.updateAdminPasswordByAdminId(adminId, newPassword);
	}
	/**
	 * 批量重置管理员密码
	 * @param adminIds  批量管理员ID
	 * @return
	 */
	public boolean resetPassword(int[] adminIds) {
		return adminDao.resetAdminsPassword(adminIds);
	}
	
}
