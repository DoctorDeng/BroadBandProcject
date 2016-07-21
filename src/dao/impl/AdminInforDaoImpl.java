package dao.impl;

import java.util.List;

import bean.AdminInfor;
import util.DBHelper;

public class AdminInforDaoImpl implements dao.AdminInforDao {
    
	/**
	 * 功能：查找所有管理员信息
	 * 查找成功返回管理员集合
	 */
	public List<AdminInfor> findAll(){
		String sql = "SELECT * FROM admininfor";
		List<AdminInfor> adminInforList = DBHelper.find(new AdminInfor(),sql,null);
		return adminInforList;  //返回一个集合
	}
	public AdminInfor findOne(int adminInforId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(AdminInfor adminInfor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(int adminInforId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(AdminInfor adminInfor) {
		// TODO Auto-generated method stub
		return false;
	}	
	/**
	 * 此方法是用来通过adminId查询管理员个人信息
	 * @param adminId
	 * @return  admininfor表示查到了管理员信息的一个对象
	 * @return  null表示没有查到
	 */
	public  AdminInfor findAdminInforByadminId(int adminId){
		String sql = "select * from adminInfor where adminId=?";
		String[] field = {String.valueOf(adminId)};
		AdminInfor admininfor = DBHelper.findOne(new AdminInfor(), sql, field);
		if (admininfor!=null) {
			return admininfor;
		}
		return null;  
	} 
	/**
	 * 通过inforId查询管理员个人信息
	 * @param adminId 
	 * @return  admininfor表示查到了管理员信息的一个对象
	 * @return  null表示没有查到
	 */
	public  AdminInfor findAdminInforByInforId(int inforId){
		String sql = "select * from adminInfor where inforId=?";
		String[] field = {String.valueOf(inforId)};
		AdminInfor admininfor = DBHelper.findOne(new AdminInfor(), sql, field);
		if (admininfor!=null) {
			return admininfor;
		}
		return null;  
	} 
	/**
	 * 添加管理员个人信息
	 * @param admininfor 管理员信息类对象
	 * @return 添加成功返回true 添加失败返回false 
	 */
	public boolean addAdminInfor(AdminInfor admininfor){
		int    adminId   = admininfor.getAdminId();
		String adminName = admininfor.getAdminName();
		String idNumber = admininfor.getIdNumber();
		String phone = admininfor.getPhone();
		String email = admininfor.getEmail();
		String sql  = "insert into adminInfor(adminId,adminName,idNumber,phone,email,createTime) values(?,?,?,?,?,now())";	
		String[] field = {String.valueOf(adminId),adminName,idNumber,phone,email};
		int result = DBHelper.update(sql,field);
	    if(result == 0){
	    	return false;
	    }
	    return true;
	}
	/**
	 * 更新管理员信息
	 * @param newEmail 需要更新的邮箱
	 * @param adminId  通过adminId查询到相应的管理员信息
	 * @return 更新成功返回true 更新失败返回false
	 */
	public boolean updateAdminInfor(AdminInfor adminInfor){
		int    adminId   = adminInfor.getAdminId();
		String adminName = adminInfor.getAdminName();
		String phone     = adminInfor.getPhone();
		String email     = adminInfor.getEmail();
		
		String sql = "update adminInfor set adminName = ?,phone = ?,email= ? where adminId = ?";
		String[] field = {adminName,phone,email,String.valueOf(adminId)};
		int result = DBHelper.update(sql, field);
		if(result == 0){
			return false;
		}
		return true;
	}
	/**
	 * 删除管理员个人信息
	 * @param adminId
	 * @return  删除成功返回true 删除失败返回false
	 */
	public boolean delAdminInfor(int adminId){
		String sql = "delete from adminInfor where adminId="+adminId;
		int result = DBHelper.update(sql, null);
		if(result == 0){
			return false;
		}
		return true;
	}
	/**
	 * 开启账务账号
	 * @param adminId   指定的账号ID
	 * @return 开启成功返回true ，开启失败返回false
	 */
	public boolean updateAdminStatus(int adminId) {
		String sql = "update adminInfor set status = 1 WHERE adminId = " + adminId;
		
		int result = DBHelper.update(sql, null);
		if (result ==0) {
			return false;
		}
		return true;
	}
	
	
	
	public static void main(String[] args){
		AdminInforDaoImpl admininforDao = new AdminInforDaoImpl();
		/*AdminInfor admininfor = new AdminInfor();
		admininfor.setAdminId(1);
		admininfor.setIdNumber("542123199612270023");
		admininfor.setEmail("1541@qq.com");
		admininfor.setPhone("13277412390");
		admininforDao.addAdminInfor(admininfor);*/
		/*boolean bb = admininforDao.updateAdminInfor("151@qq.com", "1");
		System.out.println(bb);
		*/
        /* admininforDao.delAdminInfor(1);*/
        /* System.out.println(admininforDao.findAll().size());
         System.out.println(admininforDao.findAdminInforByadminId(1).getEmail());   
         System.out.println(admininforDao.findAdminInforByInforId(8).getEmail()); */
//		admininforDao.updateAdminStatus(1);
	}	
}
