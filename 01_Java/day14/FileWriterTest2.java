package day14;
import java.io.*;
public class FileWriterTest2 {
    public static void main(String args[]) {      
        try (FileWriter  writer = new FileWriter("c:/iotest/output2.txt");){         
            char arr[] = { '객', '체', '지', '향', '언', '어', 'J', 'a', 'v', 'a' };          
            for (int cnt = 0; cnt < arr.length; cnt++)
                writer.write(arr[cnt]);
            writer.write('\n');
            writer.write(arr);
            writer.write('\n');
            writer.write("OCJP 시험 대비!!");
            writer.write('\n');  
            System.out.println("파일에 출력 완료!!");
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } 
        // 객체 생성을 try catch 가 끝나는 시점에서 자동 클로즈하기 위해 () 안에 해줌
        // Java 5부터 추가된 구문
    }
}
