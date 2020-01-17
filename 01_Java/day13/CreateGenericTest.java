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
		// Ÿ�� �Ķ���Ͱ� String
		Value3<String> o3 = new Value3<>();		
		o3.put("abc");
		String s3 = o3.get(); // ���ϰ� �Ķ���Ͱ� String��
		System.out.println(s3);	
		
		Value3<Date> o4 = new Value3<Date>();		
		o4.put(new Date());
		//o4.put("abd"); // Ÿ�� �Ķ���Ͱ� Date �̹Ƿ� ����
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

// value2�� � ��ü�� ���� �� �ִ�
// ������ �ݵ�� ����ȯ�� ������Ѵ�.
// ����ȯ ���ϸ� ����
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


// Ÿ�� �Ķ���͸� �ϳ��� �ްھ�!
// �긦 ���ٰ� ������ ������ ���̾�
// Ÿ�� �Ķ���� Card �� �ָ� �Ű�����, ���ϰ� �� Card �� �ٲ�
// Ŭ������ ó���� �������� Ÿ���� ���α׷� �����ϴ� �������� ���ϴ� ���� �ƴ϶� 
// *****��ü�����ϴ� ����*****���� ���ϰڴ�
// �Ϲ�ȭ ��Ű�ڴ� --> ���ʸ���
class Value3<TT> {
	TT obj;
	void put(TT obj){
		this.obj = obj;
	}
	TT get() {
		return obj;
	}
}













