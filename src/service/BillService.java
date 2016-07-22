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
		/**
		 * 总的费用
		 */
		double cost = 0;
		/**
		 * 总时长
		 */
		int    times = 0;
		/**
		 * 资费类型
		 */
		String tariffType = "";
		double tariff = 0;
		int    timeTariff = 0;
		int    timeLong = 0;
		
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = list.get(i);
			
			tariffType = map.get("tariffType").toString();
			times += Integer.parseInt(map.get("timeLong").toString());
		}
		
		if ("2".equals(tariffType)) {
			
			
			
		} else if ("3".equals(tariffType)){
			
		}
		
		return new ArrayList<Map<String,Object>>();
	}
	
}
