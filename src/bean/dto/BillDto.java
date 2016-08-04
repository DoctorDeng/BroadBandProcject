package bean.dto;

public class BillDto {
	//账单ID
	private int    billId;
	//客户姓名
	private String customerName;
	//客户身份证号
	private String idNumber;
	//客户账务账号
	private String customerAccount;
	//客户所有Os账号登陆总的时间
	private int    totalTime;
	//账单支付方式
	private String payWay;
	//账单支付状态
	private String payStatus;
	//账单月份
	private String month;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public BillDto(){}

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

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
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
