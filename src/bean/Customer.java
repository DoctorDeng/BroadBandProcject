package bean;

public class Customer {
    private int customerId;   //客户ID
    private String idNumber;   //客户的名称
    private String customerName;   //客户的身份证号码
    private String phone;     //客户的电话
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String idNumber, String customerName, String phone) {
		super();
		this.customerId = customerId;
		this.idNumber = idNumber;
		this.customerName = customerName;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
