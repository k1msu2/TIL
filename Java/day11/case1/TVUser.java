package day11.case1;
public class TVUser {
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		//LgTV tv = new LgTV();
		
		//메서드의 이름의 규격화가 필요함. ---> 인터페이스 
		//기능은 같지만 메서드명이 달라서 다시구현해야함.
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
	}
}
