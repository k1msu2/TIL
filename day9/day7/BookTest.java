package day7;

class Book {
	String title;
	String author;
	int price;

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
		this.price = price;
	}

	String getBookInfo() {
		return title + " " + author + " " + price;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		System.out.println(b1.getBookInfo());

		Book b2 = new Book("Do it!자바스크립트", "정인용", 20000);
		System.out.println(b2.getBookInfo());

		Book b3 = new Book("알고리즘으로 배우는 인공지능, 머신러닝, 딥러닝 입문", "김의중", 27000);
		System.out.println(b3.getBookInfo());
	}

}
