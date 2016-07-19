package dao;

import java.util.List;

import bean.Os;

public interface OsDao {
    public List<Os> findAll();
	
	public Os findOne(int osId);
	
	public boolean add(Os os);
	
	public boolean del(int osId);
	
	public boolean update(Os os);

}
