package day13;

import java.util.LinkedList;

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

public class FriendTestLinkedList {

	public static void main(String[] args) {
		
		
		LinkedList<Friend> list = new LinkedList<>();
		
		list.add(new Friend("��ũ1", "11012345678", "duke1@gmail"));
		list.add(new Friend("��ũ2", "21012345678", "duke2@gmail"));
		list.add(new Friend("��ũ3", "31012345678", "duke3@gmail"));
		list.add(new Friend("��ũ4", "41012345678", "duke4@gmail"));
		list.add(new Friend("��ũ5", "51012345678", "duke5@gmail"));
		
		
		
		System.out.println("�̸�\t\t ��ȭ��ȣ\t\t �����ּ�");
		System.out.println("-------------------------------------------------");
		
		
		for(Friend f:list)
		{
			System.out.println(f.getInfo());
		}
		
	}

}


class Person {
	private String name;
	Person(String name) {
		this.name = name;
	}
	public String getInfo() {
		return name;
	}
}
