package day2;

public class OperTest2 {

	public static void main(String[] args) {
			int ivalue;
			char cvalue;
			double dvalue;
			boolean bvalue;
			
			ivalue = 100;
			cvalue = 'A';
			dvalue = 3.14;
			bvalue = true;
			
			System.out.println(ivalue);
			System.out.println(cvalue);
			System.out.println(dvalue);
			System.out.println(bvalue);
			
			ivalue = cvalue;
			System.out.println(ivalue); //65
			
			ivalue = (int)dvalue; // 강제로 변환은 큰 데이터를 작은 데이터로 바꿀때, 자동은 값이 손실되지 않는 범위에서만 지원
			
	}

}
