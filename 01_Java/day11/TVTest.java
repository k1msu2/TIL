package day11;

public class TVTest {

	public static void main(String[] args) {
		
		SaleTV tv1 = new SaleTV(3000000,"SALETV-1", 40, 1);
		RentalTV tv2 = new RentalTV(100000,"RENTALTV-10", 42, 1);
		
		tv1.channelUp();
		tv1.channelUp();
		
		tv2.channelDown();
		tv2.channelDown();
		tv2.channelDown();
		
		printAllTV(tv1);
		printAllTV(tv2);
		
		printRentalTV(tv2);
		
		// tv2 ��ü�� TV ���� ���, �Ʒ� �� ��� ��� ����
		//printRentalTV(Rentable) tv2);
		//printRentalTV(RentalTV) tv2);

	}
	
	static void printAllTV(TV tv) {
		System.out.println(tv.toString());
		
		if(tv instanceof SaleTV)
		{
			((SaleTV)tv).play();
			((SaleTV)tv).sale();
		}
		else if(tv instanceof RentalTV)
		{
			((RentalTV)tv).play();
		}
	}
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}

}
