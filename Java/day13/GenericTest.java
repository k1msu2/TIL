package day13;
import java.util.*;
public class GenericTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("java");
//		/list.add(100); // Integer 객체가 되어 들어갈 것임
		list.add("servlet");
		list.add("jdbc");
		
		// 데이터가 많을 떄 속도가 느림
		for(int i=0; i < list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();		
		
		for(Object value : list) {
			String s = (String)value;		
			System.out.println(s);
		}
		System.out.println();		
		
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			//Object value = iter.next();
			//String s = (String) value;
			String s = (String) iter.next();
			System.out.println(s);
		}
		
	}
}
