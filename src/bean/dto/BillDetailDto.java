package bean.dto;

public class BillDetailDto {
	//客户ID
	private int customerId;
	//客户OS账号
	private String osAccount;
	//OS账号对应服务器IP
	private String serverIp;
	//客户账务账号
	private String customerAccount;
	//资费名称
	private String tariffName;
	//月资费
	private double tariff;
	//单位时间资费
	private int    timeTariff;
	//资费时长
	private int    timeLong;
	//资费类型
	private String tariffType;
	//账号登陆总时间
	private int    totalTime;
	
	public BillDetailDto(){}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getOsAccount() {
		return osAccount;
	}
	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public int getTimeTariff() {
		return timeTariff;
	}
	public void setTimeTariff(int timeTariff) {
		this.timeTariff = timeTariff;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
	public String getTariffType() {
		return tariffType;
	}
	public void setTariffType(String tariffType) {
		this.tariffType = tariffType;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
}
