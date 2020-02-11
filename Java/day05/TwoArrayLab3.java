package day05;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		
		int[][] arr = new int[4][];
		arr[0] = new int[5];
		arr[1] = new int[3];
		arr[2] = new int[4];
		arr[3] = new int[9];

		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j <arr[i].length; j++)
			{
				switch (i) {
					case 0:
						arr[i][j] = (j+1)*10; 
						break;
					case 1:
						arr[i][j] = (j+1)*5;
						break;
					case 2:
						arr[i][j] = (j+1) *11;
						break;
					case 3:
						arr[i][j] = 9-j;						
						break;
					default:	
				}
						
			}
		}
		
		int [] sum = new int[4];
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j <arr[i].length; j++)
			{
				sum[i]+=arr[i][j];
			}
		}
		
		for(int i = 0; i < sum.length; i++)
		{
			System.out.println((i+1) +"행의 합은 " + sum[i] + "입니다.");
		}
		
	}
	}

