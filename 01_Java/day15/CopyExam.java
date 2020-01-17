package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyExam {
	public static String timeToStrDate(long time) {
		DateFormat formatter = 
				new SimpleDateFormat("yyyy_MM_dd");
		return formatter.format(time);
	}
	
	public static String fileName(String str)
	{
		return String.format("c:/iotest/%s_%s.txt", "sample", str);
	}
	public static void main(String[] args) {
		FileReader reader = null; // 기반 스트림
		BufferedReader br = null; // 보조 스트림
		BufferedWriter bw = null;
		String time = null;
		FileWriter fw = null;
		

		try{
			reader = new FileReader("c:/iotest/sample.txt");
			br = new BufferedReader(reader);
			time = timeToStrDate(new Date().getTime());
			fw = new FileWriter(fileName(time),true);

			while(true)
			{
				String data = br.readLine();
				if(data == null) break;
				fw.write(data + '\n');
				//bw.write(data);
				//bw.newLine();
			}

			System.out.println("저장 완료되었습니다.");
		}catch(Exception e){ //IOException
			System.out.println("처리하는 동안 오류가 발생했습니다" + e.getMessage());
		}finally {
			try {
				if (fw != null) 
					fw.close();
				if (br != null)
					br.close();
				if (reader != null) 
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}


	}

}
