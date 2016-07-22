package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;
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
		
		String sql = " SELECT b.bussinessId,a.adminId,c.idNumber,c.customerName,o.osAccount,o.serverIp,b.status,t.tariffName"
				+ "customer c,admininfor a,bussiness b, os o ,tariff t  "
				+ "WHERE a.idNumber = c.idNumber "
				+ "AND b.idNumber = a.idNumber"
				+ "AND o.customerId = c.customerId  "
				+ "AND t.tariffId = o.tariffId  ";
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
	@Override
	public boolean add(ServiceAddViewBean serviceAddViewBean) {
		// TODO Auto-generated method stub
			String sql  = "INSERT into customer(customerName,idNumber,phone)VALUES(?,?,?)";
			int i = 0;
			try{
				ps = conn.prepareStatement(sql);
				ps.setString(1,serviceAddViewBean.getIdNumber());
				ps.setInt(2,serviceAddViewBean.getAdminId());
				ps.setString(3,serviceAddViewBean.getTraiffName());
				ps.setString(4, serviceAddViewBean.getTraiffName());
				ps.setInt(5, serviceAddViewBean.getOsLoginId());
				ps.setString(6, serviceAddViewBean.getOsPassword());
				i = ps.executeUpdate();		
			}catch(SQLException se){
				se.printStackTrace();
			}
			if(i == 0) return false;
			else return true;
	}

}
