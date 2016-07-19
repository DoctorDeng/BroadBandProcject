package bean;

public class Power {
   private int powerId;   //权限ID
   private String powerName;    //权限名称
   private int power;       //权限
	public Power() {
	super();
   }
	
	public Power(int powerId, String powerName, int power) {
		super();
		this.powerId = powerId;
		this.powerName = powerName;
		this.power = power;
	}

	public int getPowerId() {
		return powerId;
	}
	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}
	public String getPowerName() {
		return powerName;
	}
	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
