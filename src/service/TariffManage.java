package service;

import java.util.List;

import bean.Tariff;
import dao.impl.TariffDaoImpl;

public class TariffManage {

	/**
	 * 获取资费管理所需要的表格信息（后期可能需要封装到pageBean里面，暂时封装到Tariff）
	 * @return
	 */
	public List<Tariff> getShowMessage(){
		return new TariffDaoImpl().findAll();
	}
	
	/**
	 * 增加资费
	 * @param t
	 * @return
	 */
	public boolean addTariff(Tariff t){
		return new TariffDaoImpl().add(t);
	}
	
}
