package day03;

public class ForTest9 {
	public static void main(String[] args) {
			
		final char DECO = '@'; // final �ڹ��� ����� '���' : �ʱ�ȭ�� ���� �����Ǵ� ����, �빮�ڷ� �ۼ�
		//final double PI = 3.14;
			for(int rowNum=9; rowNum >= 1; rowNum--)
			{
				for(int colNum=1; colNum<=rowNum; colNum++)
				{
					System.out.print(DECO);
				}
			System.out.println();
			}
	}
	

}
