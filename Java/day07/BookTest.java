package day07;

class Book{
	
	String title;
	String author;
	int price;
	
	Book(){		
		this("�ڹ��� ����", "���� ��", 30000);
	}
	Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}	
	String getbookinfo() {
		return "å �̸� : " + title+" å ����: "+ author + "���� : "+ price;		
				
	}
}
public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("������ ����", "ȫXX", 15000);
		Book book3 = new Book("������ ����", "��XX", 23000);
		Book book4 = new Book("��ȸ�� ����", "��XX", 53000);
		Book book5 = new Book("������ ����", "��XX", 56000);		

		System.out.println(book1.getbookinfo());
		System.out.println(book2.getbookinfo());
		System.out.println(book3.getbookinfo());
		System.out.println(book4.getbookinfo());
		System.out.println(book5.getbookinfo());
	}

}
