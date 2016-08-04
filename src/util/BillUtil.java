package util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bean.Bill;
import bean.dto.BillDetailDto;
import bean.dto.BillDto;
import bean.vo.BillDetailFormBean;
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
	/**
	 * 将月份账单信息的BillDto转换为BillFormBean
	 * @param billDtos
	 * @return
	 */
	public static List<BillFormBean> monthBillDtoToBillFormBean(List<BillDto> billDtos) {
		List<BillFormBean> billForms = new ArrayList<>();
		
		for (BillDto billDto: billDtos) {
			int totalTime = billDto.getTotalTime();
			String timeLong = TimeUtil.secondToString(totalTime);
			String payStatus = ("0".equals(billDto.getPayStatus())?"未支付":"已支付");
			BillFormBean billForm = new BillFormBean(billDto.getBillId(),billDto.getCustomerName(),billDto.getIdNumber(),billDto.getCustomerAccount(),timeLong,billDto.getPayWay(),payStatus,billDto.getCost(),billDto.getMonths(),billDto.getCustomerId());
			billForms.add(billForm);
		}
		return billForms;
	}
	
	public static List<BillDetailFormBean> billDetailDtoToFormBean(List<BillDetailDto>  billDetailDtos) {
		
		List<BillDetailFormBean> billDetailForms = new ArrayList<>();
		
		for (BillDetailDto temp:billDetailDtos) {
			String timeLong = TimeUtil.secondToString(temp.getTotalTime());
			double cost     = TariffUtil.countAccountTariff(temp.getTotalTime(), temp.getTariff(), temp.getTimeLong(), temp.getTimeTariff(), temp.getTariffType());
			//将double转换为两位小数
			DecimalFormat df = new DecimalFormat("#.00"); 
			BillDetailFormBean billDetailForm = new BillDetailFormBean(temp.getCustomerId(),temp.getOsAccount(),temp.getServerIp(),temp.getCustomerAccount(),
					timeLong,df.format(cost),temp.getTariffName(),temp.getOsId());
			billDetailForms.add(billDetailForm);
		}
		
		return billDetailForms;
	}
}
