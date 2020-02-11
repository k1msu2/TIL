package day11;

public class ExceptionTest2 {

	public static void main(String[] args) throws InterruptedException{
		System.out.println("수행시작");
		try { // exeption 발생시 중도 스탑! 캐치 블럭 찾으러 감!
			int num1 = Integer.parseInt("가나다");
			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("프로그램 아규먼트를 2개 전달하세요!!");
		}catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌값을 전달하세요!!");
		}catch(NumberFormatException e) { //Exception e 자손유형의 객체는 조상형에 전달 될 수 있다.
			e.printStackTrace();
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!");
		}finally {
			System.out.println("항상수행!!");
		}
		System.out.println("수행종료");
	}
}
