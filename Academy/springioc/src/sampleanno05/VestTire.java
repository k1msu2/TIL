package sampleanno05;

import org.springframework.stereotype.Component;

// 객체를 생성할 만한 클래스는 @Component
@Component // name = vestTire
public class VestTire implements Tire{

	public VestTire() {
		System.out.println("VestTire - Create object");
	}
	@Override
	public String getBrand() {
		return "MICHELIN Tire!!";
	}
}
