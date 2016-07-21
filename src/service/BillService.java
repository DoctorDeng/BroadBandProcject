package service;
import java.util.List;

import bean.Bill;
import bean.BillDetail;
import dao.impl.BillDaoImpl;

public class BillService {

	/**
	 * 获取账单表格显示所需要的信息，涉及到多表查询，暂时统一封装在Bill里面
	 */
	public List<Bill> getBill(){
		return new BillDaoImpl().findAll();
	}
	
	/**
	 * 获取详细表单
	 */
	
}
