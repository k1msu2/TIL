package day06;

public class MethodLab5 {

	public static void main(String[] args) {
		int r1[] = powerArray(2);
		int r2[] = powerArray(3);
		int r3[] = powerArray(4);

	
		for(int i = 0; i < r1.length; i++)
		{
			System.out.print(r1[i] + (i < r1.length - 1? ", ":""));
		}
		for(int i = 0; i < r2.length; i++)
		{
			System.out.print(r2[i] + (i < r2.length - 1? ", ":""));
		}
		for(int i = 0; i < r3.length; i++)
		{
			System.out.print(r3[i] + (i < r3.length - 1? ", ":""));
		}
		
		System.out.println();
	}

	public static int[] powerArray(int num)
	{
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1)*num;
		}
		
		return arr;
		
	}
}
