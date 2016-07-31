package util;

import java.util.ArrayList;
import java.util.List;

import bean.Bill;
import bean.dto.BillDto;
import bean.vo.BillFormBean;

public class BillUtil {
	/**
	 * 将BillDto转换为BillFormBean
	 * @param billDtos
	 * @return
	 */
	public static List<BillFormBean> billDtoToBillFormBean(List<BillDto> billDtos){
		List<BillFormBean> billForms = new ArrayList<>();
		
		for (BillDto billDto: billDtos) {
			int totalTime = billDto.getTotalTime();
			String timeLong = TimeUtil.secondToString(totalTime);
			String payStatus = ("0".equals(billDto.getPayStatus())?"未支付":"已支付");
			BillFormBean billForm = new BillFormBean(billDto.getBillId(),billDto.getCustomerName(),billDto.getIdNumber(),billDto.getCustomerAccount(),timeLong,billDto.getPayWay(),payStatus);
			billForms.add(billForm);
		}
		return billForms;
	}
}
