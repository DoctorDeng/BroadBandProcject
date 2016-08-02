package bean.dto;

public class OsShowDto {
	private String idNumber;   //客户的身份证号码
	private String traiffName;     //资费名称
	private String serverIp;      //服务器ip地址
	private int customerId;   //客户ID
	private String osAccount;     //宽带账号
	private int tariffId;    //资费ID
	private String status;	//状态
	private String customerName;   //客户的名称
	private String tariffExplain; //资费说明
	private String openTime;      //资费开启时间
	private int bussinessId;   		//账务账号ID
	private String tariffType;  //资费类型
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTraiffName() {
		return traiffName;
	}
	public void setTraiffName(String traiffName) {
		this.traiffName = traiffName;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
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
	public int getTariffId() {
		return tariffId;
	}
	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTariffExplain() {
		return tariffExplain;
	}
	public void setTariffExplain(String tariffExplain) {
		this.tariffExplain = tariffExplain;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getTariffType() {
		return tariffType;
	}
	public void setTariffType(String tariffType) {
		this.tariffType = tariffType;
	}

	
}
