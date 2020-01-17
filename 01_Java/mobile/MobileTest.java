package mobile;

public class MobileTest {

	public static void main(String[] args) {
		Ltab mobileL = new Ltab("Ltab", 500, "ABC-10");
		Otab mobileO = new Otab("Otab", 1000, "XYZ-20");
		
		printTitle();
		printMobile(mobileL);
		printMobile(mobileO);
		System.out.println();
		
		System.out.println("[ 10분 충전 ]");
		printTitle();
		mobileL.charge(10);
		mobileO.charge(10);
		printMobile(mobileL);
		printMobile(mobileO);
		System.out.println();
		
		System.out.println("[ 5분 통화 ]");
		printTitle();
		mobileL.operate(5);
		mobileO.operate(5);
		printMobile(mobileL);
		printMobile(mobileO);
		System.out.println();
		

	}
	
	public static void printMobile(Mobile mobile) { // ltab otab 전달
		
		/*  형변환 안해줘도 됨
		if(mobile instanceof Ltab)
		{
			System.out.println(((Ltab)mobile).getMobileName() + "\t" + 
					((Ltab)mobile).getBatterySize()+"\t" +
					((Ltab)mobile).getOsType());
		}
		else if(mobile instanceof Otab)
		{
			System.out.println(((Otab)mobile).getMobileName() + "\t" + 
					((Otab)mobile).getBatterySize()+"\t" +
					((Otab)mobile).getOsType());
		}
		*/
		
		System.out.println(mobile.getMobileName() + "\t" + 
				mobile.getBatterySize()+"\t" +
				mobile.getOsType());
	}
	
	public static void printTitle() {
		System.out.println("Mobile\t Battery\tOS\t");
		System.out.println("---------------------------------------------------");
	}

}
