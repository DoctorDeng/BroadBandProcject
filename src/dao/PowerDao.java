package dao;

import java.util.List;

import bean.Power;

public interface PowerDao {
	public List<Power> findAll();
	public Power findOne(int powerId);
}
