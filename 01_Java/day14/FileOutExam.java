package day14;

import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

public class FileOutExam {

	public static void main(String[] args) {
		
		// 토요일  = 0
		final char days[] = {' ', '일', '월', '화', '수', '목', '금', '토'};
		
		GregorianCalendar gc1 = new GregorianCalendar();
		GregorianCalendar gc2 = new GregorianCalendar(2019, 11, 20); // month - 1
		
		int year = gc1.get(GregorianCalendar.YEAR);
		int month = gc1.get(GregorianCalendar.MONTH) + 1;
		int date = gc1.get(GregorianCalendar.DATE);
		char dayOfWeek = days[gc1.get(GregorianCalendar.DAY_OF_WEEK)];
			
		String line1 = String.format("오늘은 %d년 %d월 %d일입니다.", year, month, date);
		String line2 = String.format("오늘은 %c요일입니다.", dayOfWeek);
		String line3 = String.format("%s는 %c요일에 태어났습니다.","나", 
				days[gc2.get(GregorianCalendar.DAY_OF_WEEK)]);
	
		try (FileWriter  writer = new FileWriter("c:/iotest/output2.txt");){       
			writer.write(line1);
			writer.write("\r\n");
            writer.write(line2);
            writer.write("\r\n");
            writer.write(line3);
            writer.write("\r\n");
            System.out.println("파일에 출력 완료!!");
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } 	
		
	}

}
