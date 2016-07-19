package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalMySqlUtil {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_NAME = "imooc";
	private static final String USER = "root";
	private static final String PWD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/"+ DATABASE_NAME + 
			"?user=" + USER +
			"&password=" + PWD +
			"&useUnicode=true" + 
			"&useSSL=false" +
			"&characterEncoding=UTF-8";
	private static Connection conn = null;
	
	/**
	 * 建立JDBC-ORACLE的桥接器
	 */
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库的链接
	 * @return 返回数据库的连接对象
	 */
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库的连接
	 */
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
