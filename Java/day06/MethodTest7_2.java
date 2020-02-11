package day06;

public class MethodTest7_2 {

	public static void main(String[] args) { // 프로그램 시작시 전달 데이터
		int result = 0; // 초기화
		for(int i=0; i < args.length; i++)
		{
			result  = result + Integer.parseInt(args[i]);
		}
		System.out.println(result);
	}
}
