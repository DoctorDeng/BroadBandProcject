package dao.impl;

import java.util.List;

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
	 * 
	 * @param adminAccount
	 * @param password
	 * @return
	 */
	public Admin findAdminByAccount(String adminAccount, String password) {
		Admin admin = null;
		String sql = "SELECT adminId, adminAccount, password FROM admin WHERE adminAccount = ? AND password= ?";
		String[] fields = {adminAccount, password};
		admin = DBHelper.findOne(new Admin(), sql, fields);
		
		return admin;
	}
	
	public static void main(String[] args) {
		AdminDaoImpl adminDao = new AdminDaoImpl();
		System.out.println(adminDao.findAdminByAccount("123", "123").getAdminId());
	}
}
