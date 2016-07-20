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
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean add(Tariff tariff) {
		String sql = "INSERT INTO tariff "
				+ "(tariffName,tariff,timeLong,timeTariff,createTime,status,tariffType,tariffExplain)"
				+ "VALUES(?,?,?,?,now(),?,?,?)";
		String[] fields = {tariff.getTraiffName(),
				String.valueOf(tariff.getTariff()),String.valueOf(tariff.getTimeLong()),
				String.valueOf(tariff.getTimeTariff()),
				tariff.getStatus(),tariff.getTariffType(),tariff.getTariffExplain()};
		int result = DBHelper.update(sql, fields);
		
		if (result==0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean del(int tariffId) {
		// TODO 自动生成的方法存根
		return false;
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
		String[] fields = {tariff.getTraiffName(),
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
	
	public static void main(String[] args) {
		TariffDaoImpl tariffDao = new TariffDaoImpl();
		Tariff tariff = new Tariff(3, "包月", 30, 5, 30.00,"2", "3", "没有");
		/*Tariff tariff = new Tariff("doctor",20,20,3,"1","1","哈哈哈");
		System.out.println(tariffDao.add(tariff));*/
//		System.out.println(tariffDao.findAll().size());
		System.out.println(tariffDao.update(tariff));
	}
}
