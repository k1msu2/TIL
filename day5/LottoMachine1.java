package day5;

public class LottoMachine1 {

	public static void main(String[] args) {
		int rand = 0;
		int arr[] = {0, 0, 0, 0, 0, 0};
		int index = 0;
		boolean check = false;
		
		while(true)
		{
			rand = (int)(Math.random()*45 + 1);
			
			for(int i = 0; i <index; i++)
			{	
				if( arr[i] == rand)
				{					
					check = true;
					break;
				}
			}

			if(!check)
			{
				arr[index++] = rand;
			}
			else
			{
				check = false;
			}
			
			if(arr[5]!=0)
				break;
		}
		
		System.out.print("오늘의 로또 번호 - ");
		for(int i = 0; i < 6; i++)
		{
			System.out.print( arr[i]);
			if(i !=5)
				System.out.print(", ");
		}

	}

}
