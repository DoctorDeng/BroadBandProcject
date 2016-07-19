package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MySqlCURDDaoImpl {

	private Connection conn;
	private PreparedStatement ps;
	private MySqlUtil sqlUtil;
	
	public MySqlCURDDaoImpl() {
		sqlUtil = new  MySqlUtil();
		conn = sqlUtil.getConn();
	}
	
	public void destroy() {
		try {
			if (null != conn) {
				conn.close();
				conn = null;
			}
			if (null != ps) {
				ps.close();
				ps = null;
			}
		} catch(SQLException e) {
			System.out.println("连接关闭错误");
			e.printStackTrace();
		}
	}
	
	public void init(String sql) {
		try {
			if (null == conn) {
				conn = sqlUtil.getConn();
			}
			if (null == ps) {
				ps = conn.prepareStatement(sql);
			}
		} catch(SQLException e) {
			System.out.println("获取连接错误！");
			e.printStackTrace();
		}
	}
	
	public boolean insert(String sql, List<String> str) {
		try {
			init(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			destroy();
		}
	}

	public boolean delete(String sql, List<String> str) {
		try {
			init(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

	public boolean update(String sql, List<String> str) {
		try {
			init(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

	@SuppressWarnings("finally")
	public Vector<String[]> select(String sql, List<String> str) {
		Vector<String[]> vector = new Vector<>();
		try {
			init(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while(rs.next()) {
				String[] dataStr = new String[metaData.getColumnCount()];
				for (int i=0; i<dataStr.length; i++) {
					dataStr[i] = rs.getString(i+1);
				}
				vector.add(dataStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroy();
			return vector;
		}
	}

}
