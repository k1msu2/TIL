package day06;

public class MethodTest1 {

	public static void main(String[] args) {
		System.out.println("main() ���� ����");
		
		day06.MethodTest1.printMyName();
		System.out.println(1);
		printMyName();
		System.out.println(2);
		printMyName();
		System.out.println(3);
		
		System.out.println(" main() ���� ����");
	}
	static void printMyName() {
		System.out.println("������");
		return;
	}
}
