package bean.viewBean;

public class BillDetailViewBean {
	private  int billDetailId;
	private  String osAccount;
	private  String serverIp;
	private  int    adminId;
	private  int    timeLong;
	private  double cost;
	private  String tariffName;
	
	public BillDetailViewBean(int billDetailId, String osAccount, String serverIp, int adminId, int timeLong,
			double cost, String tariffName) {
		super();
		this.billDetailId = billDetailId;
		this.osAccount = osAccount;
		this.serverIp = serverIp;
		this.adminId = adminId;
		this.timeLong = timeLong;
		this.cost = cost;
		this.tariffName = tariffName;
	}
	
	public int getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
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
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	
}
