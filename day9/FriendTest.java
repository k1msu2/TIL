package day9;

class Person {
	private String name;
	Person(String name) {
		this.name = name;
	}
	public String getInfo() {
		return name;
	}
}

class Friend extends Person{
	private String phoneNum;
	private String email;
	
	Friend(String name, String phoneNum, String email)
	{
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public String getInfo()
	{
		return super.getInfo() + "\t" + this.phoneNum + "\t" + this.email;
	}
}


public class FriendTest {

	public static void main(String[] args) {
		
		Friend[] arr = new Friend[5];

		arr[0]= new Friend("��ũ1", "11012345678", "duke1@gmail");
		arr[1]= new Friend("��ũ2", "21012345678", "duke2@gmail");
		arr[2]= new Friend("��ũ3", "31012345678", "duke3@gmail");
		arr[3]= new Friend("��ũ4", "41012345678", "duke4@gmail");
		arr[4]= new Friend("��ũ5", "51012345678", "duke5@gmail");
		
		System.out.println("�̸�\t\t ��ȭ��ȣ\t\t �����ּ�");
		System.out.println("-------------------------------------------------");
		
		
		for(Friend f:arr)
		{
			System.out.println(f.getInfo());
		}
		
	}

}
