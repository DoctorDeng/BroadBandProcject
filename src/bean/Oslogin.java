package bean;

public class Oslogin {
   private int osLoginId;
   private int osId;
   private String loginIp;
   private String loginInTime;
   private String loginOutTime;
   private int timeLong;
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
