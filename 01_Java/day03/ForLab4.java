package day03;

public class ForLab4 {

	public static void main(String[] args) {
		int rand1 = (int)(Math.random()*7) + 3;
		int rand2 = (int)(Math.random()*2) + 1;
	
		if(rand2 == 1)
		{
			for(int i = 0; i < rand1; i++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		else if(rand2 == 2)
		{
			for(int i = 0; i < rand1; i++)
			{
				System.out.print("$");
			}
			System.out.println();			
		}
		else if(rand2 == 3)
		{
			for(int i = 0; i < rand1; i++)
			{
				System.out.print("#");
			}
			System.out.println();				
		}
	}

}
