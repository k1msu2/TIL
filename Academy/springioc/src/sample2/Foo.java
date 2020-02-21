package sample2;
//InterFoo 는 추상메서드가 선언되어 있지 않기 떄문에 오버라이딩에 신경을 안써도 된다.
// 이번 소스는 argument를 주목해서 본다.
public class Foo implements InterFoo{
	public Foo() {
		System.out.println("Foo - Create object");
	}
	public Foo(String str) {
		System.out.println(str);
		System.out.println("----------Foo(String str)-------------");
	}
	public Foo(String str, int n) {
		System.out.println(str + "  " + n);
		System.out.println("--------Foo(String str, int n)---------------");
	}
	public Foo(String str, int n, boolean b) {
		System.out.println(str + "  " + n + "   " + b);
		System.out.println("---------Foo(String str, int n, boolean b)--------------");
	}
	public Foo(Bar bar) {
		System.out.println("Create object example");
		System.out.println("-----------Foo(Bar bar)------------ ");
	}
}








