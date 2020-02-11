package mobile;

abstract class Mobile {
	private String mobileName;
	private int batterySize;
	private String osType;
	
	Mobile(){}
	Mobile(String mobileName, int batterySize, String osType)
	{
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	abstract void operate(int time); //{} 중괄호가 있으면 바디로 본다.
	abstract void charge(int time);
	
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public int getBatterySize() {
		return batterySize;
	}
	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
}
