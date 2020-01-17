package day11;

public class RentalTV extends TV implements Rentable{

	int price;
	
	RentalTV(){}
	RentalTV(int price, String model, int size, int channel){
		super(model, size, channel);
		this.price = price;
	}
	
	public void play() {
		System.out.printf("�뿩 TV ä�� %d����  ���θ� �÷��� �մϴ�.\n", super.getChannel());
	}
	public void rent() {
		System.out.printf("%s ���� ��ǰ�� �뿩�մϴ�. %,d �� ������ �ּ���.\n", super.getModel(), getPrice());
	}
	
	public String toString() {
		return String.format("�뿩��ǰ���� : �𵨸�(%s), ����(%,d��), ũ��(%d)", super.getModel(), getPrice(), super.getSize());
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
