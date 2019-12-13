package day3;

public class ForLab3 {

	public static void main(String[] args) {
		int rand1 = (int)(Math.random()*10) + 1;
		int rand2 = (int)(Math.random()*11)+ 30;
		int sum = 0;

		for(int i = rand1; i <= rand2; i++)
		{
			if(i%2 ==0) 
			{
				sum += i;
			}
		}
	
		
		System.out.println("X부터 Y까지의 짝수의 합: " + sum);
	}

}
