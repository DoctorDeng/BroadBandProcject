package service.impl;
import java.util.List;

import bean.viewBean.BussinessViewBean;
import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;
import service.ProfessionService;

public class ProfessionServiceImpl implements ProfessionService {
	@Override
	public boolean addService(ServiceAddViewBean serviceAddViewBean) {
		// TODO Auto-generated method stub
		int i =  new BussinessViewBeanDaoImpl().add(serviceAddViewBean);
		if( i == 0) return false;
		else return true;
	}

	@Override
	public List<BussinessViewBean> selService(ServiceAddViewBean serviceAddViewBean) {
		return new BussinessViewBeanDaoImpl().findOne(serviceAddViewBean);
	}

}
