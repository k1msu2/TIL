package day04;

public class ArrayTest1_1 {

	public static void main(String[] args) {
		int a1[] = new int[10];
		System.out.println(a1.length);
		int a2[] = {10, 20, 30};
		System.out.println(a2.length);
		
		for(int i = 0; i < a1.length; i++)
		{
			System.out.print(a1[i] + " ");
		}
		System.out.println();
		for(int data : a1)
			System.out.println(data);
		
		for(int i = 0; i < a2.length; i++)
		{
			System.out.print(a2[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i<a1.length; i++)
		{
			a1[i] = (i+1)*100;
		}
		
		for(int i = 0; i<a1.length; i++)
		{
			System.out.print(a1[i] + " ");
		}
		
		//a2[3] = 100; // �迭�� ũ�⸦ �ʰ��ϱ� ������ ������ �߻��Ѵ�, ������ ���� ���� �Ҷ� 
		

	}

}

