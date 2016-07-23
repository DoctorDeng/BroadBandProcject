package bean.viewBean;
/**
 * 报表Bean
 * @author DoctorDeng
 *
 */
public class StatementFormBean {
	/**
	 * 账号ID
	 */
	private int bussinessId;
	/**
	 * 账务账号
	 */
	private String loginAccount;
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
	
	public StatementFormBean(int bussinessId, String loginAccount, String customerName, String idNumber, String phone,
			String timeLong) {
		super();
		this.bussinessId = bussinessId;
		this.loginAccount = loginAccount;
		this.customerName = customerName;
		this.idNumber = idNumber;
		this.phone = phone;
		this.timeLong = timeLong;
	}
	
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
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
}
