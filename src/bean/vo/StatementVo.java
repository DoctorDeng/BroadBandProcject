package bean.vo;
/**
 * 报表Bean
 * @author DoctorDeng
 *
 */
public class StatementVo {
	/**
	 * 客户Id(账务账号ID)
	 */
	private int customerId;
	/**
	 * 客户账务账号
	 */
	private String customerAccount;
	/**
	 * 客户姓名
	 */
	private String customerName;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 总时长
	 */
	private String timeLong;
	/**
	 * 月份
	 */
	private String months;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
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
	public String getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(String timeLong) {
		this.timeLong = timeLong;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	@Override
	public String toString() {
		return "StatementVo [customerId=" + customerId + ", customerAccount=" + customerAccount + ", customerName="
				+ customerName + ", idNumber=" + idNumber + ", phone=" + phone + ", timeLong=" + timeLong + ", months="
				+ months + "]";
	}
}
