package day08;

class SalaryExpr{
	int bonus;
	
	SalaryExpr()
	{
		this.bonus = 0;
	}
	SalaryExpr(int bonus)
	{
		this.bonus = bonus;
	}
	
	int getSalary(int grade)
	{

		switch(grade) {
			case 1:
				this.bonus = 100;
				break;
			case 2:
				this.bonus = 90;
				break;
			case 3:
				this.bonus = 80;
				break;
			case 4:
				this.bonus = 70;
				break;
			default:
				this.bonus = 100;
				break;
		}
		
		return this.bonus;
			
	}
}

public class SalaryExam {

	public static void main(String[] args) {
		int month = (int)(Math.random()*12) +1;
		int grade = (int)(Math.random()*4) +1;
		int bonus = 0;
		
		if(month%2==0)
		{
			SalaryExpr se = new SalaryExpr(100);
			bonus = se.getSalary(grade);
		}
		else
		{
			SalaryExpr se = new SalaryExpr();
			bonus = se.getSalary(grade);
		}
		
		System.out.printf("%d월 %d등급의 월급은 %d입니다.", month, grade, bonus);
	}

}
