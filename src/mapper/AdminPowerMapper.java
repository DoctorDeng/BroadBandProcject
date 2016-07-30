package mapper;

import java.util.List;

import bean.AdminPower;

public interface AdminPowerMapper {
	/**
	 * 添加管理员权限
	 * @param adminPowers
	 * @return
	 */
	public int insertAdminPower(List<AdminPower> adminPowers);
	/**
	 * 删除管理员权限
	 * @param adminId 管理员ID
	 * @return
	 */
	public int deleteAdminPower(int adminId);
}
