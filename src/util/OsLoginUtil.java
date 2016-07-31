package util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bean.dto.OsLoginDto;
import bean.vo.OsLoginFormBean;

public class OsLoginUtil {
	public static List<OsLoginFormBean> osLoginDtoToFormBean(List<OsLoginDto> osLoginDtos) {
		
		List<OsLoginFormBean> osLoginForms = new ArrayList<>();
	
		for (OsLoginDto osLoginDto : osLoginDtos) {
			int times 	      = osLoginDto.getTimeLogin();
			double tariff     = osLoginDto.getTariff();
			int timeLogin     = osLoginDto.getTimelong();
			int timeTariff    = osLoginDto.getTimeTariff();
			String tariffType = osLoginDto.getTariffType();
			double cost       = TariffUtil.countLoginTariff(times, tariff, timeLogin, timeTariff, tariffType);
			//将double转换为两位小数
			DecimalFormat df = new DecimalFormat("#.00");  
			
			OsLoginFormBean osLoginForm = new OsLoginFormBean(osLoginDto.getLoginIp(),osLoginDto.getLoginInTime(),
					osLoginDto.getLoginOutTime(),times,df.format(cost),osLoginDto.getTariffName());
			
			osLoginForms.add(osLoginForm);
		}
		return osLoginForms;
	}
}
