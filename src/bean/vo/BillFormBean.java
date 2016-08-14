package bean.vo;

public class BillFormBean {
	/**
	 * 用户账单ID
	 */
	private int billId;
	/**
	 * 用户姓名
	 */
	private String customerName;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 账务账号
	 */
	private String customerAccount;
	/**
	 * 总时长
	 */
	private String timeLong;
	/**
	 * 支付方式
	 */
	private String payWay;
	/**
	 * 支付状态 0 未支付， 1已支付
	 */
	private String payStatus;
	//月份
	private String months;
	//花费
	private String cost;
	//客户ID
	private int    customerId;
	
	public BillFormBean(int billId, String customerName, String idNumber, String customerAccount, String timeLong,
			String payWay, String payStatus) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.customerAccount = customerAccount;
		this.timeLong = timeLong;
		this.payWay = payWay;
		this.payStatus = payStatus;
	}
	
	public BillFormBean(int billId, String customerName, String idNumber, String customerAccount, String timeLong,
			String payWay, String payStatus, String cost,String months, int customerId) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.customerAccount = customerAccount;
		this.timeLong = timeLong;
		this.payWay = payWay;
		this.payStatus = payStatus;
		this.cost = cost;
		this.months = months;
		this.customerId = customerId;
	}

	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "BillFormBean [billId=" + billId + ", customerName=" + customerName + ", idNumber=" + idNumber
				+ ", customerAccount=" + customerAccount + ", timeLong=" + timeLong + ", payWay=" + payWay
				+ ", payStatus=" + payStatus + ", months=" + months + ", cost=" + cost + ", customerId=" + customerId
				+ "]";
	}
	
	
}
