package day04;

public class BreakTest {
	public static void main(String[] args) {
		
		// flag ��� : C��� ���
		/*
		boolean flag = false; 
			for(int dan = 1; dan <9; dan++)
			{
				for(int num = 1; num <=9; num++)
				{
					if(dan*num > 30)
					{
						flag = true;
						break; // �ش� �ܸ� ����
					}
					System.out.print(dan + "x" + num + "=" + dan*num +"\t");
				}
				System.out.println();
				if(flag)
					break;
			}
		*/
		unico : for(int dan = 1; dan <9; dan++) // �ݺ����� unico ���� ���̱�
		{
			for(int num = 1; num <=9; num++)
			{
				if(dan*num > 30)
				{
					System.out.println(); // ������ ��� ���� ����
					break unico; 
				}
				System.out.print(dan + "x" + num + "=" + dan*num +"\t");
			}
			System.out.println();
		}	
		System.out.println("������ ��� ����");

			
	}
	

}
