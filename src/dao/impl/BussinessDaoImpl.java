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
		Bussiness b =  new Bussiness();
		String sql = "select * from bussiness where bussinessId="+bussinessId;
		List<Map<String, Object>> l = DBHelper.find(sql, null);
		for(Map<String, Object> m:l){
			b.setCustomerId(Integer.parseInt(m.get("customerId").toString()));
		}
		return b;
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
		String sql= "delete from bussiness where bussinessId="+bussinessId.getBussinessId();
		int rs = DBHelper.update(sql, null);
		if(rs>0){
			return true;
		}
		return false;
	}
	
	public boolean update(Bussiness bussiness){
		String sql= "update bussiness set loginAccount='"+bussiness.getLoginAccount()+"',password='"+bussiness.getPassword()+
				"' where bussinessId="+bussiness.getBussinessId();
		String[] fields = null;
		int rs = DBHelper.update(sql, fields);
		if(rs>0){
			return true;
		}
		return false;
	}
	
	public boolean updateStatus(Bussiness bussiness){
		String status = bussiness.getStatus();
		if(status.trim().equals("0")||status==null||status.equals("")){
			status = "1";
		}else if("1".equals(status.trim())){
			status = "0";
		}
		String sql= "update bussiness set status="+status+
				" where bussinessId="+bussiness.getBussinessId();
		String[] fields = null;
		int rs = DBHelper.update(sql, fields);
		if(rs>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Bussiness> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public static void main(String[] args){
		
		
		int cu = new BussinessDaoImpl().findOne(10).getCustomerId();
		System.out.println(cu);
	}*/
	
}
