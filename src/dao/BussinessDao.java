package dao;

import java.util.List;

import bean.Bussiness;

public interface BussinessDao {
/**
 * 定义一个查找所有业务的方法
 * @return
 */
	public List<Bussiness> findAll();
/**
 * 定义一个查找单个业务的方法
 */
	public Bussiness findOne(int bussinessId);
	
/**
 * 定义一个添加business的方法
 */
	public boolean add(Bussiness bussiness);
/**
 * 定义一个删除business信息的方法
 */
	public boolean del(Bussiness bussinessId);
/**
 * 定义一个更新business信息的方法
 */
	public boolean update(Bussiness business);
}

