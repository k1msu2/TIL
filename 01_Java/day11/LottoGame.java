package day11;

public class LottoGame {

	public static void main(String[] args) throws DuplicatException{
		LottoMachine lm = new LottoMachine();
		try {
			
			lm.createLottoNums();
			lm.checkLottoNums();
			int[] nums = lm.getNums();
			int max = nums.length;
			
			for(int i = 0; i < max; i++)
			{
				System.out.print(nums[i] + ( i < (max-1)? ",": ""));
			}
		}catch (DuplicatException e) {
			System.out.println(e.toString());
		}finally {

		}	

	}

}
