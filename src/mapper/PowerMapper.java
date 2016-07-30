package mapper;

import java.util.List;

import bean.Power;

public interface PowerMapper {
	
	public List<Power> selectAllPower();
	
	public List<Power> selectPowerByAdminId(int adminId);
	
}
