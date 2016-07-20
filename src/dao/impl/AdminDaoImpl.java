package dao.impl;

import java.util.List;
import java.util.Map;

import bean.Admin;
import dao.AdminDao;
import util.DBHelper;

public class AdminDaoImpl implements AdminDao{
	
	public List<Admin> findAll(){
		return null;
	}
	
	public Admin findOne(int adminId){
		return null;
	}
	
	public boolean add(Admin admin){
		return false;
	}
	
	public boolean update(Admin admin){
		return false;
	}
	
	/**
	 * 通过管理员账号和密码来判断管理员账号密码是否错误
	 * @param adminAccount   管理员账号
	 * @param password       管理员密码
	 * @return               返回NULl，表示没有此管理员，有则返回一个admin对象
	 */
	public Admin verifyAdminByAccount(String adminAccount, String password) {
		Admin admin = null;
		String sql = "SELECT adminId, adminAccount, password FROM admin WHERE adminAccount = ? AND password= ?";
		String[] fields = {adminAccount, password};
		admin = DBHelper.findOne(new Admin(), sql, fields);
		
		return admin;
	}
	/**
	 * 通过判断是否有此管理员账号
	 * @param adminAccount
	 * @return
	 */
	public Boolean findAdminByAccount(String adminAccount) {
		String sql = "SELECT adminId FROM admin WHERE adminAccount = ?";
		String[] fields = {adminAccount};
		List<Map<String,Object>> list = DBHelper.find(sql, fields);
		if (list.size()>0) {
			return true;
		}
		return false;
	}
	/**
	 * 通过管理员账号和密码来添加管理员
	 * @param adminAccount    管理员账号
	 * @param password        管理员密码
	 * @return                添加成功返回true，添加失败返回FALSE
	 */
	public Boolean  addAdmin(String adminAccount, String password) {
		/**
		 * 当没有此管理员账号时，才开始添加管理员账号
		 */
		if (!findAdminByAccount(adminAccount)) {
			String sql = "INSERT INTO admin (adminAccount,password) VALUES(?,?)";
			String[] fields = {adminAccount,password};
			
			int result = DBHelper.update(sql, fields);
			if (result == 0) {
				return false;
			}
			return true;
		}
		return false;
	}
	/**
	 * 修改管理员账号密码
	 * @param adminAccount   管理员账号
	 * @param password       账号密码
	 * @return               修改成功返回TRUE，修改失败返回FALSE
	 */
	public Boolean updateAdminPassword(String adminAccount, String password) {
		String sql = "UPDATE admin SET password = ? WHERE adminAccount = ?";
		String[] fileds = {password,adminAccount};
		int result = DBHelper.update(sql, fileds);
		if (result == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		AdminDaoImpl adminDao = new AdminDaoImpl();
		Admin admin = new Admin(1,"222","555");
		/*System.out.println(adminDao.findAdminByAccount("123", "123").getAdminId());*/
		/*System.out.println(adminDao.addAdmin("555", "333"));*/
		System.out.println(adminDao.updateAdminPassword("222","777"));
	}
}
