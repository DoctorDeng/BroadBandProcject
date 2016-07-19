package service;

import dao.AdminDao;

public class AccountService {
	private AdminDao adminDao;
	
	public AccountService() {
	}
	/**
	 * 通过账号和密码验证是否有此管理员
	 * @param adminAccount   管理员账号
	 * @param password       账号密码
	 * @return               返回0 表示没有此用户，否则返回表示的是管理员对应的adminID              
	 */
	public int isAccount(String adminAccount, String password) {
		int adminId = 0;
		
		return adminId;
	}
}
