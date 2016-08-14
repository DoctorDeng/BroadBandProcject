package bean.dto;

public class OsLoginDto {
	//登陆IP
	private String loginIp;
	//登入时刻
	private String loginInTime;
	//登出时刻
	private String loginOutTime;
	//资费名称
	private String tariffName;
	//月资费
	private double tariff;
	//资费时长
	private int    timelong;
	//单位时间资费
	private int    timeTariff;
	//资费类型
	private String tariffType;
	//登陆时长
	private int    timeLogin;
	
	public OsLoginDto(){}
	
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
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public int getTimelong() {
		return timelong;
	}
	public void setTimelong(int timelong) {
		this.timelong = timelong;
	}
	public int getTimeTariff() {
		return timeTariff;
	}
	public void setTimeTariff(int timeTariff) {
		this.timeTariff = timeTariff;
	}
	public String getTariffType() {
		return tariffType;
	}
	public void setTariffType(String tariffType) {
		this.tariffType = tariffType;
	}
	public int getTimeLogin() {
		return timeLogin;
	}
	public void setTimeLogin(int timeLogin) {
		this.timeLogin = timeLogin;
	}
}
