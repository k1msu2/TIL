package day02;

public class ConditionOperLab {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*5) + 1;
		int ans = 0;
		
		if(rand == 1)
			ans = 300+50;
		else if(rand == 2)
			ans = 300-50;
		else if(rand == 3)
			ans = 300*50;
		else if(rand==4)
			ans = 300/50;
		else //if(rand==5) �ʱ�ȭ ���� ���� ������ ���� ��쿡�� else ������ ������ ������
			ans = 300%50;
		
		System.out.println(ans);
	}
	
}
