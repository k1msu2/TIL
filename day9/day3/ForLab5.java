package day3;

public class ForLab5 {

	public static void main(String[] args) {
		int evenNum = 0;
		int oddNum = 0;
		
		for(int i = 1; i <= 100 ; i++)
		{
			if(i%2==0)
			{
				evenNum += i;
			}
			else
			{
				oddNum += i;
			}
		}
		
		System.out.println("1���� 100������ ���ڵ� �߿��� ¦���� ���� " + evenNum +"�̰� Ȧ���� ���� " +oddNum + "�̴�");
	
	}

}
