package bean;

public class Tariff {
    private int tariffId;     //资费ID
	private String traiffName;     //资费名称
	private int timeLong;       //资费时长
	private double tariff;      //资费金额
	private String creaTime;      //资费创建时间
	private String openTime;      //资费开启时间
	private String status;     //资费状态（开通或暂停）
   public int getTariffId() {
		return tariffId;
	}
	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	public String getTraiffName() {
		return traiffName;
	}
	public void setTraiffName(String traiffName) {
		this.traiffName = traiffName;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public String getCreaTime() {
		return creaTime;
	}
	public void setCreaTime(String creaTime) {
		this.creaTime = creaTime;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
