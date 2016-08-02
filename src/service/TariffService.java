package service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Tariff;
import mapper.TariffMapper;
import util.SqlSessionUtil;

public class TariffService {
	private SqlSession sqlSession;
	private TariffMapper tariffMapper;
	
	public TariffService() {
	}
	/**
	 * 获取资费管理所需要的表格信息（后期可能需要封装到pageBean里面，暂时封装到Tariff）
	 * @return
	 */
	public List<Tariff> getShowMessage(){
		init();
		List<Tariff>tariff=tariffMapper.findAllTariff();
		close();
		return tariff;
	}
	
	/**
	 * 增加资费
	 * @param t
	 * @return
	 */
	public boolean addTariff(Tariff t){
		init();
		boolean s = tariffMapper.addTariff(t);
		close();
		return s;
	}
	/**
	 * 删除资费
	 * @param tariffId
	 * @return
	 */
	public boolean delTariff(int tariffId){
		init();
		boolean d = tariffMapper.delTariff(tariffId);
		close();
		return d;
	}
	/**
	 * 开启资费
	 * @param tariffId  资费的ID
	 * @return          开启成功返回true，失败返回false
	 */
	public boolean updateStatus(int tariffId) {
		init();
		boolean b = tariffMapper.updateTariffStatus(tariffId);
		close();
		return b;
	}
	/**
	 * 更新Tariff
	 * @param tariff
	 * @return
	 */
	public boolean updateTariff(Tariff tariff) {
		init();
		boolean c = tariffMapper.updateTariff(tariff);
		close();
		return c;
	}
	public void init(){
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			tariffMapper = sqlSession.getMapper(TariffMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//提交关闭SqlSession
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
}
