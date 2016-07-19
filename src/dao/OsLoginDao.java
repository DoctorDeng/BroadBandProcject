package dao;

import java.util.List;

import bean.Oslogin;

public interface OsLoginDao {

	public List<Oslogin> findAll();
	
	public Oslogin findOne(int osloginId);
	
	public boolean add(Oslogin oslogin);
	
	public boolean del(int osloginId);
	
	public boolean update(Oslogin oslogin);
	
}
