package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInputTest {

	public static void main(String[] args) throws Exception{
		System.out.print("입력 : ");
		//int input = System.in.read(); //read() 리턴값 int, 한글자만 읽음
		
		//int input = new InputStreamReader(System.in).read();
		//System.out.println("출력 : "+(char)input);
		
		
		// Scanner 사용권장
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("출력 : "+input);

	}
}

