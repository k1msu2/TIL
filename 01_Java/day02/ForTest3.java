package day02;

public class ForTest3 {
	
	public static void main(String[] args) {

		int num = 1;
		
		for(num = 1; num <=20; num++)
			System.out.println(num+" ");
		
		System.out.println(); // 俺青贸府
		for(num = 20; num >=1; num --)
			System.out.print(num+" ");
		System.out.println(); // 俺青贸府
		for(num = 20; num >=1; num -= 3)
			System.out.print(num+" ");
		System.out.println(); // 俺青贸府
		for(num = 20; num >=1; num -= 3)
			System.out.print(num+" ");
		
		System.out.print(num);
	}
}
