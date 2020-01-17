package day04;

public class ArrayLab1 {

	public static void main(String[] args) {
		int [] ary ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for(int i = 0; i < 10; i++)
		{
			System.out.print(ary[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < 10; i++)
		{
			ary[i] = (i+1)*10;
		}
		
		for(int i = 0; i < 10; i++)
		{
			System.out.print(ary[i] + " ");
			
		}
		
		System.out.println();
		for(int i = 9; i >0; i--)
		{
			System.out.print(ary[i] + " ");
			
		}
		System.out.println();
		
		for(int i = 1; i< 10; i+=2)
		{
			System.out.print(ary[i] + " ");
		}
		System.out.println();
	}

}
