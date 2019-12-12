package day7;

class StudentNew{
	String name;
	int age;
	String subject;
	
	StudentNew(String p1, int p2, String p3)
	{
		name = p1;
		age = p2;
		subject =p3;
	}
	
	void printStudentInfo()
	{
		System.out.println(name +"학생은 나이가 " + age + "입니다.");
	}
	
	void study()
	{
		System.out.println(name + "학생은 " + subject + "과목을 학습합니다.");
	}
	
	void study(int hour)
	{
		System.out.println(name + "학생은 " + subject + "과목을 " + hour +"시간 동안 학습합니다.");
	}
}


public class StudentTest2 {

	public static void main(String[] args) {
		StudentNew st1 = new StudentNew("듀크", 20, "리눅스");		
		System.out.println(st1); //생성된 객체의 참조값 (어떤객체@참조값)
		st1.study(2);
		
		StudentNew st2 = new StudentNew("둘리", 100, "스칼라");		
		System.out.println(st2); //생성된 객체의 참조값 (어떤객체@참조값)
		st2.study(2);
	}

}


