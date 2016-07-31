package util;

public class TariffUtil {
	/**
	 * 计算每个账号的总资费
	 * @param times        登陆总时长
	 * @param tariff       月资费
	 * @param timeLong     套餐时长
	 * @param timeTariff   单位小时资费
	 * @param tariffType   资费类型
	 * @return  double     总资费
	 */
	public static double countAccountTariff(int times,double tariff, int timeLong, int timeTariff, String tariffType ) {
		//包月时长的秒 数表示
		int monthTimes = timeLong*3600;
		//总资费默认为0
		double countTariff = 0.00;
		
		switch(tariffType) {
		case "1":
			countTariff = tariff;
			break;
		case "2":
			if (times < timeLong*3600) {
				countTariff = tariff;
			} else {
				countTariff = (((times - timeLong*3600)*1.0)/(3600*1.0)) * timeTariff + tariff;
			}
			break;
		case "3":
			countTariff = ((1.0*times)/(1.0*3600))*timeTariff;
			break;
		}
		return countTariff;
	}
	
	public static double countLoginTariff(int times,double tariff, int timeLong, int timeTariff, String tariffType){
		//包月时长的秒 数表示
		int monthTimes = timeLong*3600;
		//总资费默认为0
		double countTariff = 0.00;
		//一个月的时间
		int monthTime = 24*3600*30;
		
		switch(tariffType) {
		case "1":
			if(times < monthTime) {
				countTariff = ((1.0*times)/(monthTime*1.0)) * tariff;
			} else {
				countTariff = tariff + (((times-monthTime)*1.0)/(monthTime*1.0))*tariff;
			}
			break;
		case "2":
			if (times < timeLong*3600) {
				countTariff = tariff;
			} else {
				countTariff = (((times - timeLong*3600)*1.0)/(3600*1.0)) * timeTariff + tariff;
			}
			break;
		case "3":
			countTariff = ((1.0*times)/(1.0*3600))*timeTariff;
			break;
		}
		return countTariff;
	}
}
