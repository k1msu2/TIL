package day11;

public class SaleTV extends TV{
	int price;
	
	SaleTV(){}
	SaleTV(int price, String model, int size, int channel){
		super(model, size, channel);
		this.price = price;
	}
	
	public void play() {
		System.out.printf("�Ǹ� TV ä�� %d����  ���θ� �÷��� �մϴ�.\n", super.getChannel());
	}
	public void sale() {
		System.out.printf("%s ���� ��ǰ�� �Ǹ��մϴ�. %,d �� ������ �ּ���.\n", super.getModel(), getPrice());
	}
	
	public String toString() {
		return String.format("�ǸŻ�ǰ���� : �𵨸�(%s), ����(%,d��), ũ��(%d)", super.getModel(), getPrice(), super.getSize());
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
