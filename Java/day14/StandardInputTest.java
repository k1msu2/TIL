package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInputTest {

	public static void main(String[] args) throws Exception{
		System.out.print("�Է� : ");
		//int input = System.in.read(); //read() ���ϰ� int, �ѱ��ڸ� ����
		
		//int input = new InputStreamReader(System.in).read();
		//System.out.println("��� : "+(char)input);
		
		
		// Scanner ������
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("��� : "+input);

	}
}

