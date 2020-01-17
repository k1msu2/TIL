package day14;

import java.util.HashSet;

class Member3 {
	private int id;
	private String name;
	private String password;
	Member3(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public boolean equals(Object o) {
		if (o != null && o instanceof Member3) {
			Member3 m = (Member3) o;			
			if (id ==  m.id && 
					name.equals(m.name) && 
							password.equals(m.password))
				return true;
		}
		return false;
	}	
	public int hashCode() {
		return id+name.hashCode()+password.hashCode();
	}
	
	public String toString() { // 객체의 정보를 하나의 문장으로 출력해주는 메서드
		return "("+id+":"+name+":"+password+")";
	}
}
public class ObjectTest3 {
	public static void main(String args[]) {
		Member3 obj1 = new Member3(10, "자바", "duke");
		Member3 obj2 = new Member3(10, "자바", "duke");
		Member3 obj3 = new Member3(20, "자바", "duke");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());		
		System.out.println(obj3.hashCode());	
		HashSet<Member3> set = new HashSet<>(); // 동일한 내용의 객체를 한번만 저장하고 싶을 때 오버라이딩할 메서드 1. hashcode 2. equals
		set.add(obj1);
		set.add(obj2);
		set.add(obj3);
		System.out.println("저장된 데이터의 갯수 : " + set.size());
		System.out.println(set);
	}
}




