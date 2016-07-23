package bean.viewBean;

public class BussinessViewBean {
	private int bussinessId;     //业务ID
	private int adminId;   //管理员ID
	private String idNumber;   //客户的身份证号码
	private String customerName;   //客户的名称
	private String osAccount;     //宽带账号
	private String traiffName;     //资费名称
	private String serverId;      //服务器ip地址
	private String status;     //资费状态（开通或暂停）
	private int tariffId; //资费ID
	
	
	
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public int getTariffId() {
		return tariffId;
	}
	public void setTariffId( int tariffId) {
		this.tariffId = tariffId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOsAccount() {
		return osAccount;
	}
	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
