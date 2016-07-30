package mapper;

import java.util.List;

import bean.Admin;

public interface AdminMapper {
	
	public List<Admin> selectAllAdmin();
	
	public Admin selectAdminById(int adminId);
	
	public int insertAdmin(Admin admin);
	
	public int updateAdmin(Admin admin);
	
	public int resetAdminsPassword(List<Integer> admindIds);
	
	public int deleteAdminById(int adminId);
	
	public int deleteAdminPower(int adminId);
	
}
