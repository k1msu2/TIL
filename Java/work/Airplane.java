package work;

public class Airplane extends Plane{
	
	Airplane(){}
	Airplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	void flight(int distance)
	{
		super.setFuelSize(super.getFuelSize() - distance/10*30);
	}
	
}
