package day3;

public class ForLab7 {

	public static void main(String[] args) {
	
		final int RAND = (int)(Math.random()*6)+5;
		final char DECO = '&';
		
		for(int i = 0; i <RAND; i++)
		{
			for(int j = 0; j <=i; j++ )
			{
				System.out.print(DECO);
			}
			System.out.println();
		}
		
	}

}
