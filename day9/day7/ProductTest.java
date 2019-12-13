package day7;

class Product{
	String name;
	int balance;
	int price;
	
	Product()
	{
		/*
		this.name = "µàÅ©ÀÎÇü";
		this.balance = 5;
		this.price = 10000;
		*/
		
		this("µàÅ©ÀÎÇü",5, 10000);
	}
	
	Product(String name, int balance, int price)
	{
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
	
	String getName()
	{
		return this.name;
	}
	
	int getBalance()
	{
		return this.balance;
	}
	
	int getPrice()
	{
		return this.price;
	}
	
}

public class ProductTest {

	public static void main(String[] args) {
		Product[] p= new Product[5];
		
		/*
		for(int i = 0; i < p.length; i++)
		{
			p[i] = new Product();
		}
	
		p[0].name = "µàÅ©¾ö¸¶";
		p[1].name = "µàÅ©¾Æºü";
		p[2].name = "µàÅ©¿Àºü";
		p[3].name = "µàÅ©¾ð´Ï";
		p[4].name = "µàÅ©µ¿»ý";
		
		p[0].balance = 10;
		p[1].balance = 9;
		p[2].balance = 8;
		p[3].balance = 7;
		p[4].balance = 6;
		
		p[0].price = 10000000;
		p[1].price = 9000000;
		p[2].price = 8000000;
		p[3].price = 7000000;
		p[4].price = 6000000;
		*/
		
		p[0] = new Product("µàÅ©¾ö¸¶", 10, 1000000);
		p[1] = new Product("µàÅ©¾ö¸¶", 10, 1000000);
		p[2] = new Product("µàÅ©¾ö¸¶", 10, 1000000);
		p[3] = new Product("µàÅ©¾ö¸¶", 10, 1000000);
		p[4] = new Product("µàÅ©¾ö¸¶", 10, 1000000);
				
		// traditional for
		for(int i = 0; i < p.length; i++)
		{
			System.out.printf("%s %d %,d \n", p[i].getName(), p[i].getBalance(), p[i].getPrice());
		}
		
		for(Product data:p)
			System.out.printf("%s %d %,d \n", data.getName(), data.getBalance(), data.getPrice());
		
		System.out.println(p);
	}

}
