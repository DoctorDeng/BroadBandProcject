package dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import com.mysql.jdbc.SQLError;

import bean.Customer;
import bean.viewBean.AccountViewBean;
import dao.CustomerDao;
import util.DBHelper;

public class CustomerDaoImpl implements CustomerDao {
	private DBHelper db = new DBHelper();
	private Connection conn = db.getConnection() ;
	private PreparedStatement ps;
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(int CustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Customer customer) {
		// TODO Auto-generated method stub
		String sql  = "INSERT into customer(customerName,idNumber,phone)VALUES(?,?,?)";
		int i = 0;
		try{
			conn = db.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getCustomerName().trim());
			ps.setString(2, customer.getIdNumber().trim());
			ps.setString(3, customer.getPhone().trim());
			System.out.println(customer.getCustomerName().trim());
			System.out.println(customer.getIdNumber().trim());
			System.out.println(customer.getPhone().trim());
			i = ps.executeUpdate();		
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭连接出错");
			}
		}	
		if(i == 0) return false;
		else return true;
	}

	@Override
	public boolean del(Customer customer) {
		String sql= "delete from customer where customerId="+customer.getCustomerId();
		System.out.println(sql);
		int rs = DBHelper.update(sql, null);
		if(rs>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		String sql  = "update customer set customerName='"+customer.getCustomerName()+
		"',idNumber="+customer.getIdNumber()+",phone="+customer.getPhone()+
		" where customerId="+customer.getCustomerId();
		System.out.println(sql);
		int i = 0;
		String[] fields = null;
		i = DBHelper.update(sql, fields);
		if(i < 1) return false;
		else return true;
	}
	
	public Customer findByIdNumber(String idNumber){
		Customer c = new Customer();
		String sql = "select customerId from customer where idNumber="+idNumber;
		String[] fields = null;
		List<Map<String,Object>> list = DBHelper.find(sql, fields);
		for(Map<String,Object> m:list){
			c.setCustomerId(Integer.parseInt(m.get("customerId").toString()));
		}
		return c;
	}
	
	/*public static void main(String[] args){
		Customer c = new Customer();
		c.setCustomerId(16);
		c.setCustomerName("哈哈");
		c.setIdNumber("1111111111111111");
		c.setPhone("18186323116");
		new CustomerDaoImpl().update(c);
	}*/
	
}
