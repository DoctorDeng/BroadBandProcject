package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Oslogin;
import dao.OsLoginDao;
import util.DBHelper;

public class OsLoginDaoImpl implements OsLoginDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<Oslogin> findAll() {
		List<Oslogin> l = new ArrayList<Oslogin>();
		conn = DBHelper.getConnection();
		try {
			ps = conn.prepareStatement("select * from oslogin");
			rs = ps.executeQuery();
			while(rs.next()){
				Oslogin b = new Oslogin();
				b.setOsLoginId((rs.getInt(1)));
				b.setOsId(rs.getInt(2));
				b.setLoginIp(rs.getString(3));
				b.setLoginInTime(rs.getString(4));
				b.setLoginOutTime(rs.getString(5));
				b.setTimeLong(rs.getInt(6));
				l.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Oslogin findOne(int osloginId) {
		// TODO Auto-generated method stub
		Oslogin o = new Oslogin();
		conn = DBHelper.getConnection();
			try {
				ps = conn.prepareStatement("select * from oslogin where osLoginId = ?");
				ps.setInt(1,osloginId);
				rs = ps.executeQuery();
							
				while(rs.next()){
								
					o.setOsId(rs.getInt(2));
					o.setLoginIp(rs.getString(3));
					o.setLoginInTime(rs.getString(4));
					o.setLoginOutTime(rs.getString(5));
					o.setTimeLong(rs.getInt(6));
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return o;
	}
	/**
	 * 通过宽带账号ID查询出所有的宽带账号登陆记录
	 * @param osId
	 * @return
	 */
	public List<Oslogin> findAlls(int osId) {
		List<Oslogin> n = new ArrayList<Oslogin>();
		conn = DBHelper.getConnection();
		try {
			ps = conn.prepareStatement("select * from oslogin where osId=?");
			ps.setInt(1, osId);
			rs = ps.executeQuery();
			while(rs.next()){
				Oslogin c = new Oslogin();
				c.setOsLoginId((rs.getInt(1)));
				c.setOsId(rs.getInt(2));
				c.setLoginIp(rs.getString(3));
				c.setLoginInTime(rs.getString(4));
				c.setLoginOutTime(rs.getString(5));
				c.setTimeLong(rs.getInt(6));
				n.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * 通过宽带账号ID查找宽带账号登陆表单信息
	 * @param osId  指定的宽带账号ID
	 * @return      包含宽带长账号登陆信息的集合
	 */
	public List<Map<String,Object>> findLoginFormById(int osId) {
		String sql = "SELECT ol.loginIp,ol.loginInTime,ol.loginOutTime,ta.tariffName,ta.tariff,ta.timeLong,ta.timeTariff,"
				+ "TIMESTAMPDIFF(SECOND,ol.loginInTime,ol.loginOutTime) as timeLogin "
				+ "FROM osLogin as ol "
				+ "INNER JOIN os "
				+ "ON ol.osId = os.osId "
				+ "INNER JOIN tariff as ta "
				+ "ON os.tariffId = ta.tariffId "
				+ "WHERE ol.osId = " + osId;
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		
		return list;
	}
	
	/**
	 * 通过宽带账号查找宽带账号登陆表单信息
	 * @param osAccount  指定的宽带账号
	 * @return           包含宽带长账号登陆信息的集合
	 */
	public List<Map<String,Object>> findLoginFormByAccount(String osAccount) {
		String sql = "SELECT ol.loginIp,ol.loginInTime,ol.loginOutTime,ta.tariffName,ta.tariff,ta.timeLong,ta.timeTariff"
				+ "TIMESTAMPDIFF(SECOND,ol.loginInTime,ol.loginOutTime) as timeTariff "
				+ "FROM osLogin as ol "
				+ "INNER JOIN os "
				+ "ON ol.osId = os.osId "
				+ "INNER JOIN tariff as ta "
				+ "ON os.tariffId = ta.tariffId "
				+ "WHERE ol.osAccount = " + osAccount;
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		
		return list;
	}
	
	@Override
	public boolean add(Oslogin oslogin) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean del(int osloginId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Oslogin oslogin) {
		// TODO Auto-generated method stub
		return false;
	}

}
