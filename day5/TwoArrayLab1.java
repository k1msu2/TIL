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
		
		System.out.println("1행 1열의 데이터 : " + nums[0][0]);
		System.out.println("3행 4열의 데이터 : " + nums[2][3]);
		System.out.println("행의 갯수 : "  + nums.length);
		System.out.println("열의 갯수 : " + nums[0].length);
		
		System.out.print("3행의 데이터들 : ");
		for(int i = 0; i < nums[0].length; i++) 
		{
			System.out.print(nums[2][i] + " ");
		}
		System.out.println();
		
		System.out.print("2열의 데이터들: ");
		for( int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i][1] + " ");
		}
		System.out.println(" ");
		
		System.out.print("왼쪽 대각선 데이터들 :");
		
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
		System.out.print("오른쪽 대각선 데이터들 : ");
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
