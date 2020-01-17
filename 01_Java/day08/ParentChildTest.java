package day08;


class Parent{ //java.lang.Object : 부모로 지정하지 않으면 자동으로 생성. 물러받음.
	// 메서드가 없어도 물려받은 멤버가 있음
	
	int x = 1,  y = 2;
	public String toString()
	{
		return "Parent 클래스의 객체 입니당";
	}

}

class Child extends Parent{ // 상속 구문
	int x = 10;
	void printInfo()
	{
		int x = 100;
		System.out.println(x);		 		//100
		System.out.println(this.x); 		//10       this 는 자기 자신의 클래스를 가르키는 리터럴
		System.out.println(super.x); 	//1 		  가장 가까운 부모 객체에서 가져옴
		System.out.println(y); 				//2          
		System.out.println(this.y); 		//2
		System.out.println(super.y); 	//2
		//System.out.println(z);
	}
	public String toString()
	{
		return "Child 클래스의 객체 입니당";
	}
}
public class ParentChildTest {

	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println(p.toString()); // Object 클래스의 toString()메서드
		System.out.println(p);
		System.out.println("출력1 " + p);
		Card c = new Card();
		System.out.println(c.toString());
		System.out.println("출력2 " + c);
		java.util.Date d = new java.util.Date();
		System.out.println(d.toString());
		System.out.println("출력3 " + d);
		Child ch = new Child();
		System.out.println("출력4 " + ch.toString());
		System.out.println();
		ch.printInfo();
		System.out.println(ch.x);
		System.out.println(ch.y);
	}

}
