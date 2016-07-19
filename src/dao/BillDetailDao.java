package dao;

import java.util.List;

import bean.BillDetail;


public interface BillDetailDao {
public List<BillDetailDao> findAll();
	
	public BillDetailDao findOne(int billDetailId);
	
	public boolean add(BillDetail billdetail);
	
	public boolean del(int billDetailId);
	
	public boolean update(BillDetail billdetail);
}
