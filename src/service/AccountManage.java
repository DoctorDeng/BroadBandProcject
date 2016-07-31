package service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import bean.Admin;
import mapper.AdminMapper;
import util.SqlSessionUtil;
public class AccountManage {
	
	private SqlSession sqlSession;
	private AdminMapper adminMapper;
	
	public AccountManage () {}
	/**
	 * 登陆方法
	 * @param adminAccount 管理员账号
	 * @param password     管理员密码
	 * @return             用户名或密码错误返回null，正确返回一个Admin对象
	 */
	public Admin login(String adminAccount, String password) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		Admin admin = new Admin();
		admin.setAdminAccount(adminAccount);
		admin.setPassword(password);
		Admin admin1 = adminMapper.verifyAdmin(admin);
		
		sqlSession.close();
		
		if (null == admin1) {
			return null;
		} else {
			return admin1;
		}
	}
	/**
	 * 更改管理员账号密码 
	 * @param adminId           管理员ID
	 * @param newPassword       新的管理员账号密码
	 * @return
	 */
	public boolean changePassword(int adminId,String newPassword) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setPassword(newPassword);
        
		int result = adminMapper.updateAdminPassword(admin);
		sqlSession.close();
		if (result == 1) {
			return true;
		}
		return false;
	}
	/**
	 * 批量重置管理员密码
	 * @param adminIds  批量管理员ID
	 * @return
	 */
	public boolean resetPassword(int[] adminIds) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		int result = adminMapper.resetAdminsPassword(adminIds);
		sqlSession.close();
		if (result > 1) {
			return true;
		}
		return false;
	}
	
}
