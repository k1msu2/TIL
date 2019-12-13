package day7;

public class MethodTest10 {

	public static void main(String[] args)
	{
		int p1[] = {20, 10, 14, 30};
		System.out.println("p1의 값: " + p1);
		int[] result = updateArray1(p1);
		printArray(result);
		printArray(p1);
		System.out.println("-----------------------");
		updateArray2(p1);
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
	
	static int[] updateArray1(int[] p2) // p2가 변경된것은 없음. 
	// 새로운 배열 리턴한다. 이리터블
	{
		System.out.println("p2 변수의 값: " + p2);
		int[] result = new int[p2.length];
		for(int i = 0; i < result.length; i++)
		{
			result[i] = p2[i] * 2;
		}
		return result;
	}
	
	static void updateArray2(int[] p3) // 전달된 값이 변경. 리터블
	{
		System.out.println("p3 변수의 값: " + p3);
		for(int i = 0; i < p3.length; i++)
		{
			p3[i] = p3[i] * 2;
		}
	}
}
