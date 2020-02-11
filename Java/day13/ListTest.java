package day13;

import java.util.ArrayList;
import java.util.Iterator;

class CreateList {
	
	public ArrayList<Integer> convertList(int array[])
	{
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int size = array.length;
		
		for(int i = size-1; i >= 0; i--)
		{
			arrList.add(array[i]);
		}
		return arrList;
		
	}
}


public class ListTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		CreateList cl = new CreateList();
		int array[] = {3,4,2,5,2,3,6,7,5,7,9};
		Iterator<Integer> it = null;
		
		arrList = cl.convertList(array);
		it = arrList.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}

}
