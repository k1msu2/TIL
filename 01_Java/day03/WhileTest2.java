package day03;

public class WhileTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 10;
		while(sum<100)
		{
			i = (int)Math.random()*40 + 1;
		 sum += i;
		 System.out.println("");
		}
	}

}
