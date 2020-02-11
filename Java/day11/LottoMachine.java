package day11;

import java.util.Random;

class DuplicatException extends Exception {
	DuplicatException(){
		super("중복된 로또 번호가 발생했습니다.");
	}
}

public class LottoMachine {

	private int[] nums;
	
	LottoMachine() {
		nums = new int[6];
	}
	
	void createLottoNums() {
		
		for(int i = 0; i < 6; i++) {
			nums[i] = new Random().nextInt(20) + 1;
		}
	}
	
	void checkLottoNums() throws DuplicatException {

		for(int i = 0; i <5; i++)
		{
			for(int j = i; j <5; j++)
			{
				if(nums[i] == nums[j+1])
				{
					throw new DuplicatException();
				}
			}
		}
		
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}
	
	
}
