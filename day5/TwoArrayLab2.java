package day5;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		char chars[][] =  {
				{'B', 'C', 'A', 'A'}, 
				{'C', 'C', 'B', 'B'},
				{'D', 'A', 'A', 'D'}
		};
		
		final char CHARS[] = {'A', 'B', 'C', 'D'};
		int[] nums = new int[4];
		
		for (int i = 0; i < chars.length; i++)
		{
			for( int j = 0; j < chars[0].length; j++)
			{
				if( chars[i][j] == CHARS[0])
				{
					nums[0] +=1;
				}
				else if( chars[i][j] == CHARS[1])
				{
					nums[1] +=1;
				}
				else if( chars[i][j] == CHARS[2])
				{
					nums[2] +=1;
				}
				else if( chars[i][j] == CHARS[3])
				{
					nums[3] +=1;
				}					
			}
		}
		
		for (int i = 0; i < CHARS.length; i++)
		{
			System.out.println(CHARS[i] + "는 " + nums[i] + "개 입니다." );
		}

	}

}
