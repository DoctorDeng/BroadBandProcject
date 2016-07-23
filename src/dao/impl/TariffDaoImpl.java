package dao.impl;

import java.util.List;

import bean.Tariff;
import dao.TariffDao;
import util.DBHelper;

public class TariffDaoImpl implements TariffDao {

	@Override
	public List<Tariff> findAll() {
		String sql = "SELECT * FROM tariff";
		List<Tariff> tariffList = DBHelper.find(new Tariff(), sql,null);
		return tariffList;
	}

	@Override
	public Tariff findOne(int tariffId) {
		String sql = "SELECT * FROM tariff";
		Tariff tariff = DBHelper.findOne(new Tariff(), sql,null);
		return tariff;
	}
	/**
	 * 添加资费
	 */
	@Override
	public boolean add(Tariff tariff) {
		String sql = "INSERT INTO tariff "
				+ "(tariffName,tariff,timeLong,timeTariff,createTime,status,tariffType,tariffExplain)"
				+ "VALUES(?,?,?,?,now(),'0',?,?)";
		String[] fields = {tariff.getTariffName(),
				String.valueOf(tariff.getTariff()),String.valueOf(tariff.getTimeLong()),
				String.valueOf(tariff.getTimeTariff()),
				tariff.getTariffType(),tariff.getTariffExplain()};
		int result = DBHelper.update(sql, fields);
		
		if (result==0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean del(int tariffId) {
		String sql = "DELETE FROM tariff WHERE tariffId =" + tariffId;
		
		int result =DBHelper.update(sql, null);
		
		if (result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Tariff tariff) {
		String sql = "UPDATE tariff SET "
				+ "tariffName= ?,"
				+ "timeLong=?,"
				+ "tariff=?,"
				+ "timeTariff=?,"
				+ "tariffType=?,"
				+ "tariffExplain=? "
				+ "WHERE tariffId = ?";
		
		String[] fields = {tariff.getTariffName(),
				String.valueOf(tariff.getTimeLong()),
				String.valueOf(tariff.getTariff()),
				String.valueOf(tariff.getTimeTariff()),
				tariff.getTariffType(),
				tariff.getTariffExplain(), 
				String.valueOf(tariff.getTariffId())};
		
		int result = DBHelper.update(sql, fields);
		if (result >0) {
			return true;
		}
		return false;
	}
	/**
	 * 将指定tariff(资费)启用
	 * @param tariffId   资费ID
	 * @return           启用成功返回true，失败返回false
	 */
	public boolean startUsingTariff(int tariffId) {
		String sql = "UPDATE tariff SET openTime=now(),status='1' WHERE tariffId=?";
		String[] fields = {String.valueOf(tariffId)};
		int result = DBHelper.update(sql, fields);
		if (result==0) {
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		TariffDaoImpl tariffDao = new TariffDaoImpl();
//		Tariff tariff = new Tariff(3, "包月", 30, 5, 30.00,"2", "3", "没有");
		/*Tariff tariff = new Tariff("doctor",20,20,3,"1","1","哈哈哈");
		System.out.println(tariffDao.add(tariff));*/
//		System.out.println(tariffDao.findAll().size());
		System.out.println(tariffDao.startUsingTariff(3));
	}
}
