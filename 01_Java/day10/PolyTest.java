package day10;

public class PolyTest {

	public static void main(String[] args) {
		printObjectInfo(new Object());
		printObjectInfo(new String("������"));
		printObjectInfo("ABC");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:\\Temp"));
		printObjectInfo(new int[10]);
		printObjectInfo(new double[5]);
		printObjectInfo(new day07.Member()); // public Ŭ���� ���� ����
		printObjectInfo(new Integer(100));
		printObjectInfo(100);
		printObjectInfo('��');
		
		char c = '��';
		printObjectInfo(c);
		}
	
	static void printObjectInfo(Object o) {
	
		
		if(o instanceof String) // �� ��ȯ �������� Ȯ���ϴ� ������ instanceof
		{
			System.out.println("���ڿ� ��ü ���޵�: " + o.getClass().getName() + "-" +((String) o).length() + "-" +((String) o).toLowerCase());
		}
		else
		{
			System.out.println("���޵� ��ü�� Ŭ������ : " + o.getClass().getName());		
		}
		
	}
}
