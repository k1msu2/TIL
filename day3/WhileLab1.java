package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*6) + 5;
		
		System.out.println("[for ���]");
		for(int i =0; i<rand; i++)
		{
			System.out.println(i+1 + "->" + (i+1)*(i+1));
		}

		System.out.println("[while ���]");
		int j = 0;
		while(j<rand)
		{
			System.out.println(j+1 + "->" + (j+1)*(j+1));
			j++;
		}
	}

}
