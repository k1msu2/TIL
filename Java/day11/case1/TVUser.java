package day11.case1;
public class TVUser {
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		//LgTV tv = new LgTV();
		
		//�޼����� �̸��� �԰�ȭ�� �ʿ���. ---> �������̽� 
		//����� ������ �޼������ �޶� �ٽñ����ؾ���.
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
	}
}
