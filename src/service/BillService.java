package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Bill;
import dao.impl.BillDaoImpl;
import dao.impl.OsLoginDaoImpl;

public class BillService {
	private OsLoginDaoImpl  osLoginDao;
	
	public BillService() {
		osLoginDao = new OsLoginDaoImpl();
	}
	/**
	 * 获取账单表格显示所需要的信息，涉及到多表查询，暂时统一封装在Bill里面
	 */
	public List<Bill> getBill(){
		return new BillDaoImpl().findAll();
	}
	
	
	public List<Map<String,Object>>  getOsLoginForm(int osId) {
		List<Map<String,Object>> list = osLoginDao.findLoginFormById(osId);
		
		double cost = 0;
		
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = list.get(i);
			
			String tariffType = map.get("timeLogin").toString();
		}
		
		return new ArrayList<Map<String,Object>>();
	}
	
}
