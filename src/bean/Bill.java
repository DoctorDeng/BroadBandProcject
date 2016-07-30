package bean;

public class Bill {
	/**
	 * 账单ID
	 */
	private int billId;
	/**
	 * 客户ID
	 */
	private int customerId;
	/**
	 * 支付方式
	 */
	private String payWay;
	/**
	 * 支付状态
	 */
	private String payStatus;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
