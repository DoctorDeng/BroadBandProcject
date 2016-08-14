package bean.vo;

public class ServiceAddViewBean {
	private String idNumber;   //客户的身份证号码
	private int adminId;   //管理员ID
	private String traiffName;     //资费名称
	private String serverId;      //服务器ip地址
	private int osLoginId;    //宽带账号登录ID
	private String osPassword;     //宽带账号密码
	private int customerId;   //客户ID
	private String osAccount;     //宽带账号
	private int tariffId;    //资费ID
	private String status;	//状态
	private String customerName;   //客户的名称
	private String tariffExplain; //资费说明
	private String openTime;      //资费开启时间
	private int bussinessId;   		//账务账号ID
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
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getTraiffName() {
		return traiffName;
	}
	public void setTraiffName(String traiffName) {
		this.traiffName = traiffName;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public int getOsLoginId() {
		return osLoginId;
	}
	public void setOsLoginId(int osLoginId) {
		this.osLoginId = osLoginId;
	}
	public String getOsPassword() {
		return osPassword;
	}
	public void setOsPassword(String osPassword) {
		this.osPassword = osPassword;
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
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	
}
