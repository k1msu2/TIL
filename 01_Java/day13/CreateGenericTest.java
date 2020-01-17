package day13;
import java.util.Date;
public class CreateGenericTest {
	public static void main(String[] args) {
		Value1 o1 = new Value1();
		o1.put("abc");
		String s1 = o1.get(); 
		System.out.println(s1);		
		
		Value2 o2 = new Value2();
		o2.put("abc");
		String s2 = (String)o2.get(); 
		System.out.println(s2);
		
		//Value3<String> o3 = new Value3<String>();
		// 타입 파라미터가 String
		Value3<String> o3 = new Value3<>();		
		o3.put("abc");
		String s3 = o3.get(); // 리턴값 파라미터가 String형
		System.out.println(s3);	
		
		Value3<Date> o4 = new Value3<Date>();		
		o4.put(new Date());
		//o4.put("abd"); // 타입 파라미터가 Date 이므로 에러
		Date s4 = o4.get(); 
		System.out.println(s4);	
	}
}


class Value1 {
	String obj;
	void put(String obj){
		this.obj = obj;
	}
	String get() {
		return obj;
	}
}

// value2는 어떤 객체든 받을 수 있다
// 꺼낼때 반드시 형변환을 해줘야한다.
// 형변환 안하면 에러
class Value2 {
	Object obj;
	void put(Object obj){
		this.obj = obj;
	}
	Object get() {
		return obj;
	}
}
// Value3<Card> v = new Value3<Card>();
// Value3<String> v = new Value3<String>();


// 타입 파라미터를 하나만 받겠어!
// 얘를 어디다가 쓸지는 개발자 맘이야
// 타입 파라미터 Card 를 주면 매개변수, 리턴값 다 Card 로 바뀜
// 클래스가 처리할 데이터의 타입을 프로그램 개발하는 시점에서 정하는 것이 아니라 
// *****객체생성하는 시점*****에서 정하겠다
// 일반화 시키겠다 --> 제너릭스
class Value3<TT> {
	TT obj;
	void put(TT obj){
		this.obj = obj;
	}
	TT get() {
		return obj;
	}
}













