package mapper;

import java.util.List;

import bean.AdminPower;

public interface AdminPowerMapper {
	
	public int insertAdminPower(List<AdminPower> adminPowers);
	
	public int deleteAdminPower(int adminId);
}
