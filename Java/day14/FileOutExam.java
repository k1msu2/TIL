package day14;

import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

public class FileOutExam {

	public static void main(String[] args) {
		
		// �����  = 0
		final char days[] = {' ', '��', '��', 'ȭ', '��', '��', '��', '��'};
		
		GregorianCalendar gc1 = new GregorianCalendar();
		GregorianCalendar gc2 = new GregorianCalendar(2019, 11, 20); // month - 1
		
		int year = gc1.get(GregorianCalendar.YEAR);
		int month = gc1.get(GregorianCalendar.MONTH) + 1;
		int date = gc1.get(GregorianCalendar.DATE);
		char dayOfWeek = days[gc1.get(GregorianCalendar.DAY_OF_WEEK)];
			
		String line1 = String.format("������ %d�� %d�� %d���Դϴ�.", year, month, date);
		String line2 = String.format("������ %c�����Դϴ�.", dayOfWeek);
		String line3 = String.format("%s�� %c���Ͽ� �¾���ϴ�.","��", 
				days[gc2.get(GregorianCalendar.DAY_OF_WEEK)]);
	
		try (FileWriter  writer = new FileWriter("c:/iotest/output2.txt");){       
			writer.write(line1);
			writer.write("\r\n");
            writer.write(line2);
            writer.write("\r\n");
            writer.write(line3);
            writer.write("\r\n");
            System.out.println("���Ͽ� ��� �Ϸ�!!");
        } catch (IOException ioe) {
            System.out.println("���Ϸ� ����� �� �����ϴ�.");
        } 	
		
	}

}
