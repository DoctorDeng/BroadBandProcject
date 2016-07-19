package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_NAME = "kuandai";
	private static final String USER = "root";
	private static final String PWD = "denghuajie123";
	private static final String URL = "jdbc:mysql://119.29.223.16:3306/"+ DATABASE_NAME + 
			"?user=" + USER +
			"&password=" + PWD +
			"&useUnicode=true" + 
			"&useSSL=false" +
			"&characterEncoding=UTF-8";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	/**
	 * 通过数据源获得连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			/*Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/mysql/kuandai");*/
			 DriverManager.getConnection(URL);
			conn =  DriverManager.getConnection(URL);
		} /*catch (NamingException e) {
			System.out.println("数据源不存在");
			e.printStackTrace();
		} */catch (SQLException e) {
			System.out.println("数据源获取连接出错");
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 获得预编译声明
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		getConnection();
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取预编译对象PreparedStatement出现错误");
		}
		return ps;
	}
	
	public static List<Map<String, Object>> find(String sql, Object...obj) {
		/**
		 * 存放结果集合
		 */
		List<Map<String, Object>> list = new ArrayList<>();
		getPreparedStatement(sql);
		try {
			if (null != obj) {
				if (obj.length >0) {
					for (int i=0;i <obj.length; i++) {
						ps.setObject(i, obj[i]);
						ps.setObject(i+1, obj[i]);
					}
				}
			}
			rs = ps.executeQuery();
			/**
			 * 获得结果集的元数据
			 */
			ResultSetMetaData metaDate = rs.getMetaData();
			int colsNum = metaDate.getColumnCount();
			
			while(rs.next()) {
				/**
				 * 用于存储结果集某一行的数据
				 */
				Map<String, Object> map = new HashMap<>();
				
				for (int i=0; i<colsNum; i++) {
					String colsName = metaDate.getColumnName(i + 1);
					/**
					 * 获得列值
					 */
					Object colsValue = rs.getObject(colsName);
					if (colsValue == null) {
						colsValue = "";
					}
					map.put(colsName, colsValue);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询出错!");
		} finally {
			closeAll();
		}
		return list;
	}
	
	public static <T> List<T> find(T javaBean, String sql, Object...obj) {
		List<Map<String, Object>> list = new ArrayList<>();
		getPreparedStatement(sql);
		
		try {
			if (obj.length >0) {
				for (int i=0; i<obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData metaDate = rs.getMetaData();
			int colsNum = metaDate.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				
				for (int i=0; i<colsNum; i++) {
					String colsName = metaDate.getColumnName(i + 1);
					Object colsValue = rs.getObject(colsName);
					if (colsValue == null) {
						colsValue = "";
					}
					map.put(colsName, colsValue);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询时出错");
		} finally {
			closeAll();
		}
		List<T> resultList = MapUtil.mapToJava(javaBean, list);
		return resultList;
	}
	
	/**
	* 单个查询，传入什么类型的，返回什么类型。泛型bean
	*
	* @return T
	* */
	public static <T> T findOne(T javaBean, String sql, Object... obj) {
		List<T> list = find(javaBean, sql, obj);
		if (list == null || list.size() == 0) {// list为空返回null，除去空指针异常
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 查询总数据
	 */
	public static int dateCount(String sql) {
		ps = getPreparedStatement(sql);
		int row = 0;
		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("查询总数据条数失败！");
		}
		return row;
	}
	/**
	* 查询，返回ResultSet结果集
	*
	* @return ResultSet
	* */
	public static ResultSet findMany(String sql, Object... obj) {
		/*
		 * 可变参数的特点：只能出现在参数列表的最后；
		 * ...位于变量类型和变量名之间，前后有无空格都可以；调用可变参数的方法时，编译器为该可变参数隐含创建一个数组
		 * ，在方法体中一数组的形式访问可变参数。
		 */
		getPreparedStatement(sql);// 实例化预编译对象ps
		try {
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {// 循环把参数 赋给预编译的声明
					ps.setObject(i + 1, obj[i]);
				}
			}
			rs = ps.executeQuery();// 获得查询结果
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询时出错");
		} finally {
			closeAll();
		}
		return rs;
	}
	/**
	* update 执行修改数据
	*
	* @return int
	* */
	public static int update(String sql, Object... obj) {
		int result = 0;
		getPreparedStatement(sql);// 实例化预编译对象ps
		try {
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("执行DML语句(增，删，改)时出现错误");
		} finally {
			closeAll();
		}
		return result;
	}

	/**
	 * 释放资源
	 */
	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("关闭连接出错");
		}
	}
}
