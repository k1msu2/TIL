package day08;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		String oper = "";
		int sum = 0;
		
		System.out.print("ù ��° ���ڸ� �Է��ϼ��� :");
		num1 = sc.nextInt();
		System.out.print("�� ��° ���ڸ� �Է��ϼ��� :");
		num2 = sc.nextInt();
		System.out.print("������(+, -, *, /)�� �Է��ϼ��� :");
		oper = sc.next();
		
		switch(oper){
		case "+":
			sum = num1 + num2;
			System.out.printf("%d�� %d�� ���� ����� %d�Դϴ�.\n", num1, num2, sum);
			break;
		case "-":
			sum = num1 - num2;
			System.out.printf("%d�� %d�� ���� ����� %d�Դϴ�.\n", num1, num2, sum);
			break;
		case "/":
			sum = num1 / num2;
			System.out.printf("%d�� %d�� ���� ����� %d�Դϴ�.\n", num1, num2, sum);
			break;
		case "*":
			sum = num1 * num2;
			System.out.printf("%d�� %d�� ���� ����� %d�Դϴ�.\n", num1, num2, sum);
			break;
		default:
			System.out.println("+, -, *, / �� �Է��ϼ�");
				
		}
		sc.close();
	}

}
