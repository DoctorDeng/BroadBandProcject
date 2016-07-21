package service;

import java.util.List;

import bean.Admin;
import bean.AdminInfor;
import bean.Power;
import dao.impl.AdminDaoImpl;
import dao.impl.AdminInforDaoImpl;
import dao.impl.AdminPowerDaoImpl;

public class AdminManage {
	
	private AdminDaoImpl adminDao;
	private AdminInforDaoImpl adminInforDao;
	private AdminPowerDaoImpl adminPowerDao;
	
	public AdminManage() {
		adminDao      = new AdminDaoImpl();
		adminPowerDao = new AdminPowerDaoImpl();
	}
	
	public boolean  addAdmin(Admin admin,AdminInfor adminInfor, List<Power> powerList) {
		
		if (adminDao.addAdmin(admin.getAdminAccount(), admin.getAdminAccount())) {
			Admin temp = adminDao.verifyAdminByAccount(admin.getAdminAccount(), admin.getPassword());
			if (null !=temp) {
				if (adminInforDao.addAdminInfor(adminInfor)) {
					if (adminPowerDao.addAdminPowers(temp.getAdminId(), powerList)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
