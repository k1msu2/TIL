package day6;

public class MethodTest7_1 {

	public static void main(String[] args) { // 프로그램 시작시 전달 데이터
		String result = ""; // 초기화
		for(int i=0; i < args.length; i++)
		{
			result += args[i];
		}
		System.out.println(result);
	}
}
