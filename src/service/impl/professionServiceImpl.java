package service.impl;
import bean.viewBean.ServiceAddViewBean;
import dao.impl.BussinessViewBeanDaoImpl;
import service.professionService;

public class professionServiceImpl implements professionService {
	@Override
	public boolean addService(ServiceAddViewBean serviceAddViewBean) {
		// TODO Auto-generated method stub
		int i =  new BussinessViewBeanDaoImpl().add(serviceAddViewBean);
		if( i == 0) return true;
		else return false;
	}

	@Override
	public boolean addService() {
		// TODO Auto-generated method stub
		return false;
	}

}
