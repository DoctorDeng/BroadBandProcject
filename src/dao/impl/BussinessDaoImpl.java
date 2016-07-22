package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Bussiness;
import dao.BussinessDao;
import util.DBHelper;

public class BussinessDaoImpl implements BussinessDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	/*public List<Bussiness> findAll(){
		List<Bussiness> l = new ArrayList<Bussiness>();
		conn = DBHelper.getConnection();
		try {
			ps = conn.prepareStatement("select * from bussiness");
			rs = ps.executeQuery();
			while(rs.next()){
				Bussiness b = new Bussiness();
				b.setBussinessId(rs.getInt(1));
				//b.setAdminId(rs.getInt(2));
				//b.setOsId(rs.getInt(3));
				b.setStatus(rs.getString(4));
				l.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}*/
	
	public Bussiness findOne(int bussinessId){
		return new Bussiness();
	}
	
	public boolean add(Bussiness bussiness){
		String sql= "insert into bussiness(loginAccount,createTime,status,lastLoginTime,password,customerId) "
				+ "values(?,?,?,?,?,?)";
		String[] fields = {bussiness.getLoginAccount(),bussiness.getCreateTime(),bussiness.getStatus(),
				bussiness.getLastLoginTime(),bussiness.getPassword(),Integer.valueOf(bussiness.getCustomerId()).toString()};
		int rs = DBHelper.update(sql, fields);
		if(rs>0){
			return true;
		}
		return false;
	}
	
	public boolean del(Bussiness bussinessId){
		return false;
	}
	
	public boolean update(Bussiness business){
		return false;
	}

	@Override
	public List<Bussiness> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
