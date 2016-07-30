package bean;

import java.util.List;

public class Admin {
	/**
	 * 管理员ID
	 */
	private int adminId;
	/**
	 * 管理员账号
	 */
	private String adminAccount;
	/**
	 * 管理员密码
	 */
	private String password;
	/**
	 * 管理员姓名
	 */
	private String adminName;
	/**
	 * 管理员身份证号
	 */
	private String idNumber;
	/**
	 * 管理员电话
	 */
	private String phone;
	/**
	 * 管理员邮箱
	 */
	private String email;
	/**
	 * 管理员创建时间
	 */
	private String createTime;
	/**
	 * 管理员权限
	 */
	private List<Power> powers;
	
	public Admin(){}

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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}
}
