package day1;

public class VariableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1+2+3+4+5+10);
		System.out.println(1+2+3+4+5-10);
		System.out.println(1+2+3+4+5*10); // 왼쪽 부터 순차적으로 우선순위 계산
		System.out.println(1+2+3+4+5/10);

		int result = 1+2+3+4+5;
		System.out.println(result+10);
		System.out.println(result-10);
		System.out.println(result*10);
		System.out.println(result/10);
		
		char munja = 'A'; // "A" 불가, 0x41(16진수), 65
		System.out.println(munja);
		System.out.println(munja+munja); //
		System.out.println(""+ munja+munja); //"":널문자열
		System.out.println(munja+munja+""); //"":널문자열
		
	}

}
