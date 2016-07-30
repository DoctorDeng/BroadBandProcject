package bean;

public class Os {
    private int osId;    //宽带账号ID
    private String osAccount;     //宽带账号
    private String osPassword;     //宽带账号密码
    private String serverIp;      //服务器IP地址
    private Customer customer;   //客户对象
    private Tariff  tariff;     //资费对象
    private int   tariffId;     //资费对象
  
    /**
     * 空的构造方法
     */
	public Os() {
		super();
	}
	public Os(int   tariffId,int osId){
		this.osId = osId;
		this.tariffId = tariffId;
	}
	public Os(int osId,  String osAccount, String osPassword, String serverIp) {
		this.osId = osId;
		this.osAccount = osAccount;
		this.osPassword = osPassword;
		this.setServerIp(serverIp);
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

	@Override
	public String toString() {
		return "Os [osId=" + osId + ", osAccount=" + osAccount + ", osPassword=" + osPassword + ", serverIp=" + serverIp
				+ "]";
	}
	
}
