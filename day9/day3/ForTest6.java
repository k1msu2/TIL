package day3;

public class ForTest6 {
	public static void main(String[] args) {
		char munja = 'A';
		for (int n = 1; n<=26; n++)
			System.out.println(munja);
		System.out.println("-----------------");
		for (munja = 'A'; munja<='Z'; munja++)
			System.out.println(munja);
		System.out.println("-----------------");
		munja = 'A';
		for (int n = 1; n<=26; n++) {
			System.out.println(munja);
			munja += 1;
		}
		System.out.println("-----------------");
		munja = 'A';
		for (int n = 1; n<=26; n++) {
			System.out.println(munja);
			munja = (char)(munja+1); // 연산자 우선순위 때문에 
		}
	}
	

}
