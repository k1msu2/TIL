package day11.case2;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new LgTV(); // tv 라는 인터페이스를 구현하고 있는 객체 tv 
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}

}
