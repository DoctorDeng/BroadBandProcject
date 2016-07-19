package bean;

public class Bill {
   private int billId;    //账单ID
   private int customerId;   //客户ID
   private int adminId;    //管理员ID
   private double cost;    //客户一个月宽带总费用
   private String  month;    //账单年月
   private String payWay;    //支付方式
   private String payStatus;     //支付状态
   public Bill() {
	super();
    }
   public Bill(int billId, int customerId, int adminId, double cost, String month, String payWay, String payStatus) {
		super();
		this.billId = billId;
		this.customerId = customerId;
		this.adminId = adminId;
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
