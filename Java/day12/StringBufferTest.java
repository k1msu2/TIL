package day12;

public class StringBufferTest {

	public static void main(String[] args) {		
		StringBuffer buffer = new StringBuffer();
		String str = "자바프로그래밍";
     		buffer.append(str);
        System.out.printf("%s\n", buffer);
        //buffer.reverse(); // 스트링 버퍼 자체를 변화시킨다
        System.out.printf("%s\n", buffer);
        System.out.printf("길이 : %d\n", buffer.length());   
        
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append('자'); //거의 모든 타입이 됨
        buffer2.append('바');
        buffer2.append("프");
        buffer2.append("로");
        buffer2.append('그');
        buffer2.append('래');
        buffer2.append('밍');
        
        System.out.println(buffer == buffer2); // object에서 오버로딩
        System.out.println(buffer.equals(buffer2));
        System.out.println(buffer.toString().contentEquals(buffer2));
        System.out.println(buffer.toString().equals(buffer2.toString()));
        
	}
}