package service;

import java.util.List;

import bean.Admin;
import bean.AdminInfor;
import bean.Power;
import dao.impl.AdminDaoImpl;
import dao.impl.AdminPowerDaoImpl;

public class AdminManage {
	
	private AdminDaoImpl adminDao;
	private AdminPowerDaoImpl adminPowerDao;
	
	public AdminManage() {
		adminDao      = new AdminDaoImpl();
		adminPowerDao = new AdminPowerDaoImpl();
	}
	
	public boolean  addAdmin(Admin admin,AdminInfor adminInfor, List<Power> powerList) {
		return true;
	}
}
