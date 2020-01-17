package day13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMapLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<>();
		String country = "";
		int population = 0;
		
		while(true)
		{
			System.out.print("�����̸��� �Է��ϼ��� : ");
			country = sc.next();
			System.out.print("�α� ���� �Է��ϼ��� : ");
			population = sc.nextInt();
			
			if(hm.containsKey(country))
			{
				System.out.println("����� " + country +"�� �̹� ����Ǿ����ϴ�.");
			}
			else
			{
				hm.put(country,population);
			}
			
			
			if(hm.size() == 5)
				break;
		}
		
		System.out.println("5���� ��� �ԷµǾ����ϴ�.");
		System.out.print("�Էµ� ������ : ");

		Iterator<String> mapIter = hm.keySet().iterator();
		String key = "";
		while(true)
		{
			key = mapIter.next();
			System.out.print(key + "(" + hm.get(key) + ") ");
			
			if(mapIter.hasNext())
			{
				System.out.print(",");
			}
			else
			{
				break;
			}
		}
		
		System.out.println("=================Type1=================");
		
		Iterator<String> i1 = hm.keySet().iterator();
		while(i1.hasNext())
		{
			String k1 = i1.next();
			Integer v1 = hm.get(k1);
		}
		
		System.out.println("=================Type2=================");

		for(Map.Entry<String, Integer> elem : hm.entrySet())
		{
			String k2 = elem.getKey();
			Integer v2 = elem.getValue();
		}
		
		System.out.println("=================Type3=================");
		
		for(String k3 : hm.keySet())
		{
			Integer v3 = hm.get(k3);
		}
		
		sc.close();

	}

}

