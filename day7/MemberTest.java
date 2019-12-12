package day7;
class Member{
	String name;
	String account;
	String passwd;
	int birthyear;

}

public class MemberTest {


	
	public static void main(String[] args) {
		
		Member m1 = new Member();
		Member m2 = new Member();
		Member m3 = new Member();
		
		m1.name = "듀크";
		m1.account = "duke";
		m1.passwd = "1234";
		m1.birthyear = 1995;

		m2.name = "둘리";
		m2.account = "dully";
		m2.passwd = "5678";
		m2.birthyear = 1;		
		
		m3.name = "퍽시";
		m3.account = "foxy";
		m3.passwd = "0987";
		m3.birthyear = 1960;

		System.out.println("회원" + 1 +" : " + m1.name + "(" +m1.account + "," + 
			   m1. passwd + "," + m1.birthyear + ")");
		System.out.println("회원" + 2 +" : " + m2.name + "(" +m2.account + "," + 
				m2. passwd + "," + m2.birthyear + ")");	
		System.out.println("회원" + 3 +" : " + m3.name + "(" +m3.account + "," + 
				m3. passwd + "," + m3.birthyear + ")");	
	}

}
