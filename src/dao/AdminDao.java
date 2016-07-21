package dao;

import java.util.List;
import java.util.Map;

import bean.Admin;
import util.DBHelper;

public interface AdminDao {
	/**
	 * 通过管理 是否错误
	 * @param adminAccount   管理员账号
	 * @param password       管理员密码
	 * @return               返回NULl，表示没有此管理员，有则返回一个admin对象
	 */
	public Admin verifyAdminByAccount(String adminAccount, String password);
	/**
	 * 通过判断是否有此管理员账号
	 * @param adminAccount
	 * @return
	 */
	public Boolean findAdminByAccount(String adminAccount);
	/**
	 * 通过管理员账号和密码来添加管理员
	 * @param adminAccount    管理员账号
	 * @param password        管理员密码
	 * @return                添加成功返回true，添加失败返回FALSE
	 */
	public Boolean  addAdmin(String adminAccount, String password);
	/**
	 * 修改管理员账号密码
	 * @param adminAccount   管理员账号
	 * @param password       账号密码
	 * @return               修改成功返回TRUE，修改失败返回FALSE
	 */
	public Boolean updateAdminPassword(String adminAccount, String password);
	/**
	 * 获取管理员的所有信息，包括个人信息和账号信息
	 * @return 			返回包含所有管理员信息的集合
	 */
	public List<Map<String,Object>> findAllAdminInfor();
	/**
	 * 通过管理员ID来更新管理员密码
	 * @param adminId   管理员ID
	 * @param password  新的管理员账号密码
	 * @return          更新成功返回true，失败返回false
	 */
	public Boolean updateAdminPassword(int adminId, String password);
	/**
	 * 重置管理员的账号和密码
	 * @param adminId  管理员ID
	 * @return         重置成功返回true,失败返回false
	 */
	public Boolean resetAdminPassword(int adminId);
	
	/**
	 * 批量重置管理员密码
	 * @param adminIds  批量管理员Id
	 * @return  		重置成功返回true，失败返回false
	 */
	public Boolean resetAdminsPassword(int[] adminIds);
	
	/**
	 * 删除指定管理员
	 * @param adminId  需要删除的管理员的Id
	 * @return         删除成功返回true，失败返回false
	 */
	public Boolean delAdmin(int adminId);
		
}
