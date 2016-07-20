package dao.impl;

import java.util.List;

import bean.Tariff;
import dao.TariffDao;

public class TariffDaoImpl implements TariffDao {

	@Override
	public List<Tariff> findAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Tariff findOne(int tariffId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean add(Tariff tariff) {
		String sql = "INSERT INTO tariff (tariffName,tariff,timeLong,timeLong,status)";
		return false;
	}

	@Override
	public boolean del(int tariffId) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(Tariff tariff) {
		// TODO 自动生成的方法存根
		return false;
	}
	
	

}
