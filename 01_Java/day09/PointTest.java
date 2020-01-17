package day09;
class Point {
	int x;	
	int y;
	
	Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}
	String getLocation() {
		return "x :" + x + ", y :"+ y;
	}
}
class Point3D extends Point {
	int z;
	
	Point3D(int x, int y, int z) {	
		super(x, y); // 아규먼트가 있는 생성자를 상속받기 때문에 조상의 멤버변수에 매개변수를 전달한다. super를 호출해서 전달.
		//this.x = x;
		//this.y = y;
		this.z = z;
	}
	String getLocation() {	// 오버라이딩, 이름과 매개변수가 같을 때 , 리턴값의 유형이 달라지면 에러
		return super.getLocation() + ", z :" + z;
	}	
}
public class PointTest {
	public static void main(String args[]) {
		Point3D p3 = new Point3D(1,2,3);	
		
		
		System.out.println(p3.getLocation());
	}
}













