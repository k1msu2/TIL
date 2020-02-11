package day09;


public class GuGuDan {

	public static void main(String[] args) {
		GuGuDanExpr ggd;
		
		//int dan = (int)(Math.random()*20) +1;
		//int number = (int)(Math.random()*20) +1;
		
		int dan =10;
		int number =10;
		
		if((1<=dan&& dan<=9) &&(1<=number&& number<=9))
		{
			 ggd = new GuGuDanExpr(dan, number);
			 System.out.print(dan + "*" + number + "=");
			 ggd.printPart();
		}
		else if((1<=dan&& dan<=9) && number >= 10 ) 
		{
			ggd = new GuGuDanExpr(dan, number);
			System.out.print("2단: ");
			for(int i = 1; i <=number; i++)
			{
				System.out.print(dan + "*" +  i + "=" + dan*i + "   ");
			}
			ggd.printPart();
		}
		else if(dan >= 10)
		{
			GuGuDanExpr.printAll(); // 스태틱이라서 클래스 이름으로 접근
		}
		
	}

}

class GuGuDanExpr extends Multiplication{
		
	static void printAll()
	{
		for(int dan = 1; dan <=9; dan++)
		{
			for(int number = 1; number <=9; number++)
				System.out.print(dan + "*" + number + "=" + number* dan+ "   ");
			System.out.println();
		}
	}
	GuGuDanExpr()
	{
		
	}
	GuGuDanExpr(int dan)
	{
		super(dan);
	}
	GuGuDanExpr(int dan, int number)
	{
		super(dan, number);
	}
}
class Multiplication {
	private int dan;
	private int number;
	
	Multiplication() {}
	Multiplication(int dan) {
		this.dan = dan;
	}
	Multiplication(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	public void printPart() {
		if (number == 0) {	       
			for(int n=1; n <= 9; n++)
				System.out.print("\t"+dan + "*" + n+ "="+dan*n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}
