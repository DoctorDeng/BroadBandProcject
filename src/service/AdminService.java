package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Admin;
import bean.AdminInfor;
import bean.Power;
import dao.impl.AdminDaoImpl;
import dao.impl.AdminInforDaoImpl;
import dao.impl.AdminPowerDaoImpl;

public class AdminService {
	
	private AdminDaoImpl adminDao;
	private AdminInforDaoImpl adminInforDao;
	private AdminPowerDaoImpl adminPowerDao;
	
	public AdminService() {
		adminDao      = new AdminDaoImpl();
		adminPowerDao = new AdminPowerDaoImpl();
		adminInforDao = new AdminInforDaoImpl();
	}
	/**
	 * 添加管理员 
	 * @param admin      
	 * @param adminInfor 
	 * @param powerList   管理员权限列表
	 * @return            添加成功返回true，失败返回false;
	 */
	public boolean  addAdmin(Admin admin,AdminInfor adminInfor, List<Power> powerList) {
		
		if (adminDao.addAdmin(admin.getAdminAccount(), admin.getPassword())) {
			Admin temp = adminDao.verifyAdminByAccount(admin.getAdminAccount(), admin.getPassword());
			if (null !=temp) {
				adminInfor.setAdminId(temp.getAdminId());
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
	 * @param powerList   管理员权限列表
	 * @return            更新成功返回true，失败返回false
	 */
	public boolean updateAdmin(int adminId,AdminInfor adminInfor,List<Power> powerList) {
		adminInfor.setAdminId(adminId);
		if (adminInforDao.updateAdminInfor(adminInfor)) {
			if (adminPowerDao.updateAdminPower(adminId, powerList)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 删除指定管理员
	 * @param adminId  管理员ID
	 * @return         成功
	 */
	public boolean delAdmin(int adminId) {
		return adminDao.delAdmin(adminId);
	}
	/**
	 * 通过管理员ID获取管理员个人信息
	 * @param adminId  管理员ID
	 * @return         返回adminInfor，为查找成功，失败返回null
	 */
	public AdminInfor getAdminInforById(int adminId) {
		return adminInforDao.findAdminInforById(adminId);
	}
	/**
	 * 初始化管理员信息表
	 * @param adminId  管理员ID
	 * @return         成功返回true,失败返回false
	 */
	public boolean initAdminInfor(int adminId) {
		return adminInforDao.initAdminInfor(adminId);
	}
	/**
	 * 更新管理员的个人信息
	 * @param adminInfor   
	 * @return         更新成功返回TRUE，失败返回FALSE
	 */
	public boolean updateInfor(AdminInfor adminInfor) {
		return adminInforDao.updateAdminInfor(adminInfor);
	}
	
	public List<Map<String,Object>> getAllAdminInfor() {
		List<Map<String,Object>> list = adminDao.findAllAdminInfor();
		List<Map<String,Object>> adminList = new ArrayList<>();
		
		for (Map map : list) {
			String powerListStr = map.get("powerList").toString();
			String[] powerList = powerListStr.split(",");
			map.put("powerList", powerList);
		}
		return list;
	}
	
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		String[] str = (String[])adminService.getAllAdminInfor().get(0).get("powerList");
		for (String s:str) {
			System.out.println(s);
		}
	}
}
