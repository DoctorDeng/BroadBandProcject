package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.viewBean.BussinessViewBean;
import dao.BussinessViewDao;
import util.DBHelper;

public class BussinessViewBeanDaoImpl implements BussinessViewDao {

	private DBHelper db = new DBHelper();
	private Connection conn = db.getConnection() ;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<BussinessViewBean> findAll() {
		// TODO Auto-generated method stub 
		List<BussinessViewBean> view = new ArrayList<BussinessViewBean>();
		
		String sql = " SELECT t.tariffId,a.adminId,c.idNumber,c.customerName,o.osAccount,t.tariffName,o.serverIp,t.status FROM "
				+ "customer c,admin a ,bussiness b, os o ,tariff t "
				+ "WHERE a.adminId = b.adminId "
				+ "AND b.osId = o.osId "
				+ "AND O.customerId = c.customerId "
				+ "AND t.tariffId = o.tariffId ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				BussinessViewBean viewbean = new BussinessViewBean();
				viewbean.setTariffId(Integer.parseInt(rs.getString(1)));
				viewbean.setAdminId(Integer.parseInt(rs.getString(2)));
				viewbean.setIdNumber(rs.getString(3));
				viewbean.setCustomerName(rs.getString(4));
				viewbean.setOsAccount(rs.getString(5));
				viewbean.setTraiffName(rs.getString(6));
				viewbean.setServerId(rs.getString(7));
				view.add(viewbean);
			}
			return view;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		return view;
	}


}
