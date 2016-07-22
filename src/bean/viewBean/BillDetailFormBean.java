package bean.viewBean;

public class BillDetailFormBean {
	/**
	 * 用户详单ID
	 */
	private int billDetailId;
	/**
	 * OS 账号
	 */
	private String osAccount;
	/**
	 * 服务器IP
	 */
	private String serverIp;
	/**
	 * 账务账号
	 */
	private String loginAccount;
	/**
	 * 时长
	 */
	private String timeLong;
	/**
	 * 费用
	 */
	private double cost;
	/**
	 * 资费名称
	 */
	private String tariffName;
	/**
	 * os账号Id
	 */
	private int    osId;
	

	public BillDetailFormBean(int billDetailId, String osAccount, String serverIp, String loginAccount, String timeLong,
			double cost, String tariffName, int osId) {
		super();
		this.billDetailId = billDetailId;
		this.osAccount = osAccount;
		this.serverIp = serverIp;
		this.loginAccount = loginAccount;
		this.timeLong = timeLong;
		this.cost = cost;
		this.tariffName = tariffName;
		this.osId = osId;
	}

	public int getOsId() {
		return osId;
	}

	public void setOsId(int osId) {
		this.osId = osId;
	}

	public BillDetailFormBean(){
		
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

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public String getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(String timeLong) {
		this.timeLong = timeLong;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
