package dao;

import java.util.List;

import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;

public interface BussinessViewDao {
	/**
	 * 业务界面显示数据
	 * @return
	 */
	public List<BussinessViewBean> findAll();
	/**
	 * 业务界面增加数据
	 */
	public boolean add(ServiceAddViewBean serviceAddViewBean);
}
