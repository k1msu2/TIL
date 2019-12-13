package day1;

public class LiteralTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1+1); 		//2
		System.out.println(1.0+1);	//1.0 + 1 -> 1.0+1.0 -> 2.0
		System.out.println('1'+1);	//문자데이터 1은 아스키 코드값 49로 계산
		System.out.println("1"+1);   //"1"+1 - > "1"+"1+ ->"11"
		System.out.println("123"+4);
		System.out.println(7777777777777L); // 롱형데이터
	}

}
