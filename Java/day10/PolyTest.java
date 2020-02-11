package day10;

public class PolyTest {

	public static void main(String[] args) {
		printObjectInfo(new Object());
		printObjectInfo(new String("가나다"));
		printObjectInfo("ABC");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:\\Temp"));
		printObjectInfo(new int[10]);
		printObjectInfo(new double[5]);
		printObjectInfo(new day07.Member()); // public 클래스 접근 가능
		printObjectInfo(new Integer(100));
		printObjectInfo(100);
		printObjectInfo('가');
		
		char c = '가';
		printObjectInfo(c);
		}
	
	static void printObjectInfo(Object o) {
	
		
		if(o instanceof String) // 형 변환 가능한지 확인하는 연산자 instanceof
		{
			System.out.println("문자열 객체 전달됨: " + o.getClass().getName() + "-" +((String) o).length() + "-" +((String) o).toLowerCase());
		}
		else
		{
			System.out.println("전달된 객체의 클래스명 : " + o.getClass().getName());		
		}
		
	}
}
