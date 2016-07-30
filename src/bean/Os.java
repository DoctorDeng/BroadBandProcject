package bean;

public class Os {
    private int osId;    //宽带账号ID
    private String osAccount;     //宽带账号
    private String osPassword;     //宽带账号密码
    private String serverIp;      //服务器IP地址
    private Customer customer;   //客户对象
    private Tariff  tariff;     //资费对象
    private int   tariffId;     //资费对象
    private String status;
    
	/**
     * 空的构造方法
     */
	public Os() {
		super();
	}
	
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
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
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public int getTariffId() {
		return tariffId;
	}

	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Os [osId=" + osId + ", osAccount=" + osAccount + ", osPassword=" + osPassword + ", serverIp=" + serverIp
				+ "]";
	}
	
}
