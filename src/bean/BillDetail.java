package bean;

public class BillDetail {
   private int billDetailId;
   private int billId;
   private int osId;
   private double timeLong;
   private double cost;
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
