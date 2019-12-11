package day7;

public class MethodTest10 {

	public static void main(String[] args)
	{
		int p1[] = {20, 10, 14, 30};
		System.out.println("p1�� ��: " + p1);
		printArray(p1);
		int[] result = updateArray1(p1);
		printArray(result);
		printArray(p1);
	}
	static void printArray(int[] p2) 
	{
		for(int d:p2)
		{
			System.out.printf("%d ", d);
		}
		System.out.printf("\n");
	}
	
	static int[] updateArray1(int[] p2)
	{
		System.out.println("p2 ������ ��: " + p2);
		int[] result = new int[p2.length];
		for(int i = 0; i < result.length; i++)
		{
			result[i] = p2[i] * 2;
		}
		return result;
	}
	
	static void updateArray2(int[] p2)
	{
		System.out.println("p2 ������ ��: " + p2);
		int[] result = new int[p2.length];
		for(int i = 0; i < result.length; i++)
		{
			result[i] = p2[i] * 2;
		}
	}
}
