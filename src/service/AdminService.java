package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Admin;
import bean.AdminPower;
import bean.Power;
import mapper.AdminMapper;
import mapper.AdminPowerMapper;
import util.SqlSessionUtil;
import util.StringUtil;

public class AdminService {
	
	private SqlSession sqlSession;
	private AdminMapper adminMapper;
	private AdminPowerMapper adminPowerMapper;
	
	public AdminService() {
	}
	/**
	 * 添加管理员 
	 * @param admin    管理员   
	 * @return         添加成功返回true，失败返回false;
	 */
	public boolean  addAdmin(Admin admin) {
		init();
		adminPowerMapper = sqlSession.getMapper(AdminPowerMapper.class);
		//判断管理员账号是否为空
		if (!StringUtil.isNull(admin.getAdminAccount())) {
			//判断数据库中是否有此管理员
			if(StringUtil.isNull(adminMapper.verifyAdminAccount(admin.getAdminAccount()))) {
				int addAdminResult = adminMapper.insertAdmin(admin);
				//判断是否添加成功
				if(addAdminResult == 1) {
					String adminIdStr = adminMapper.selectAdminIdByAccount(admin.getAdminAccount());
					if (!StringUtil.isNull(adminIdStr)) {
						int adminId = Integer.parseInt(adminIdStr);
						
						List<AdminPower> adminPowers = new ArrayList<>();
						List<Power> powers = admin.getPowers();
						
						for (Power power: powers) {
							AdminPower adminPower = new AdminPower();
							adminPower.setAdminId(adminId);
							adminPower.setPowerId(power.getPowerId());
							adminPowers.add(adminPower);
						}
						
						if (adminPowerMapper.insertAdminPower(adminPowers) > 0) {
							close();
							return true;
						}
					}
				} 
			}
		}
		sqlSession.close();
		return false;
	}
	/**
	 * 更新管理员的个人信息和权限
	 * @param admin   管理员  
	 * @return        更新成功返回true，失败返回false
	 */
	public boolean updateAdmin(Admin admin) {
		init();
		adminPowerMapper = sqlSession.getMapper(AdminPowerMapper.class);
		
		int updateAdminResult = adminMapper.updateAdminInfor(admin);
		if (updateAdminResult ==1) {
			int adminId = admin.getAdminId();
			
			adminPowerMapper.deleteAdminPower(adminId);
			
			List<AdminPower> adminPowers = new ArrayList<>();
			List<Power> powers = admin.getPowers();
			
			for (Power power: powers) {
				AdminPower adminPower = new AdminPower();
				adminPower.setAdminId(adminId);
				adminPower.setPowerId(power.getPowerId());
				adminPowers.add(adminPower);
			}
			if (adminPowerMapper.insertAdminPower(adminPowers) > 0) {
				close();
				return true;
			}
		}
		sqlSession.close();
		return false;
	}
	
	/**
	 * 删除指定管理员
	 * @param adminId  管理员ID
	 * @return         成功
	 */
	public boolean delAdmin(int adminId) {
		init();
		int result = adminMapper.deleteAdminById(adminId);
		if (result ==1) {
			close();
			return true;
		}
		sqlSession.close();
		return false;
	}
	/**
	 * 通过管理员ID获取管理员个人信息
	 * @param adminId  管理员ID
	 * @return         返回adminInfor，为查找成功，失败返回null
	 */
	public Admin getAdminById(int adminId) {
		init();
		Admin admin = adminMapper.selectAdminById(adminId);
		close();
		return admin;
	}
	/**
	 * 更新管理员的个人信息
	 * @param adminInfor   
	 * @return         更新成功返回TRUE，失败返回FALSE
	 */
	public boolean updateInfor(Admin admin) {
		init();
		int result = adminMapper.updateAdminInfor(admin);
		if (result ==1) {
			close();
			return true;
		}
		sqlSession.close();
		return false;
	}
	/**
	 * 获取所有管理员信息
	 * @return List<Admin>
	 */
	public List<Admin> getAllAdminInfor() {
		init();
		
		List<Admin> admins = adminMapper.selectAllAdmin();
		close();
		return admins;
	}
	
	/**
	 * 初始化SqlSession和mapper
	 */
	public void init(){
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			adminMapper = sqlSession.getMapper(AdminMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//提交关闭SqlSession
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
	public static void main(String[] args) {
		
	}
}
