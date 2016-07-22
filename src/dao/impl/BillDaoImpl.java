package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Bill;
import bean.viewBean.BillViewBean;
import dao.BillDao;
import util.DBHelper;

public class BillDaoImpl implements BillDao{

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill findOne(int billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Bill bill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(int billId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bill bill) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 多表查询，查询出所有的账单表单数据
	 * @return   返回一个与表单数据对应的表单bean
	 */
	public  List<BillViewBean> findBillForm() {
		List<BillViewBean> billViewList = new ArrayList<>();
		String sql = "SELECT bi.billId,cu.customerName, cu.idNumber, adminAccount, bi.cost,bi.month,bi.payWay,bi.payStatus "
				+ "FROM bill as bi "
				+ "INNER JOIN customer as cu ON bi.customerId = cu.customerId " 
				+ "INNER JOIN admin as ad On bi.adminId = ad.adminId";
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = list.get(i);
			
			int    billId       = Integer.parseInt(map.get("billId").toString());
			String customerName = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String adminAccount = map.get("adminAccount").toString();
			double cost         = Double.parseDouble(map.get("cost").toString());
			String month        = map.get("month").toString();
			String payWay       = map.get("payWay").toString();
			String payStatus    = map.get("payStatus").toString();
			
			BillViewBean billViewBean = new BillViewBean(billId, customerName, idNumber, adminAccount, cost, month, payWay, payStatus);
			billViewList.add(billViewBean);
		}
		return billViewList;
	}
	/**
	 * 多表操作，查找客户（Customer）每个账号的账单记录
	 * @param billId   客户账单ID
	 * @return         返回客户每个账号的账单记录
	 */
	public List<Map<String,Object>> findBillDetailForm(int billId) {
		String sql = "SELECT billDetailId,os";
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		
		return list;
	}
	
	public static void main(String[] args) {
		BillDaoImpl billDao = new BillDaoImpl();
		System.out.println(billDao.findBillForm().get(0).toString());
	}
	

}
