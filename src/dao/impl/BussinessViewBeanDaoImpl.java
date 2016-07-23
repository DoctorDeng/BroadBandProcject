package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;
import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;
import dao.BussinessViewDao;
import service.CustomerService;
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
		String sql = " SELECT bussiness.bussinessId, admininfor.adminId,customer.idNumber,customer.customerName,os.osAccount,bussiness.`status`,os.serverIp,tariff.tariffId "
				+ " FROM  "
				+ " bussiness,"
				+ " admininfor,"
				+ " customer,"
				+ " os,tariff "
				+ " WHERE "
				+" admininfor.idNumber = customer.idNumber AND "
				+" os.customerId = customer.customerId AND "
				+" os.tariffId = tariff.tariffId AND "
				+" os.customerId = bussiness.customerId ";
		//System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				BussinessViewBean viewbean = new BussinessViewBean();
				viewbean.setBussinessId(Integer.parseInt(rs.getString(1)));
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
			CustomerService customerM = new CustomerService();
			Customer customer = new Customer();
			String sql  = "INSERT into os(customerId,tariffId,osAccount,osPassword,serverIp)VALUES(?,?,?,?,?)";
			int i = 0;
			try{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, customer.getCustomerId());
				ps.setString(2,serviceAddViewBean.getTraiffName());
				ps.setString(3, serviceAddViewBean.getTraiffName());
				ps.setInt(4, serviceAddViewBean.getOsLoginId());
				ps.setString(5, serviceAddViewBean.getOsPassword());
				i = ps.executeUpdate();		
			}catch(SQLException se){
				se.printStackTrace();
			}
			if(i == 0) return false;
			else return true;
	}
	@Override
	public List<ServiceAddViewBean> find(ServiceAddViewBean serviceAddViewBean) {
		// TODO Auto-generated method stub
		List<ServiceAddViewBean> siew = new ArrayList<ServiceAddViewBean>();
		ServiceAddViewBean sab = new ServiceAddViewBean();
		String sql = "SELECT a.adminId, c.customerId FROM customer AS c , admininfor AS a "
				+ " WHERE "
				+ " c.idNumber = ? AND "
				+ " c.idNumber = a.idNumber" ;
		//System.out.println(sql);
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, sab.getIdNumber());
			rs = ps.executeQuery();
			while(rs.next()){
				ServiceAddViewBean svb = new ServiceAddViewBean();
				svb.setAdminId(rs.getInt(1));
				svb.setCustomerId(rs.getInt(2));
				siew.add(svb);
			}
			return siew;
		}catch(SQLException se){
			se.printStackTrace();
		}
		return siew;
	}
	@Override
	public boolean update(BussinessViewBean bussinessViewBean) {
		// TODO Auto-generated method stub
		/*System.out.println(bussinessViewBean.getTraiffId());
		System.out.println(bussinessViewBean.getOsAccount());*/
		String sql = "UPDATE os SET tariffId = ? WHERE osAccount = ?";
		int i = 0 ;
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bussinessViewBean.getTariffId());
			ps.setString(2, bussinessViewBean.getOsAccount());
			i=ps.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}
		if(i == 0) return false;
		else return true;
	}

}
