package day05;

public class TwoArrayTest2 {

	public static void main(String[] args) {
		int[][] twoA = {{1,2,3}, {4,5,6}, {7,8,9}}; // 3행3열
		
		System.out.println(twoA);
		System.out.println(twoA[0]); // 참조값
		System.out.println(twoA[0][0]); //값
		
		// 2차원 배열은 이중포문 사용
		for(int row = 0; row <twoA.length; row++) {
			for(int col = 0; col < twoA[row].length; col++) {
				System.out.print(twoA[row][col] + "\t");
			}
			System.out.println();
		}
	}

}
