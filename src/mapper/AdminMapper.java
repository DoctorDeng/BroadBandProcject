package mapper;

import java.util.List;

import bean.Admin;

public interface AdminMapper {
	/**
	 * 所有管理员信息
	 * @return  List<Admin>
	 */
	public List<Admin> selectAllAdmin();
	
	public Admin selectAdminById(int adminId);
	
	public int insertAdmin(Admin admin);
	
	public int updateAdminInfor(Admin admin);
	/**
	 * 批量重置管理员的账号密码
	 * @param adminIds  需要重置密码的管理员id集合
	 * @return
	 */
	public int resetAdminsPassword(List<Integer> adminIds);
	
	public int deleteAdminById(int adminId);
	
	public int updateAdminPassword(Admin admin);
	
	
}
