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
		else //if(rand==5) 초기화 되지 않은 변수가 있을 경우에는 else 구문이 없으면 에러남
			ans = 300%50;
		
		System.out.println(ans);
	}
	
}
