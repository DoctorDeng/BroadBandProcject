package service;

import java.util.List;

import bean.Tariff;
import mapper.TariffMapper;

public class TariffService {
	private TariffMapper tariffMapper;
	
	public TariffService() {
	}
	/**
	 * 获取资费管理所需要的表格信息（后期可能需要封装到pageBean里面，暂时封装到Tariff）
	 * @return
	 */
	public List<Tariff> getShowMessage(){
		return tariffMapper.findAllTariff();
	}
	
	/**
	 * 增加资费
	 * @param t
	 * @return
	 */
	public boolean addTariff(Tariff t){
		return tariffMapper.addTariff(t);
	}
	/**
	 * 开启资费
	 * @param tariffId  资费的ID
	 * @return          开启成功返回true，失败返回false
	 */
	public boolean updateStatus(int tariffId) {
		return tariffMapper.updateTariffStatus(tariffId);
	}
	/**
	 * 更新Tariff
	 * @param tariff
	 * @return
	 */
	public boolean updateTariff(Tariff tariff) {
		return tariffMapper.updateTariff(tariff);
	}
}
