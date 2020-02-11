package day14;
public class HashCodeTest {
	public static void main(String[] args) {
		String s1 = new String("듀크");
		String s2 = new String("듀크");
		String s3 = new String("듀크");
		String s4 = new String("듀크");
		String s5 = "듀크";
		System.out.print(s1);
		
		// hashCode 를 오버라이딩 하지 않으면 Object 의 해시 코드(객체의 참조값)를 가져오므로 키값으로 사용할 수 없다
		System.out.println(s1.hashCode());
		System.out.print(s1);
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		String s6 = new String("고길동");
		String s7 = new String("듀크1");
		System.out.println(s6.hashCode());
		System.out.println(s7.hashCode());
	}
}
