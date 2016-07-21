package bean;

import java.util.List;

public class Admin {
    
	private int adminId;   //管理员ID
    private String adminAccount;   //管理员登录账号
    private String password;      //账号密码
    private List<Power> powerList; //管理员权限集合
    
    public Admin() {
	}
    
    public Admin(int adminId, String adminAccount, String password) {
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.password = password;
	}
    
    public Admin(int adminId, String adminAccount, String password,List<Power> powerList) {
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.password = password;
		this.powerList = powerList;
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

	public List<Power> getPowerList() {
		return powerList;
	}

	public void setPowerList(List<Power> powerList) {
		this.powerList = powerList;
	}
}
