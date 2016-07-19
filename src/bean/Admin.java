package bean;

public class Admin {
    
	private int adminId;   //管理员ID
    private String adminAccount;   //管理员登录账号
    private String password;      //账号密码
    public Admin() {
		super();
	}
    public Admin(int adminId, String adminAccount, String password) {
		super();
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.password = password;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
