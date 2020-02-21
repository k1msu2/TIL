package model.vo;

public class ProductVO {
	private int appleNum;
	private int bananaNum;
	private int halabongNum;
	
	public ProductVO() {
		this.appleNum = 0;
		this.bananaNum = 0;
		this.halabongNum = 0;
	}
	public int getAppleNum() {
		return appleNum;
	}
	public void setAppleNum() {
		this.appleNum += 1;
	}
	public int getBananaNum() {
		return bananaNum;
	}
	public void setBananaNum() {
		this.bananaNum += 1;
	}
	public int getHallabongNum() {
		return halabongNum;
	}
	public void setHallabongNum() {
		this.halabongNum += 1;
	}
	
	
}
