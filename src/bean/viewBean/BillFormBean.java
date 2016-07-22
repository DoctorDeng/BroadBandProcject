package bean.viewBean;

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
	private String loginAccount;
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
	
	public BillFormBean(int billId, String customerName, String idNumber, String loginAccount, String timeLong,
			 String payWay, String payStatus) {
		this.billId = billId;
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.loginAccount = loginAccount;
		this.timeLong = timeLong;
		this.payWay = payWay;
		this.payStatus = payStatus;
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
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
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
	
}
