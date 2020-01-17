package day04;

public class WhileLab3 {

	public static void main(String[] args) {
		int cnt = 0;
		int rand =0;
		final char ALPHA = 'A'-1; // 선언과 동시에 할 때는 자동 변환
		
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
		
		System.out.println("수행횟수는 " + cnt + "입니다");
		

	}

}
