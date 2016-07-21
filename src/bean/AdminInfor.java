package bean;

public class AdminInfor {
   
	private int    inforId;   //管理员信息ID
    private int    adminId;   //管理员ID
    private String adminName;
    private String idNumber;    //管理员身份证号
    private String phone;     //电话
    private String email;      //邮箱
    private String createTime;    //创建时间
    private String status;   //管理员状态
    
	public AdminInfor() {
	}
	public AdminInfor(int inforId, int adminId, String idNumber, String phone, String email, String createTime) {
			this.inforId = inforId;
			this.adminId = adminId;
			this.idNumber = idNumber;
			this.phone = phone;
			this.email = email;
			this.createTime = createTime;
	}
	public int getInforId() {
		return inforId;
	}
	public void setInforId(int inforId) {
		this.inforId = inforId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
