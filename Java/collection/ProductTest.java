package collection;

import java.util.HashSet;

public class ProductTest {

	public static void main(String[] args) {
		Product[] p = new Product[4];
		
		p[0] = new Product("p100", "TV", "20000");
		p[1] = new Product("p200", "computer", "10000");
		p[2] = new Product("p100", "MP3", "700");
		p[3] = new Product("p300", "Audio", "1000");
		
		HashSet<Product> hs = new HashSet<Product>();
		
		/*
		for(int i = 0; i<4; i++)
		{
			if(hs.add(p[i]))
			{
				System.out.println(p[i].getProductID() + " ���������� ����Ǿ����ϴ�.");
			}
			else
			{
				System.out.println(p[i].getProductID() + " ������ ID�� ��ǰ�� �̹� ����Ǿ����ϴ�.");
			}
		}*/
		
		
		for(Product plist:p)
		{
			if(hs.add(plist))
			{
				System.out.println(plist.getProductID() + " ���������� ����Ǿ����ϴ�.");
			}
			else
			{
				System.out.println(plist.getProductID() + " ������ ID�� ��ǰ�� �̹� ����Ǿ����ϴ�.");
			}
		}
		
		System.out.println();
		System.out.println(String.format("%-10s\t%-10s\t%-10s\t", "��ǰID", "��ǰ��", "����"));
		System.out.println("==========================================");
		
		for(Product plist : hs)
		{
			System.out.println(plist);
		}
	}

}
