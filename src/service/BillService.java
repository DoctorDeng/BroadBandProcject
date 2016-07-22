package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Bill;
import bean.viewBean.BillDetailFormBean;
import bean.viewBean.OsLoginFormBean;
import dao.impl.BillDaoImpl;
import dao.impl.OsLoginDaoImpl;

public class BillService {
	private OsLoginDaoImpl  osLoginDao;
	private BillDaoImpl   billDao;
	
	public BillService() {
		osLoginDao = new OsLoginDaoImpl();
		billDao = new BillDaoImpl();
	}
	/**
	 * 获取账单表格显示所需要的信息，涉及到多表查询，暂时统一封装在Bill里面
	 */
	public List<Bill> getBill(){
		return new BillDaoImpl().findAll();
	}
	
	/**
	 * 获取账号登陆表单信息
	 * @param osId   账号Id
	 * @return
	 */
	public List<OsLoginFormBean>   getOsLoginForm(int osId) {
		List<Map<String,Object>> list = osLoginDao.findLoginFormById(osId);
		List<OsLoginFormBean> loginList = new ArrayList<>();
		
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = list.get(i);
			OsLoginFormBean osLogin = new OsLoginFormBean();
			
			double cost       = 0;
			double tariff     = Double.parseDouble(map.get("tariff").toString());
			int timeTariff    = Integer.parseInt(map.get("timeTariff").toString());
			int timeLong      = Integer.parseInt(map.get("timeLong").toString());
			String tariffType = map.get("tariffType").toString();
			int time   = Integer.parseInt(map.get("timeLogin").toString());
			/*
			 * 资费类型为套餐时
			 */
		    if ("2".equals(tariffType)) {
		    	//当总时长大于套餐时长
				if (time/3600 > timeLong) {
					cost = tariff + (time/3600 - timeLong)*timeTariff;
				}
			}
		    /**
		     * 资费类型为按时 时
		     */
		    else if ("3".equals(tariffType)){
				cost = (time/3600)*timeTariff;
			}
			
		    String loginIp      = map.get("loginIp").toString();
		    String loginInTime  = map.get("loginInTime").toString();
		    String loginOutTime = map.get("loginOutTime").toString();
		    String tariffName   = map.get("tariffName").toString();
		    
		    osLogin.setLoginIp(loginIp);
		    osLogin.setLoginInTime(loginInTime);
		    osLogin.setLoginOutTime(loginOutTime);
		    osLogin.setTimeLong(time);
		    osLogin.setCost(String.valueOf(cost));
		    osLogin.setTariffName(tariffName);
		    loginList.add(osLogin);
		}
		return loginList;
	}
	/**
	 * 获取用户详单信息
	 * @param billId  账单Id
	 * @return  返回详单表单Bean的集合
	 */
	public List<BillDetailFormBean> getBillDetailForm(int billId) {
		List<BillDetailFormBean> list = new ArrayList<>();
		List<Map<String, Object>> listMap = billDao.findBillDetailForm(billId);
		
		for (int i=0; i<listMap.size(); i++) {
			Map<String,Object> map = listMap.get(i);
			
			int billDetailId 	= Integer.parseInt(map.get("billDetailId").toString());
			int osId         	= Integer.parseInt(map.get("osId").toString());
			String osAccount    = map.get("osAccount").toString();
			String serverIp     = map.get("serverIp").toString();
			String loginAccount = map.get("loginAccount").toString();
			String tariffName   = map.get("tariffName").toString();
			
			BillDetailFormBean billDetailForm = new BillDetailFormBean(billDetailId,osAccount,serverIp,loginAccount,tariffName,osId);
			list.add(billDetailForm);
		}
		return list;
	}
	public static void main(String[] args) {
		BillService bill = new BillService();
		System.out.println(bill.getBillDetailForm(1).size());
		/*System.out.println(bill.getOsLoginForm(1).size());*/
	}
	/**
	 * 代码备份
	 */
/*	List<Map<String,Object>> list = osLoginDao.findLoginFormById(osId);
	List<OsLoginFormBean> loginList = new ArrayList<>();
	*//**
	 * 总的费用
	 *//*
	double cost = 0;
	*//**
	 * 总时长
	 *//*
	int    times = 0;
	*//**
	 * 资费类型
	 *//*
	String tariffType = "";
	double tariff = 0;
	int    timeTariff = 0;
	int    timeLong = 0;
	
	for (int i=0; i<list.size(); i++) {
		Map<String,Object> map = list.get(i);
		
		
		if (i==0) {
			tariff     = Double.parseDouble(map.get("tariff").toString());
			timeTariff = Integer.parseInt(map.get("timeTariff").toString());
			timeLong   = Integer.parseInt(map.get("timeLong").toString());
		}
		tariffType = map.get("tariffType").toString();
		times     += Integer.parseInt(map.get("timeLogin").toString());
	}
	if ("1".equals(tariffType)) {
		cost = tariff;
	} else if ("2".equals(tariffType)) {
		*//**
		 * 当总时长小于套餐时长
		 *//*
		if (times/3600 < timeLong) {
			cost = tariff;
		}
		//当总时长大于套餐时长
		else {
			cost = tariff + (times/3600 - timeLong)*timeTariff;
		}
	} else if ("3".equals(tariffType)){
		cost = (times/3600)*timeTariff;
	}*/
	
}
