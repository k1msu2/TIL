package day09;

class Book {
	String title;
	String author;
	private int price;

	Book() {
		/*
		title = "자바의 정석";
		author = "남궁성";
		price = 30000;
		*/
		this("자바의 정석", "남궁성", 30000);
	}

	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		setPrice(price);
	}

	String getBookInfo() {
		return title + " " + author + " " + getPrice();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price<0)
			this.price = -price;
		else 
			this.price =price;		
	}
}

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book();
		//b1.price = -30000;
		System.out.println(b1.getBookInfo());
	}
}
