package service;

import java.util.List;

import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;

public interface ProfessionService {

	/**
	 * 增加业务完成之后进行跳转
	 */

	public boolean addService(ServiceAddViewBean serviceAddViewBean);
	/**
	 * 根据特定条件查询结果
	 */
	public List<BussinessViewBean> selService(ServiceAddViewBean serviceAddViewBean);
}
