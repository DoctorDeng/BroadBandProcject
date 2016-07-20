package bean.viewBean;

public class BillViewBean {
	/**
	 * 账单ID
	 */
	private int billId;
	/**
	 * 客户姓名
	 */
	private String customerName;
	/**
	 * 客户身份证号码
	 */
	private String idNumber;
	/**
	 * 处理此账单的管理员账号
	 */
	private String adminAccount;
	/**
	 * 客户一个月宽带总的费用
	 */
	private double cost;
	/**
	 * 账单时间  xx年xx月
	 */
	private String month;
	/**
	 * 账单支付方式
	 */
	private String payWay;
	/**
	 * 账单支付状态
	 */
	private String payStatus;
	
	public BillViewBean(int billId, String customerName, String idNumber, String adminAccount, double cost,
			String month, String payWay, String payStatus) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.adminAccount = adminAccount;
		this.cost = cost;
		this.month = month;
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
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
