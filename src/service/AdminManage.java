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
	/**
	 * 添加管理员 
	 * @param admin      
	 * @param adminInfor 
	 * @param powerList
	 * @return           添加成功返回true，失败返回false;
	 */
	public boolean  addAdmin(Admin admin,AdminInfor adminInfor, List<Power> powerList) {
		
		if (adminDao.addAdmin(admin.getAdminAccount(), admin.getAdminAccount())) {
			Admin temp = adminDao.verifyAdminByAccount(admin.getAdminAccount(), admin.getPassword());
			adminInfor.setAdminId(temp.getAdminId());
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
	/**
	 * 更新管理员的个人信息的权限
	 * @param adminId      
	 * @param adminInfor
	 * @param powerList 
	 * @return
	 */
	public boolean updateAdmin(int adminId,AdminInfor adminInfor,List<Power> powerList) {
		adminInfor.setAdminId(adminId);
		if (adminInforDao.update(adminInfor)) {
			if (adminPowerDao.updateAdminPower(adminId, powerList)) {
				return true;
			}
		}
		return false;
	}
}
