package mapper;

import java.util.List;
import java.util.Map;

import bean.Admin;

public interface AdminMapper {
	/**
	 * 所有管理员信息
	 * @return  List<Admin>
	 */
	public List<Admin> selectAllAdmin();
	/**
	 * 通过管理员获取管理员信息
	 * @param adminId  管理员ID
	 * @return   Admin
	 */
	public Admin selectAdminById(int adminId);
	/**
	 * 插入管理员
	 * @param admin
	 * @return
	 */
	public int insertAdmin(Admin admin);
	/**
	 * 更新管理员个人信息(不包括权限)
	 * @param admin
	 * @return
	 */
	public int updateAdminInfor(Admin admin);
	/**
	 * 批量重置管理员的账号密码
	 * @param adminIds  需要重置密码的管理员id集合
	 * @return
	 */
	public int resetAdminsPassword(int[] adminIds);
	/**
	 * 删除指定管理
	 * @param adminId  要删除的管理员ID
	 * @return
	 */
	public int deleteAdminById(int adminId);
	/**
	 * 更新管理员密码
	 * @param admin
	 * @return
	 */
	public int updateAdminPassword(Admin admin);
	/**
	 * 登陆验证
	 * @param admin
	 * @return  验证成功返回一个Admin对象,失败返回 null
	 */
	public Admin verifyAdmin(Admin admin);
	/**
	 * 验证是否有此管理员账号
	 * @param adminAccount  待验证的管理员账号
	 * @return              有管理员账号,原样返回管理员账号,没有返回空 null
	 */
	public String verifyAdminAccount(String adminAccount);
	/**
	 * 通过管理员账号获取管理员ID的字符串表示
	 * @param adminAccount  管理员账号
	 * @return              返回管理员账号对应的管理员ID的字符串表示,如果没有此管理员账号,返回空
	 */
	public String selectAdminIdByAccount(String adminAccount);
	
	public List<Admin> selectAdminByCondition(Map map); 
}
