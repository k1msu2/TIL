package work;

public class PlaneTest {

	public static void main(String[] args) {
		Plane[] p = new Plane[2];
		
		p[0] = new Airplane("L747", 1000);
		p[1] = new Cargoplane("C40", 1000);
		printInfo(p);
		
		System.out.println();
		System.out.println("[100 운항]");
		p[0].flight(100);
		p[1].flight(100);
		printInfo(p);
		
		System.out.println();
		System.out.println("[200 주유]");
		p[0].refuel(200);
		p[1].refuel(200);
		printInfo(p);
	}
	
	public static void printInfo(Plane[] list){
		System.out.println("Plane     fuelSize");
		System.out.println("----------------------");
		
		for(Plane p:list)
		{
			System.out.println(p.getPlaneName() + "\t" + p.getFuelSize());
		}
	}

}
