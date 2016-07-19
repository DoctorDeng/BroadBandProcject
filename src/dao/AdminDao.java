package dao;

import java.util.List;

import bean.Admin;

public interface AdminDao {
	public List<Admin> findAll();
	
	public Admin findOne(int adminId);
	
	public boolean add(Admin admin);
	
	public boolean update(Admin admin);
}
