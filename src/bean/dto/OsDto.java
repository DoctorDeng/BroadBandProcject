package bean.dto;

public class OsDto {
	private int bussinessId;
	private int customerId;
	private String idNumber;
	private String customerName;
	private String osAccount;     //宽带账号
	private String status;
	private String serverIp;      //服务器IP地址
	private String tariffName;     //资费名称
	private int    tariffId;
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	public int getTariffId() {
		return tariffId;
	}
	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	
	
	public OsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "OsDto [bussinessId=" + bussinessId + ", customerId=" + customerId + ", idNumber=" + idNumber
				+ ", customerName=" + customerName + ", osAccount=" + osAccount + ", status=" + status + ", serverIp="
				+ serverIp + ", tariffName=" + tariffName + "]";
	}
	
	
}
