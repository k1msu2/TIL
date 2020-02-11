package day06;

public class MethodLab1 {

	public static void main(String[] args) {
			
		printChar('@',3);
		printChar('%',4);
		printChar('A', 5);
		printChar('°¡',3);

	}
	static void printChar(char c, int num)
	{
		for(int i = 0 ; i<num; i++)
		{
			System.out.print(c);
		}
		System.out.println();
	}

}
