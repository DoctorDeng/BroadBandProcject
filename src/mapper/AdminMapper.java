package mapper;

import java.util.List;

import bean.Admin;

public interface AdminMapper {
	
	public List<Admin> selectAllAdmin();
	
	public Admin selectAdminById(int adminId);
	
	public int insertAdmin(Admin admin);
	
	public int updateAdminInfor(Admin admin);
	
	public int resetAdminsPassword(List<Integer> adminIds);
	
	public int deleteAdminById(int adminId);
	
	public int updateAdminPassword(Admin admin);
	
}
