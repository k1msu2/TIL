package day5;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		int[][] nums= new int[4][4];
		int value = 10;
		
		
		for (int row = 0; row < nums.length; row++)
		{
			for (int col = 0; col < nums[row].length; col ++)
			{
				nums[row][col]  = value;  
				value+=2;
			}
			
		}
		
		System.out.println(nums);
		System.out.println("---------------------");
		
		System.out.println("1�� 1���� ������ : " + nums[0][0]);
		System.out.println("3�� 4���� ������ : " + nums[2][3]);
		System.out.println("���� ���� : "  + nums.length);
		System.out.println("���� ���� : " + nums[0].length);
		
		System.out.print("3���� �����͵� : ");
		for(int i = 0; i < nums[0].length; i++) 
		{
			System.out.print(nums[2][i] + " ");
		}
		System.out.println();
		
		System.out.print("2���� �����͵�: ");
		for( int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i][1] + " ");
		}
		System.out.println(" ");
		
		System.out.print("���� �밢�� �����͵� :");
		
		for ( int i = 0; i < nums.length; i++)
		{
			for (int j = 0; j < nums[i].length; j++)
			{
				if(i == j)
				{
					System.out.print(nums[i][j] + " ");
				}
			}
		}
		System.out.println();
		System.out.print("������ �밢�� �����͵� : ");
		for (int i = 0; i < nums.length; i++)
		{
			for(int j = 0; j < nums[i].length; j++)
			{
				if(i + j == nums.length -1)
				{
					System.out.print(nums[i][j] + " ");
				}
			}
		}
		System.out.println();

	}

}
