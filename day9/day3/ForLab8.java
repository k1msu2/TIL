package day3;

public class ForLab8 {

	public static void main(String[] args) {
	
		for(int i = 0; i < 5; i++)
		{
			for(int j =0; j <= i; j++)
			{
				System.out.print((char)('A'+i+j)); // �Ϲ� ������ �����Ͽ� ++ ó���� �����ϰ� �Ѵ�
			}
			System.out.println();
		}
	}
}
