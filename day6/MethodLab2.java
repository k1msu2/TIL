package day6;

public class MethodLab2 {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		
		for(int i = 0 ; i < 5; i++)
		{
			num1 = (int)(Math.random()*30)+1;
			num2 = (int)(Math.random()*30)+1;
			System.out.printf("%d와 %d의 차는 %d입니다.\n",
					num1, num2, printDiffer(num1, num2));
		}
	}
	static int printDiffer(int num1, int num2)
	{
		return num1>= num2? num1-num2:num2-num1;
	}
}
