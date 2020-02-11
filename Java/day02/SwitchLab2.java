package day02;

public class SwitchLab2 {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*5) + 1;
		int ans = 0;
		
		switch(rand) {
		case 1: ans = 300+50; break;
		case 2: ans = 300-50; break;
		case 3: ans = 300*50; break;
		case 4: ans = 300/50; break;
		default: ans = 300%50; 
		}
		
		System.out.println("°á°ú°ª : "  + ans);
	}
	
}
