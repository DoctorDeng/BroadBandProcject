package bean;

public class Os {

    private int osId;    //宽带账号ID
    private int customerId;    //业务账号ID
    private int tariffId;    //资费ID
    private String osAccount;     //宽带账号
    private String osPassword;     //宽带账号密码
    private String serverIp;      //服务器IP地址
    private Customer customer;   //客户对象
    private Tariff  tarriff;     //资费对象
    
    
    
	public Os() {
		super();
	}
	
	public Os(int osId, int customerId, int tariffId, String osAccount, String osPassword, String serverIp) {
		this.osId = osId;
		this.customerId = customerId;
		this.tariffId = tariffId;
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
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Tariff getTarriff() {
		return tarriff;
	}

	public void setTarriff(Tariff tarriff) {
		this.tarriff = tarriff;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
}
