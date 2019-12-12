package day7;

class Book {
	String title;
	String author;
	int price;

	Book() {
		/*
		title = "�ڹ��� ����";
		author = "���ü�";
		price = 30000;
		*/
		this("�ڹ��� ����", "���ü�", 30000);
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

		Book b2 = new Book("Do it!�ڹٽ�ũ��Ʈ", "���ο�", 20000);
		System.out.println(b2.getBookInfo());

		Book b3 = new Book("�˰������� ���� �ΰ�����, �ӽŷ���, ������ �Թ�", "������", 27000);
		System.out.println(b3.getBookInfo());
	}

}
