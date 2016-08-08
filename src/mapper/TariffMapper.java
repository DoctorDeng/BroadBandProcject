package mapper;

import java.util.List;

import bean.Tariff;



public interface TariffMapper {
    public List<Tariff> findAllTariff();
	
	public Tariff findOneTariff(int tariffId);
	
	public boolean addTariff(Tariff tariff);
	
	public boolean delTariff(int tariffId);
	
	public boolean updateTariff(Tariff tariff);
	
	public boolean updateTariffStatus(int tariffId);
	
	public Tariff findIdByName(String tariffName);

}
