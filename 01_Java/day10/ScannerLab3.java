package day10;

import java.util.Scanner;

public class ScannerLab3 {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		String oper = "";
		int sum = 0;
		boolean flag = true;
		String loop = "";
		// ���ڿ� �����ڸ� �Է¹޾� ó���ϴ� �����
		// ����ڰ� ���� ������ �ݺ��ϵ��� �ڵ� �߰�
		// ��� ��� �� ����ڿ��� ��� �����ϰڴ����� ���� �޽����� ����ϰ�
		// 1�� �Է��ϸ� ��� �����̰� 2�� �Է��ϸ� ����
		
		
		while(flag)
		{			
			Scanner sc = new Scanner(System.in);
			//System.out.println(sc.hashCode());
			sc.nextLine();			
			System.out.print("ù ��° ���ڸ� �Է��ϼ��� :");
			num1 = sc.nextInt();
			 sc.nextLine();
			//sc.skip("[\\r\\n]+");
			System.out.print("�� ��° ���ڸ� �Է��ϼ��� :");
			num2 = sc.nextInt();
			 sc.nextLine();
			//sc.skip("[\\r\\n]+");
			System.out.print("������(+, -, *, /)�� �Է��ϼ��� :");
			oper = sc.next();
			 sc.nextLine();
			//sc.skip("[\\r\\n]+");
			
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
			
			//System.out.print("��� �����Ͻðڽ��ϱ�?(1: ��� ����) : ");
			System.out.print("��� �����Ͻðڽ��ϱ�?(y : ��� ����):");
			loop = sc.next();
			 sc.nextLine();
			if(!loop.equals("y"))
			{
				flag = false; 
			}			
			//if(loop != 1)
			//{
			//	flag = false; 
			//}
			sc.close();
			//sc = null;
			//System.out.println(sc.hashCode());
			
			//sc = null;
		}

	}

}
