package day07;


public class MemberTest {
	public static void main(String[] args) {
		Member p1 = new Member();
		Member p2 = new Member();
		Member p3 = new Member();
		p1.name = "�Ѹ�";
		p2.name = "������";
		p3.name = "��ġ";
		p1.account = "����߾�";
		p2.account = "������";
		p3.account = "����";
		p1.passwd = "123";
		p2.passwd = "456";
		p3.passwd = "789";
		p1.birthyear = 1983;
		p2.birthyear = 1500;
		p3.birthyear = 1400;
		System.out.println("ȸ��1 : " + p1.name + "(" + p1.account + ", " + p1.passwd + ", " + p1.birthyear + ")");
		System.out.println("ȸ��2 : " + p2.name + "(" + p2.account + ", " + p2.passwd + ", " + p2.birthyear + ")");
		System.out.println("ȸ��3 : " + p3.name + "(" + p3.account + ", " + p3.passwd + ", " + p3.birthyear + ")");
	}
}
