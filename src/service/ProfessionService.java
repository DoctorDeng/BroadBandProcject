package service;

import java.util.List;

import bean.vo.ServiceAddViewBean;

public interface ProfessionService {

	/**
	 * 增加业务完成之后进行跳转
	 */

	public boolean addService(ServiceAddViewBean serviceAddViewBean);
	/**
	 * 根据特定条件查询结果
	 */
	public List<ServiceAddViewBean> selService(ServiceAddViewBean serviceAddViewBean);
	/**
	 * 将详细信息传递到servlet
	 */
	public List<ServiceAddViewBean> toShowService(ServiceAddViewBean serviceAddViewBean);
}
