package service.impl;
import java.util.List;

import bean.vo.ServiceAddViewBean;
import mapper.impl.BussinessViewBeanDaoImpl;
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
	public List<ServiceAddViewBean> selService(ServiceAddViewBean serviceAddViewBean) {
		return new BussinessViewBeanDaoImpl().findOne(serviceAddViewBean);
	}

	@Override
	public List<ServiceAddViewBean> toShowService(ServiceAddViewBean serviceAddViewBean) {
		// TODO Auto-generated method stub
		return new BussinessViewBeanDaoImpl().toShow(serviceAddViewBean);
	}

}
