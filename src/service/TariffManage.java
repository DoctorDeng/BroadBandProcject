package service;

import java.util.List;

import bean.Tariff;
import dao.impl.TariffDaoImpl;

public class TariffManage {
	private TariffDaoImpl tariffDao;
	
	public TariffManage() {
		tariffDao = new TariffDaoImpl();
	}
	/**
	 * 获取资费管理所需要的表格信息（后期可能需要封装到pageBean里面，暂时封装到Tariff）
	 * @return
	 */
	public List<Tariff> getShowMessage(){
		return tariffDao.findAll();
	}
	
	/**
	 * 增加资费
	 * @param t
	 * @return
	 */
	public boolean addTariff(Tariff t){
		return tariffDao.add(t);
	}
	/**
	 * 开启资费
	 * @param tariffId  资费的ID
	 * @return          开启成功返回true，失败返回false
	 */
	public boolean openTariff(int tariffId) {
		return tariffDao.startUsingTariff(tariffId);
	}
}
