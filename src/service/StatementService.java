package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.vo.StatementFormBean;
import mapper.impl.StatementDaoImpl;

/**
 * 报表模块
 * @author Doctor邓
 *
 */
public class StatementService {
	private StatementDaoImpl statementDao;
	
	public StatementService() {
		statementDao = new StatementDaoImpl();
	}
	
	/**
	 * 获取所有报表信息
	 * @return   返回报表Bean的集合
	 */
	public List<StatementFormBean> getAllStatement() {
		List<StatementFormBean> statementList = new ArrayList<>();
		
		List<Map<String,Object>> mapList = statementDao.findAllStatement();
		
		for (Map map : mapList) {
			
			int bussinessId 	= Integer.parseInt(map.get("bussinessId").toString());
			String loginAccount = map.get("loginAccount").toString();
			String customerName  = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String phone     	= map.get("phone").toString();
			String totalTime    = map.get("totalTime").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			StatementFormBean statement = new StatementFormBean(bussinessId, loginAccount, customerName, idNumber, phone, timeLong);
			statementList.add(statement);
		}
		
		return statementList;
	}
	
	 /* 获取所有通过时长降序的报表信息
	 * @return   返回报表Bean的集合
	 */
	public List<StatementFormBean> getAllStatementByDesc() {
		List<StatementFormBean> statementList = new ArrayList<>();
		
		List<Map<String,Object>> mapList = statementDao.findAllStatementByDesc();
		
		for (Map map : mapList) {
			
			int bussinessId 	= Integer.parseInt(map.get("bussinessId").toString());
			String loginAccount = map.get("loginAccount").toString();
			String customerName  = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String phone     	= map.get("phone").toString();
			String totalTime    = map.get("totalTime").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			StatementFormBean statement = new StatementFormBean(bussinessId, loginAccount, customerName, idNumber, phone, timeLong);
			statementList.add(statement);
		}
		
		return statementList;
	}
	
	/**
	 * 获取指定页的报表信息
	 * @return   返回报表Bean的集合
	 */
	public List<StatementFormBean> getStatementPage(int currentPage, int pageSize) {
		List<StatementFormBean> statementList = new ArrayList<>();
		
		List<Map<String,Object>> mapList = statementDao.findStatementPage((currentPage-1)*pageSize,pageSize);
		
		for (Map map : mapList) {
			
			int bussinessId 	= Integer.parseInt(map.get("bussinessId").toString());
			String loginAccount = map.get("loginAccount").toString();
			String customerName  = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String phone     	= map.get("phone").toString();
			String totalTime    = map.get("totalTime").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			StatementFormBean statement = new StatementFormBean(bussinessId, loginAccount, customerName, idNumber, phone, timeLong);
			statementList.add(statement);
		}
		
		return statementList;
	}
	
	 /* 获取所有通过时长降序的报表信息
	  * @return   返回报表Bean的集合
	  */
	public List<StatementFormBean> getStatementPageByDesc(int currentPage, int pageSize) {
		List<StatementFormBean> statementList = new ArrayList<>();

		List<Map<String, Object>> mapList = statementDao.findStatementPageByDesc((currentPage - 1) * pageSize,
				pageSize);

		for (Map map : mapList) {

			int bussinessId = Integer.parseInt(map.get("bussinessId").toString());
			String loginAccount = map.get("loginAccount").toString();
			String customerName = map.get("customerName").toString();
			String idNumber = map.get("idNumber").toString();
			String phone = map.get("phone").toString();
			String totalTime = map.get("totalTime").toString();

			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times / 3600;
			int m = (times % 3600) / 60;
			int s = (times % 3600) % 60;
			String timeLong = h + "时" + m + "分" + s + "秒";

			StatementFormBean statement = new StatementFormBean(bussinessId, loginAccount, customerName, idNumber,
					phone, timeLong);
			statementList.add(statement);
		}

		return statementList;
	}
	/**
	 * 获取报表数据总长度
	 * @return
	 */
	public int getStatementCount() {
		return statementDao.getStatementCount();
	}
	
	public static void main(String[] args) {
		StatementService statementManage = new StatementService();
		/*List<StatementFormBean> formList = statementManage.getAllStatementByDesc();
		for (StatementFormBean form : formList) {
			System.out.println("客户姓名："+form.getCustomerName() +" 时长： "+form.getTimeLong());
		}*/
		System.out.println(statementManage.getStatementCount());
		/*System.out.println(statementManage.getStatementPageByDesc(1, 3).size());*/
	}
	
}
