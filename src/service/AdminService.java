package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Admin;
import bean.AdminPower;
import bean.Page;
import bean.Power;
import bean.dto.PageDto;
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
		sqlSession.rollback();
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
		sqlSession.rollback();
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
		sqlSession.rollback();
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
		sqlSession.rollback();
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
	 * 分页查询管理员表信息
	 * @param currentPageStr  当前页码的字符串表现形式
	 * @param pageSize        页面数据条数
	 * @return  PageDto<Admin>
	 */
	public PageDto<Admin> selectFromPage(String currentPageStr, int pageSize){
		init();
		int totle=adminMapper.selectAdminCount();
		PageDto<Admin> pagedto=new PageDto<>();
		pagedto.init(totle, pageSize, currentPageStr);
		List<Admin> lsadmin=adminMapper.selectByPage(new Page((pagedto.getCurrentPage()-1)*pageSize,pageSize));
		pagedto.setDataList(lsadmin);
		close();
		return pagedto;
	}
	/**
	 * 通过管理员姓名查询管理员
	 * @param adminName  管理员姓名
	 * @return   List<Admin>
	 */
	public List<Admin> getAdminByCondition(String adminName,String power) {
		init();
		Map map = new HashMap();
		map.put("adminName", adminName);

		List<Admin> adminList = new ArrayList<>();
		List<Admin> admins = adminMapper.selectAdminByCondition(map);
		/**
		 * 当权限为空时直接返回查询结果
		 */
		if (StringUtil.isNull(power)) {
			return admins;
		}
		/**
		 * 当管理员中有power这个权限时，将管理员添加到返回的管理员集合中.
		 */
		for (int i=0; i<admins.size(); i++) {
			Admin admin = admins.get(i);
			List<Power> powers = admin.getPowers();
			if (null != powers) {
				for (int j=0; j<powers.size(); j++) {
					Power powerTemp = powers.get(j);
					if (power == powerTemp.getPower() | powerTemp.getPower().equals(power)) {
						adminList.add(admin);
					}
				}
			}
		}
		close();
		return adminList;
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
	/**
	 * 提交关闭SqlSession
	 */
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
	public static void main(String[] args) {
	/*	AdminService adminService = new AdminService();*/
		/*Admin admin = new Admin();
		admin.setAdminAccount("testForadd");
		admin.setAdminName("doctorTest");
		admin.setEmail("22@#");
		admin.setIdNumber("sdfsdf");
		admin.setPhone("12546");
		admin.setPassword("123456");
		List<Power> powers = new ArrayList<>();
		Power power = new Power();
		power.setPowerId(1);
		powers.add(power);
		admin.setPowers(powers);
		System.out.println(adminService.addAdmin(admin));*/
		/*List<Admin> admins = adminService.getAdminByCondition("邓", "1");
		for (Admin admin:admins) {
			System.out.println(admin.toString());
		}*/
	}
}
