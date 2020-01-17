package day04;

public class ArrayLab2 {
	public static void main(String[] args) {
		
		int arr[] = new int[10];
		int rand;
		for(int i = 0; i < 10; i++)
		{
			arr[i] = (int)(Math.random()*17)+4;
		}
		System.out.println(arr);
	}
}
