package day10;

import java.util.Scanner;

public class ScannerLab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		String oper = "";
		int sum = 0;
		// 숫자와 연산자를 입력받아 처리하는 기능을 3번 반복하도록 코드 추가
		
		for(int i = 0; i <3 ; i++)
		{
			System.out.print("첫 번째 숫자를 입력하세요 :");
			num1 = sc.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 :");
			num2 = sc.nextInt();
			System.out.print("연산자(+, -, *, /)를 입력하세요 :");
			oper = sc.next();
			
			
			
			switch(oper){
			case "+":
				sum = num1 + num2;
				System.out.printf("%d와 %d의 연산 결과는 %d입니다.\n", num1, num2, sum);
				break;
			case "-":
				sum = num1 - num2;
				System.out.printf("%d와 %d의 연산 결과는 %d입니다.\n", num1, num2, sum);
				break;
			case "/":
				sum = num1 / num2;
				System.out.printf("%d와 %d의 연산 결과는 %d입니다.\n", num1, num2, sum);
				break;
			case "*":
				sum = num1 * num2;
				System.out.printf("%d와 %d의 연산 결과는 %d입니다.\n", num1, num2, sum);
				break;
			default:
				System.out.println("+, -, *, / 를 입력하숑");
			}				
		}		
		sc.close();
	}

}
