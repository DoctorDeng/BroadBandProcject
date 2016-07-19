package dao;

import java.util.List;


public interface BillDetailDao {
public List<BillDetailDao> findAll();
	
	public BillDetailDao findOne(int billDetailId);
	
	public boolean add(BillDetailDao billdetail);
	
	public boolean del(int billDetailId);
	
	public boolean update(BillDetailDao billdetail);
}
