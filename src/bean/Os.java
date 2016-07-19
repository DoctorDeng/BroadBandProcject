package bean;

public class Os {
    private int osId;    //宽带账号ID
    private int customerId;    //客户ID
    private int tariffId;    //资费ID
    private String osAccount;     //宽带账号
    private String osPassword;     //宽带账号密码
    private String serverId;      //服务器ip地址
	public Os() {
		super();
	}
	
	public Os(int osId, int customerId, int tariffId, String osAccount, String osPassword, String serverId) {
		super();
		this.osId = osId;
		this.customerId = customerId;
		this.tariffId = tariffId;
		this.osAccount = osAccount;
		this.osPassword = osPassword;
		this.serverId = serverId;
	}

	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTariffId() {
		return tariffId;
	}
	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	public String getOsAccount() {
		return osAccount;
	}
	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}
	public String getOsPassword() {
		return osPassword;
	}
	public void setOsPassword(String osPassword) {
		this.osPassword = osPassword;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
}
