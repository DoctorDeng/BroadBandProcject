package bean;

public class Bussiness {

	private int bussinessId;
	private int osId;

	
	public Bussiness() {
		super();
	}


	public int getBussinessId() {
		return bussinessId;
	}
	@Override
	public String toString() {
		return "Bussiness [bussinessId=" + bussinessId + ", osId=" + osId + "]";
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
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}

	
	
}
