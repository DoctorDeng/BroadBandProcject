package bean;

public class BillDetail {
   private int billDetailId;   //账单详细ID
   private int billId;       //账单ID
   private int osId;      //宽带账号ID
   private double timeLong;     //宽带账号登录总时长
   private double cost;        //宽带账号总费用
	public int getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
	public double getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(double timeLong) {
		this.timeLong = timeLong;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
