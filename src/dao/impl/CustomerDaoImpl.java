package dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.SQLError;

import bean.Customer;
import dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {
	
	private Connection conn ;
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
	public int add(Customer customer) {
		// TODO Auto-generated method stub
		String sql  = "INSERT into customer(customerName,idNumber,phone)VALUES(?,?,?)";
		int i = 0;
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2,customer.getIdNumber());
			ps.setString(3, customer.getPhone());
			i = ps.executeUpdate();
			return i;
		}catch(SQLException se){
			se.printStackTrace();
			return i;
		}
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
	
}
