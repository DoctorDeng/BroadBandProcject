package mapper;

import java.util.List;

import bean.Power;

public interface PowerMapper {
	/**
	 * 获取所有的权限
	 * @return
	 */
	public List<Power> selectAllPower();
	/**
	 * 获取指定管理员的所有权限
	 * @param adminId  管理员ID
	 * @return
	 */
	public List<Power> selectPowerByAdminId(int adminId);
	
}
