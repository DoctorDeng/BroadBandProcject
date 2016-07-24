package dao.impl;

import java.util.List;
import java.util.Map;

import util.DBHelper;

/**
 * 报表Dao
 * @author Doctor邓
 *
 */
public class StatementDaoImpl {
	/**
	 * 获取报表信息
	 * @return  报表信息的集合
	 */
	public List<Map<String,Object>> findAllStatement() {
		String sql = "select bussinessId, loginAccount,customerName,idNumber,phone, "
				+"(SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM os WHERE customerId = cu.customerId)) as totalTime "
				+"FROM bussiness as bu "
				+"INNER JOIN customer as cu "
				+"ON cu.customerId = bu.customerId";
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		return list;
	}
	/**
	 * 获取通过时长排序的报表信息
	 * @return
	 */
	public List<Map<String,Object>> findAllStatementByDesc() {
		String sql = "select bussinessId, loginAccount,customerName,idNumber,phone, "
				+"(SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM os WHERE customerId = cu.customerId)) as totalTime "
				+"FROM bussiness as bu "
				+"INNER JOIN customer as cu "
				+"ON cu.customerId = bu.customerId "
				+"ORDER BY totalTime DESC";
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		return list;
	}
	/**
	 * 获取指定页面的报表信息
	 * @param index        页面第一条记录起始位置
	 * @param pageSize     页面记录总数量
	 * @return             报表信息集合
	 */
	public List<Map<String,Object>> findStatementPage(int index, int pageSize) {
		String sql = "select bussinessId, loginAccount,customerName,idNumber,phone, "
				+"(SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM os WHERE customerId = cu.customerId)) as totalTime "
				+"FROM bussiness as bu "
				+"INNER JOIN customer as cu "
				+"ON cu.customerId = bu.customerId LIMIT " + index + "," + pageSize;
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		return list;
	}
	/**
	 * 获取指定页面通过时长由高到低排序的报表信息
	 * @param index        页面第一条记录起始位置
	 * @param pageSize     页面记录总数量
	 * @return             报表信息集合
	 */
	public List<Map<String,Object>> findStatementPageByDesc(int index, int pageSize) {
		String sql = "select bussinessId, loginAccount,customerName,idNumber,phone, "
				+"(SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM os WHERE customerId = cu.customerId)) as totalTime "
				+"FROM bussiness as bu "
				+"INNER JOIN customer as cu "
				+"ON cu.customerId = bu.customerId "
				+"ORDER BY totalTime DESC LIMIT " + index + "," + pageSize;
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		return list;
	}
}
