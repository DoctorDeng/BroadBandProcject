package bean;

public class Bussiness {

	private int bussinessId;
	private int osId;
	private String status;
	
	public Bussiness() {
		super();
	}
	
	public Bussiness(int osId, String status) {
		super();
		this.osId = osId;
		this.status = status;
	}

	public Bussiness(int bussinessId, int osId, String status) {
		super();
		this.bussinessId = bussinessId;
		this.osId = osId;
		this.status = status;
	}

	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
