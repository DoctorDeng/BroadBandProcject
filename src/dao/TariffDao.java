package dao;

import java.util.List;

import bean.Tariff;

public interface TariffDao {
	
	public List<Tariff> findAll();
	
	public Tariff findOne(int tariffId);
	
	public boolean add(Tariff tariff);
	
	public boolean del(int tariffId);
	
	public boolean update(Tariff tariff);
}
