package mobile;

public  class Ltab extends Mobile{

	Ltab(){}
	Ltab(String mobileName, int batterySize, String osType)
	{
		super(mobileName, batterySize, osType);
	}
	
	public void operate(int time)
	{
		super.setBatterySize(super.getBatterySize() - (time*10));
	}
	public void charge(int time)
	{
		super.setBatterySize(super.getBatterySize() + (time*10));
	}
	
}
