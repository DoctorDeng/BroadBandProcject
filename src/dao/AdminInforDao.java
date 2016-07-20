package dao;

import java.util.List;

import bean.AdminInfor;
import bean.Tariff;

public interface AdminInforDao {

	public List<AdminInfor> findAll();
	
	public AdminInfor findOne(int adminInforId);
	
	public boolean add(AdminInfor adminInfor);
	
	public boolean del(int adminInforId);
	
	public boolean update(AdminInfor adminInfor);
	
}
