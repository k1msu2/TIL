package day02;

public class RandomTest {

	public static void main(String[] args) {
		System.out.println(Math.random()); // 0.0 <= n < 1.0 
		double rand1 = Math.random();
		System.out.println(rand1);
		double rand2 = rand1 * 10;
		System.out.println(rand2);
		int rand3 = (int)rand2;
		System.out.println(rand3); // 0 ~ 9
		
		// rand1 �� ������ 1���� 6������ ������ ����� ���� �����Ͽ�
		// sixNum ������ ��Ƽ� ����� ���� 
		
		int sixNum = (int)(rand1 *6) + 1;
		System.out.println(sixNum);
		
		// rand1 �� ������ 1���� 45 ������ ������ ����� ���� �����Ͽ�
		// lottoNum ������ ��Ƽ� ����� ����
		
		int lottoNum = (int)(rand1*45)+ 1;
		System.out.println(lottoNum);
			
		
		
		
	}

}
