package work;

public class Cargoplane extends Plane{
	
	Cargoplane(){}
	Cargoplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	void flight(int distance)
	{
		super.setFuelSize(super.getFuelSize() - distance/10*50);
	}
}
