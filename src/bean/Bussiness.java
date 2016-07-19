package bean;

public class Bussiness {
    private int bussinessId;   //业务ID
    private int adminId;    //管理员ID
    private String status;   //业务状态
    private int osId;     //宽带账号ID
	public Bussiness() {
		super();
	}
	
	public Bussiness(int bussinessId, int adminId, String status, int osId) {
		super();
		this.bussinessId = bussinessId;
		this.adminId = adminId;
		this.status = status;
		this.osId = osId;
	}

	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
}
