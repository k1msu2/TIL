package day4;

public class ArrayTest3 {

	public static void main(String[] args) {
		int a1[] = {2, 10, 2, 9, 5, 11, 12, 1};
		
		// a1 �迭������ �Ҵ�� �迭�� ��� �� �ִ�
		int max = a1[0];
		for(int i = 0; i < a1.length; i++)
			if(a1[i]>max)
				max=a1[i];
		System.out.println("�ִ�: " +max);
		//	System.out.print(a1[i] + " ");
		//System.out.println();
		
		// a1 �迭 ������ �Ҵ�� �迭�� ��� �� �ּڰ�

		int min = a1[0];
		for(int i = 0; i < a1.length; i++)
			if(a1[i]<min)
				min = a1[i];
		System.out.println("�ּҰ�: " +min);
	}

}

