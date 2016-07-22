package bean.viewBean;
/**
 * 宽带账号登陆详细信息的表单Bean
 * @author Doctor邓
 *
 */
public class OsLoginFormBean {
	/**
	 * 登陆IP
	 */
	private String loginIp;
	/**
	 * 登入时刻
	 */
	private String loginInTime;
	/**
	 * 登出时刻
	 */
	private String loginOutTime;
	/**
	 * 时长
	 */
	private int    timeLong;
	/**
	 * 费用
	 */
	private String cost;
	/**
	 * 资费名称
	 */
	private String tariffName;
	
	public OsLoginFormBean() {}
	
	public OsLoginFormBean(String loginIp, String loginInTime, String loginOutTime, int timeLong, String cost,
			String tariffName) {
		this.loginIp = loginIp;
		this.loginInTime = loginInTime;
		this.loginOutTime = loginOutTime;
		this.timeLong = timeLong;
		this.cost = cost;
		this.tariffName = tariffName;
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
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
}
