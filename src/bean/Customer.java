package bean;

public class Customer {

	private int customerId;
	private String customerName;
	private String idNumber;
	private String phone;
	private String customerAccount;
	private String password;
	private String createTime;
	private String status;
	private String lastLoginTime;
	
	
	
	public Customer(String customerName, String idNumber, String phone, String customerAccount, String password,
			String createTime, String status, String lastLoginTime) {
		super();
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.phone = phone;
		this.customerAccount = customerAccount;
		this.password = password;
		this.createTime = createTime;
		this.status = status;
		this.lastLoginTime = lastLoginTime;
	}
	public Customer() {
		super();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	
	
}
