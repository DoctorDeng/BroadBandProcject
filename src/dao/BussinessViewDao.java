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
	public int add(ServiceAddViewBean serviceAddViewBean);
	/**
	 * 业务界面用身份证查询账务账号
	 */
	public List<ServiceAddViewBean> find(ServiceAddViewBean serviceAddViewBean);
	/**
	 * 业务界面用业务账号修改业务信息
	 */
	public boolean update(BussinessViewBean bussinessViewBean);
	
	/**
	 * 业务界面的删除业务信息
	 */
	public boolean del(BussinessViewBean bussinessViewBean);
	/**
	 * 通过特定条件去查询业务信息 
	 */
	public List<BussinessViewBean> findOne(ServiceAddViewBean serviceAddViewBean); 
}

