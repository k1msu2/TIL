package day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class LottoMachine2 {

	public static void main(String[] args) {
		Random rand = new Random();
		int num;
		HashSet<Integer> hs = new HashSet<>();
		
		/*
		while(true)
		{
			num = rand.nextInt(21) + 10;
			hs.add(num);
			if(hs.size()==10)
				break;
		}*/
		
		while(hs.size() != 6)
		{
			hs.add(rand.nextInt(45)+1);
		}
		//System.out.println("오늘의 로또 번호 : " + hs.toString());
		System.out.println(hs);
		/*
		Iterator<Integer> iter = hs.iterator();
		while(iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		*/
		
	}

}
