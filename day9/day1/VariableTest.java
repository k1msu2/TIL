package day1;

public class VariableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1+2+3+4+5+10);
		System.out.println(1+2+3+4+5-10);
		System.out.println(1+2+3+4+5*10); // ���� ���� ���������� �켱���� ���
		System.out.println(1+2+3+4+5/10);

		int result = 1+2+3+4+5;
		System.out.println(result+10);
		System.out.println(result-10);
		System.out.println(result*10);
		System.out.println(result/10);
		
		char munja = 'A'; // "A" �Ұ�, 0x41(16����), 65
		System.out.println(munja);
		System.out.println(munja+munja); //
		System.out.println(""+ munja+munja); //"":�ι��ڿ�
		System.out.println(munja+munja+""); //"":�ι��ڿ�
		
	}

}
