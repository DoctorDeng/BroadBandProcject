package dao;

import java.util.List;
import java.util.Map;

import bean.AdminInfor;
import bean.Tariff;

public interface AdminInforDao {

	public List<Map<String, Object>> findAll();
	
	public AdminInfor findOne(int adminInforId);
	
	public boolean add(AdminInfor adminInfor);
	
	public boolean del(int adminInforId);
	
	public boolean update(AdminInfor adminInfor);
	
}
