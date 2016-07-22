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
		}
		if(i == 0) return false;
		else return true;
	}

	@Override
	public boolean del(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		return false;
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
	
	
	
}
