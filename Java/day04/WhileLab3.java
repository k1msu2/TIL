package day04;

public class WhileLab3 {

	public static void main(String[] args) {
		int cnt = 0;
		int rand =0;
		final char ALPHA = 'A'-1; // ����� ���ÿ� �� ���� �ڵ� ��ȯ
		
		while(true) {
			cnt++;
			
			rand = (int)(Math.random()*31); // 0<rand<31
			
			if(rand == 0 || (27<= rand && rand <=30))
			{
				break;
			}
			else
			{
				
				
				System.out.println((char)(ALPHA+rand) + "(" + rand +")");
				//cnt++;
			}
			//cnt++;
		}
		
		System.out.println("����Ƚ���� " + cnt + "�Դϴ�");
		

	}

}
