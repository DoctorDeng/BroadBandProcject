package bean;

public class Bussiness {

	private int bussinessId;
	private int osId;
	private String createTime;
	private Os os;

	
	public Os getOs() {
		return os;
	}


	public void setOs(Os os) {
		this.os = os;
	}


	public Bussiness() {
		super();
	}


	public int getBussinessId() {
		return bussinessId;
	}
	


	public Bussiness(int bussinessId, int osId) {
		super();
		this.bussinessId = bussinessId;
		this.osId = osId;
	}


	public Bussiness(int osId) {
		super();
		this.osId = osId;
	}


	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}

	
	
}
