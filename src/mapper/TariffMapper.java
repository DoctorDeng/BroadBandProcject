package mapper;

import java.util.List;

import bean.Tariff;



public interface TariffMapper {
    public List<Tariff> findAll();
	
	public Tariff findOne(int tariffId);
	
	public boolean add(Tariff tariff);
	
	public boolean del(int tariffId);
	
	public boolean update(Tariff tariff);

}
