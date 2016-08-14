package bean.vo;

public class BillDetailFormBean {
	/**
	 * 客户ID
	 */
	private int customerId;
	/**
	 * OS 账号
	 */
	private String osAccount;
	/**
	 * 服务器IP
	 */
	private String serverIp;
	/**
	 * 客户账务账号
	 */
	private String customerAccount;
	/**
	 * 时长
	 */
	private String timeLong;
	/**
	 * 费用
	 */
	private String cost;
	/**
	 * 资费名称
	 */
	private String tariffName;
	/**
	 * os账号Id
	 */
	private int    osId;
	//月份
	private String months;
	
	
	public BillDetailFormBean(int customerId, String osAccount, String serverIp, String customerAccount,
			String timeLong, String cost, String tariffName, int osId) {
		super();
		this.customerId = customerId;
		this.osAccount = osAccount;
		this.serverIp = serverIp;
		this.customerAccount = customerAccount;
		this.timeLong = timeLong;
		this.cost = cost;
		this.tariffName = tariffName;
		this.osId = osId;
	}
	
	public BillDetailFormBean(int customerId, String osAccount, String serverIp, String customerAccount,
			String timeLong, String cost, String tariffName, int osId, String months) {
		super();
		this.customerId = customerId;
		this.osAccount = osAccount;
		this.serverIp = serverIp;
		this.customerAccount = customerAccount;
		this.timeLong = timeLong;
		this.cost = cost;
		this.tariffName = tariffName;
		this.osId = osId;
		this.months = months;
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
	public String getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(String timeLong) {
		this.timeLong = timeLong;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	@Override
	public String toString() {
		return "BillDetailFormBean [customerId=" + customerId + ", osAccount=" + osAccount + ", serverIp=" + serverIp
				+ ", customerAccount=" + customerAccount + ", timeLong=" + timeLong + ", cost=" + cost + ", tariffName="
				+ tariffName + ", osId=" + osId + ", months=" + months + "]";
	}
}
