package day9;

class A{
	A()
	{
		//super(); // �����Ϸ��� �ڵ����� �־��ִ� ������, ���� ���� ����
		System.out.println("A Ŭ������ ��ü �����մϴ�.");
	}
}

class B extends A{
	B(int num)
	{
		super(); // �����Ϸ��� �ڵ����� �־��ִ� ������, ���� ���� ����
		System.out.println("B Ŭ������ ��ü �����մϴ�.");
	}
}

class C extends B{
	C()
	{
		super(100); // �ƱԸ�Ʈ���� �����ڰ� �ۼ��Ǿ� ���� ������ ��������� ȣ���� �ؾ� ������ �ȳ�, ��������ڿ� �˸°� ȣ��, �ݵ�� ù��° �࿡�� ����
		System.out.println("C Ŭ������ ��ü �����մϴ�.");
	}
}


public class ABCTest {

	public static void main(String[] args) {
		
		C c = new C();
		System.out.println("------------------");

	}

}
