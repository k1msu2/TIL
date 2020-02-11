package day04;

public class BreakTest {
	public static void main(String[] args) {
		
		// flag 사용 : C언어 방식
		/*
		boolean flag = false; 
			for(int dan = 1; dan <9; dan++)
			{
				for(int num = 1; num <=9; num++)
				{
					if(dan*num > 30)
					{
						flag = true;
						break; // 해당 단만 종료
					}
					System.out.print(dan + "x" + num + "=" + dan*num +"\t");
				}
				System.out.println();
				if(flag)
					break;
			}
		*/
		unico : for(int dan = 1; dan <9; dan++) // 반복문에 unico 별명 붙이기
		{
			for(int num = 1; num <=9; num++)
			{
				if(dan*num > 30)
				{
					System.out.println(); // 구구단 출력 종료 개행
					break unico; 
				}
				System.out.print(dan + "x" + num + "=" + dan*num +"\t");
			}
			System.out.println();
		}	
		System.out.println("구구단 출력 종료");

			
	}
	

}
