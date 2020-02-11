package day11;
import java.util.Random;
interface Drawable {
	 //public abstract void draw(); // 인터페이스 안에 메서드는 바디가 없음
	void draw();
}
class Rect implements Drawable {
	public void draw() { // 오버라이딩
		System.out.println("사각형을 그립니다.");
	}
}
class Circle implements Drawable {
	public void draw() { // 오버라이딩
		System.out.println("원을 그립니다.");
	}
}
class Diamond implements Drawable  {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}
public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null;
		if(num == 0)
			d= new Rect();
			//d = () -> System.out.println("사각형을 그립니다."); // 람다식 - spark에서 사용
		else if(num == 1)
			d = new Circle();		
		else if(num == 2)
			d = new Diamond();		
		output(d);
	}
	public static void output(Drawable d){
		System.out.println("전달된 객체의 클래스명 : "+
	                        d.getClass().getName());
		d.draw();
	}
}



