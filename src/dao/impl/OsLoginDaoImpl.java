package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Oslogin;
import dao.OsLoginDao;
import util.DBHelper;

public class OsLoginDaoImpl implements OsLoginDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<Oslogin> findAll() {
		// TODO Auto-generated method stub
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
