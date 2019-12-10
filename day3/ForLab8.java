package day3;

public class ForLab8 {

	public static void main(String[] args) {
	
		for(int i = 0; i < 5; i++)
		{
			for(int j =0; j <= i; j++)
			{
				System.out.print((char)('A'+i+j)); // 일반 변수로 선언하여 ++ 처리로 간단하게 한다
			}
			System.out.println();
		}
	}
}
