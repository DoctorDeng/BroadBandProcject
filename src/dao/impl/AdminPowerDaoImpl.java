package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.AdminPower;
import bean.Power;
import dao.AdminPowerDao;
import util.DBHelper;

public class AdminPowerDaoImpl implements AdminPowerDao {

	@Override
	public List<AdminPower> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(AdminPower adminpower) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(AdminPower adminpower) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(AdminPower adminpower) {
		// TODO Auto-generated method stub
		return false;
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
	
	
	public boolean updateAdminPower(int adminId, Power power) {
		String sql = "UPDATE adminPower SET powerId = " + power.getPowerId() 
		             + " WHERE adminId = " + adminId + " AND " 
				     + " powerId = " + power.getPowerId();
		int result = DBHelper.update(sql, null);
		
		if (result==0) {
			return false;
		}
		return true;
	}
	
	public boolean delAdminPower(int adminId, Power power) {
		return true;
	}
	
	public boolean addPowers(int adminId, List<Power> powerList) {
		String sql = "INSERT INTO ";
		return true;
	}
	
	public static void main(String[] args) {
		AdminPowerDaoImpl admin = new AdminPowerDaoImpl();
		/*List<Power> list = admin.findPowersById(1);
		for (Power power: list) {
			System.out.println(power.getPowerName());
		}*/
		Power power = new Power();
		Power.set		
	}
	
}
