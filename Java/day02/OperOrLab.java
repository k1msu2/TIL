package day02;

public class OperOrLab {
	public static void main(String[] args) {
		
		int grade = (int)(Math.random()*6) + 1;
		
		if (grade == 1 || grade ==2 || grade ==3)
			System.out.println("" + grade + " �г��� ���г��Դϴ�.");
		else if(grade == 4 || grade == 5 || grade == 6)
			System.out.println(""+grade + " �г��� ���г��Դϴ�");
	}	
}
