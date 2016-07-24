package service;

import bean.viewBean.ServiceAddViewBean;

public interface ProfessionService {
	/**
	 * 增加业务完成之后进行跳转
	 */
	public boolean addService();

	boolean addService(ServiceAddViewBean serviceAddViewBean);
}
