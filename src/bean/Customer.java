package bean;

public class Customer {
    private int customerId;   //客户ID
    private String customerName;   //客户的名称
    private String idNumber;   //客户的身份证号码
    private String phone;     //客户的电话
	public Customer() {
	}
	
	public Customer(int customerId, String customerName, String idNumber, String phone) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.phone = phone;
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

	
}
