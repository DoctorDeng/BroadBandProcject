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
		String sql = " SELECT bussiness.bussinessId, admininfor.adminId, customer.idNumber, customer.customerName, "
				+ "os.osAccount,bussiness.`status`, os.serverIp, tariff.tariffName "
				+ " FROM  "
				+ " bussiness,"
				+ " admininfor,"
				+ " customer,"
				+ " os,tariff "
				+ " WHERE "
				+" bussiness.customerId = customer.customerId AND "
				+" admininfor.idNumber = customer.idNumber AND "
				+" os.tariffId = tariff.tariffId AND "
				+" bussiness.`status` = tariff.`status` AND "
				+" os.customerId = customer.customerId ";				;
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
				viewbean.setStatus(rs.getString(6));
				viewbean.setServerId(rs.getString(7));
				viewbean.setTraiffName(rs.getString(8));
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
	public int add(ServiceAddViewBean serviceAddViewBean) {
			
			String sql  = "INSERT into os(customerId,tariffId,osAccount,osPassword,serverIp)VALUES(?,?,?,?,?)";
			int i = 0;
			try{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, serviceAddViewBean.getCustomerId());
				ps.setInt(2,serviceAddViewBean.getTariffId());
				ps.setString(3, serviceAddViewBean.getOsAccount());
				ps.setString(4, serviceAddViewBean.getOsPassword());
				ps.setString(5, serviceAddViewBean.getServerId());
				i = ps.executeUpdate();	
				return i;
			}catch(SQLException se){
				se.printStackTrace();
			}
			return i;
	}
	@Override
	public List<ServiceAddViewBean> find(ServiceAddViewBean serviceAddViewBean) {
		// TODO Auto-generated method stub
		List<ServiceAddViewBean> siew = new ArrayList<ServiceAddViewBean>();
		String sql = "SELECT a.adminId, c.customerId FROM customer AS c , admininfor AS a "
				+ " WHERE "
				+ " c.idNumber = ? AND "
				+ " c.idNumber = a.idNumber" ;
		//System.out.println(sql);
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, serviceAddViewBean.getIdNumber());
			rs = ps.executeQuery();
			System.out.println(sql);
			while(rs.next()){
				ServiceAddViewBean svb = new ServiceAddViewBean();
				svb.setAdminId(rs.getInt(1));
				svb.setCustomerId(rs.getInt(2));
				siew.add(svb);
				//System.out.println(rs.getInt(1));
				//System.out.println(rs.getInt(2));
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
	@Override
	public boolean del(BussinessViewBean bussinessViewBean) {
		// TODO Auto-generated method stub
		String sql= "delete from bussiness where bussinessId="+bussinessViewBean.getBussinessId();
		int rs = DBHelper.update(sql, null);
		if(rs>0){
			return true;
		}
		return false;
	}
	@Override
	public List<BussinessViewBean> findOne(ServiceAddViewBean serviceAddViewBean) {	
		// TODO Auto-generated method stub
		List<BussinessViewBean> view = new ArrayList<BussinessViewBean>();
		String osAccount = serviceAddViewBean.getOsAccount();
		String idNumber  = serviceAddViewBean.getIdNumber();
		String status    = serviceAddViewBean.getStatus();
		String serverIp  = serviceAddViewBean.getServerId();
		System.out.println(osAccount);
		System.out.println(idNumber);
		System.out.println(status);
		System.out.println(serverIp);
		StringBuffer sql = new StringBuffer( " SELECT bussiness.bussinessId, admininfor.adminId, customer.idNumber, customer.customerName, os.osAccount,bussiness.`status`, os.serverIp, tariff.tariffName "
				+ " FROM  "
				+ " bussiness,"
				+ " admininfor,"
				+ " customer,"
				+ " os,tariff "
				+ " WHERE "
				+" bussiness.customerId = customer.customerId AND "
				+" admininfor.idNumber = customer.idNumber AND "
				+" os.tariffId = tariff.tariffId AND "
				+" bussiness.`status` = tariff.`status` AND "
				+" os.customerId = customer.customerId ");				;
		try {
			if( !("#".equals(osAccount))){
				sql.append( " AND os.osAccount = '" + osAccount +"'");
			}
			if( !("#".equals(idNumber))){
				sql.append( " AND customer.idNumber = '" + idNumber +"'");
			}
			if( !("0".equals(status))){
				sql.append( " AND bussiness.`status` = " + status );
			}
			 if( !("#".equals(serverIp))){
				 sql.append( " AND os.serverIp = '" + serverIp+"'");
			}	
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			System.out.println(sql);
			while(rs.next()){
				BussinessViewBean viewbean = new BussinessViewBean();
				viewbean.setBussinessId(Integer.parseInt(rs.getString(1)));
				viewbean.setAdminId(Integer.parseInt(rs.getString(2)));
				viewbean.setIdNumber(rs.getString(3));
				viewbean.setCustomerName(rs.getString(4));
				viewbean.setOsAccount(rs.getString(5));
				viewbean.setStatus(rs.getString(6));
				viewbean.setServerId(rs.getString(7));
				viewbean.setTraiffName(rs.getString(8));
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
