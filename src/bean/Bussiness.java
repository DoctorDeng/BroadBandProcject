package bean;

public class Bussiness {
    private int bussinessId;   		//账务账号ID
    private String bussinessName;     //姓名
    private String idNumber;   	    //身份证号码
    private String loginAccount;  		//登陆账号
    private String createTime;			//账号创建日期
    private String status;				//状态
    private String lastLongTime;		//上次登录时间
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getBussinessName() {
		return bussinessName;
	}
	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
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
	public String getLastLongTime() {
		return lastLongTime;
	}
	public void setLastLongTime(String lastLongTime) {
		this.lastLongTime = lastLongTime;
	}
	
}
