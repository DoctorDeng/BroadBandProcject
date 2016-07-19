package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Admin;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
    
	public List<Admin> findAll(){
		return null;
	}
	
	public Admin findOne(int adminId){
		return null;
	}
	
	public boolean add(Admin admin){
		return false;
	}
	
	public boolean update(Admin admin){
		return false;
	}
	
	
}
