package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Power;
import util.DBHelper;

public class AdminPowerDaoImpl {
	/**
	 * 批量为管理员添加权限   
	 * @param adminId       管理员ID 
	 * @param powerList     要添加的权限的集合
	 * @return              添加成功返回true，失败返回false
	 */
	public boolean addAdminPowers(int adminId, List<Power> powerList) {
		StringBuilder sql = new StringBuilder("INSERT INTO adminPower (adminId,powerId) VALUES");
		
		for (int i=0; i<powerList.size(); i++) {
			Power power = powerList.get(i);
			if (i==powerList.size() -1) {
				sql.append(" ("+ adminId+"," + power.getPowerId()+")");
			} else {
				sql.append(" ("+ adminId+"," + power.getPowerId()+"),");
			}
		}
		/*System.out.println(sql.toString());*/
		int result = DBHelper.update(sql.toString(), null);
		if (result==0) {
			return false;
		}
	/*	for (Power power: powerList) {
			String sql = "INSERT INTO adminPower (adminId,powerId) "
					+ "VALUES(" + adminId+"," + power.getPowerId()+")";
			int result = DBHelper.update(sql, null);
			if (result==0) {
				return false;
			}
		}*/
		return true;
	}
	/**
	 * 通过管理员的ID来查找对应得权限
	 * @param adminId
	 * @return
	 */
	public List<Power>  findPowersById(int adminId) {
		List<Power> powerList = new ArrayList<>();
		String sql = "SELECT p.powerId, p.powerName, p.power FROM adminPower as ap "
				+ " INNER JOIN power as p ON ap.powerId = p.powerId WHERE adminid = " + adminId;
		String[] str = new String[0];
		List<Map<String, Object>> list = DBHelper.find(sql,str);
		
		for (Map<String,Object> map: list) {
			int powerId = Integer.parseInt(map.get("powerId").toString());
			String powerName = map.get("powerName").toString();
			int power =  Integer.parseInt(map.get("power").toString());
			
			Power temp = new Power();
			temp.setPower(power);
			temp.setPowerId(powerId);
			temp.setPowerName(powerName);
			powerList.add(temp);
		}
		return powerList;
	}
	
	/**
	 * 更新管理员的权限
	 * @param adminId
	 * @param powerList
	 * @return
	 */
	public boolean updateAdminPower(int adminId, List<Power> powerList) {
		/**
		 * 当管理员有权限时，删除管理员所有的权限
		 */
		if (adminHasPower(adminId)) {
			/**
			 * 当删除权限失败时，返回false，即更新失败
			 */
			if (!delAdminPowers(adminId)) {
				return false;
			}
			/**
			 * 删除成功，开始为管理员添加权限
			 */
			return addAdminPowers(adminId, powerList);
		} 
		return addAdminPowers(adminId, powerList);
	}
	/**
	 * 删除指定管理员所有的权限
	 * @param adminId   管理员的ID
	 * @return          删除成功返回true，失败返回false
	 */
	public boolean delAdminPowers(int adminId) {
		String sql = "DELETE FROM adminPower WHERE adminId = "  + adminId;
		int result = DBHelper.update(sql, null);
		if (result==0) {
			return false;
		} 
		return true;
	}
	/**
	 * 确认管理员是否有权限
	 * @param adminId   管理员ID
	 * @return          管理员有权限返回true ，没有返回false
	 */
	public boolean adminHasPower(int adminId) {
		List<Power> powerList = findPowersById(adminId);
		if (powerList.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		AdminPowerDaoImpl admin = new AdminPowerDaoImpl();
		/*List<Power> list = admin.findPowersById(1);
		for (Power power: list) {
			System.out.println(power.getPowerName());
		}*/
		Power power1 = new Power();
		power1.setPowerId(1);
		Power power2 = new Power();
		power2.setPowerId(2);
		List<Power> list = new ArrayList<>();
		list.add(power1);
		list.add(power2);
		System.out.println(admin.addAdminPowers(2, list));
				
//		System.out.println(admin.adminHasPower(1));
	}
	
}
