package dao;

import java.util.List;

import bean.Bill;

public interface BillDao {
 
	public List<Bill> findAll();
	
	public Bill findOne(int billId);
	
	public boolean add(Bill bill);
	
	public boolean del(int billId);
	
	public boolean update(Bill bill);
	
}
