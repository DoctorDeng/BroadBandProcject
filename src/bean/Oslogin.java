package bean;

public class Oslogin {
   private int osLoginId;    //宽带账号登录ID
   private int osId;      //宽带账号ID
   private String loginIp;      //客户登录IP
   private String loginInTime;     //客户登录时间
   private String loginOutTime;       //客户登出时间
   private int timeLong;      //客户登录时长
	public Oslogin() {
	super();
   }
	
	public Oslogin(int osLoginId, int osId, String loginIp, String loginInTime, String loginOutTime, int timeLong) {
		super();
		this.osLoginId = osLoginId;
		this.osId = osId;
		this.loginIp = loginIp;
		this.loginInTime = loginInTime;
		this.loginOutTime = loginOutTime;
		this.timeLong = timeLong;
	}

	public int getOsLoginId() {
		return osLoginId;
	}
	public void setOsLoginId(int osLoginId) {
		this.osLoginId = osLoginId;
	}
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getLoginInTime() {
		return loginInTime;
	}
	public void setLoginInTime(String loginInTime) {
		this.loginInTime = loginInTime;
	}
	public String getLoginOutTime() {
		return loginOutTime;
	}
	public void setLoginOutTime(String loginOutTime) {
		this.loginOutTime = loginOutTime;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
}
