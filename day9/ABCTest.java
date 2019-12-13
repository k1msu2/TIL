package day9;

class A{
	A()
	{
		//super(); // 컴파일러가 자동으로 넣어주는 생성자, 구문 생략 가능
		System.out.println("A 클래스를 객체 생성합니다.");
	}
}

class B extends A{
	B(int num)
	{
		super(); // 컴파일러가 자동으로 넣어주는 생성자, 구문 생략 가능
		System.out.println("B 클래스를 객체 생성합니다.");
	}
}

class C extends B{
	C()
	{
		super(100); // 아규먼트없는 생성자가 작성되어 있지 않으면 명시적으로 호출을 해야 에러가 안남, 조상생성자에 알맞게 호출, 반드시 첫번째 행에서 실행
		System.out.println("C 클래스를 객체 생성합니다.");
	}
}


public class ABCTest {

	public static void main(String[] args) {
		
		C c = new C();
		System.out.println("------------------");

	}

}
