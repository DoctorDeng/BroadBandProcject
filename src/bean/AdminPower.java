package bean;

public class AdminPower {
    private int adminPowerId;   //管理员权限ID
    private int adminId;    //管理员ID
    private int powerId;     //权限ID
	
	public AdminPower() {
		super();
	}
	public AdminPower(int adminPowerId, int adminId, int powerId) {
		super();
		this.adminPowerId = adminPowerId;
		this.adminId = adminId;
		this.powerId = powerId;
	}
	public int getAdminPowerId() {
		return adminPowerId;
	}
	public void setAdminPowerId(int adminPowerId) {
		this.adminPowerId = adminPowerId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getPowerId() {
		return powerId;
	}
	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}
}
