package bean.dto;
/**
 * 用于搜索账单传输搜索数据的对象
 * @author Doctor邓
 *
 */
public class BillSearchDto {
	//客户身份证号
	private String idNumber;
	//客户账务账号
	private String customerAccount;
	//客户姓名
	private String customerName;
	
	public BillSearchDto(String idNumber, String customerAccount, String customerName) {
		super();
		this.idNumber = idNumber;
		this.customerAccount = customerAccount;
		this.customerName = customerName;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
}
