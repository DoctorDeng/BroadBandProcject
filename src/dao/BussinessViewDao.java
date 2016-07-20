package dao;

import java.util.List;

import bean.viewBean.BussinessViewBean;

public interface BussinessViewDao {
	/**
	 * 业务界面显示数据
	 * @return
	 */
	public List<BussinessViewBean> findAll();
}
