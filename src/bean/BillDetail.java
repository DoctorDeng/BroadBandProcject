package bean;

public class BillDetail {
	/**
	 * 详单ID
	 */
	private int billDetailId;
	/**
	 * 详单对应Os
	 */
	private Os os;
	/**
	 * 资费
	 */
	private Tariff tariff;
	/**
	 * 月总时长
	 */
	private int timeLong;
	/**
	 * 花费
	 */
	private double cost;
	/**
	 * 月份
	 */
	private String months;
	
	public BillDetail(int billDetailId, Os os, Tariff tariff, int timeLong, double cost, String months) {
		super();
		this.billDetailId = billDetailId;
		this.os = os;
		this.tariff = tariff;
		this.timeLong = timeLong;
		this.cost = cost;
		this.months = months;
	}
	public int getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}
	public Os getOs() {
		return os;
	}
	public void setOs(Os os) {
		this.os = os;
	}
	public Tariff getTariff() {
		return tariff;
	}
	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	@Override
	public String toString() {
		return "BillDetail [billDetailId=" + billDetailId + ", os=" + os + ", tariff=" + tariff + ", timeLong="
				+ timeLong + ", cost=" + cost + ", months=" + months + "]";
	}
}
