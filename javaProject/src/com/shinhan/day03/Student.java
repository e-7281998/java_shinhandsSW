package com.shinhan.day03;

public class Student {

	//문장을 그냥 쓰는 것은 불가.
	
	// 1. field(변수, 송성, 특징)
	String name;
	String stdId;
	String subject;
//	private int score;
	int score;

	// 2. Constructor(생성자) ...Compile시에 자동으로 default 생성자가 제공된다.
	// 정의가능하다.
	Student() { // default 생성자
		System.out.println("3. default생성자에 의해 Strudent가 만들어짐");
	}

	// 생성자가 다음과 같이 정의되면 default생성자가 만들어지지 않는다.
	// 그러므로 생성자의 Overloading...이름은 같고 매개변수 사양이 다르다.
	//*매개변수 사양이 같으면 만들 수 없음
	Student(String name, String stdId, String subject, int score) {
		System.out.println("arg4개 생성자에 의해 ");
		// 멤버변수(field)와 매개변수(argument)가 충돌되므로 구별 필요.
//		name = name;
//		stdId = stdId;
//		subject = subject;
//		score = score;

		// 이 클래스로 만든 현재객체를 this라고 한다. (내가: 호출한 애)
		this.name = name;
		this.stdId = stdId;
		this.subject = subject;
		this.score = score;
	}

	// 3. 일반 메서드(행위)
	void study() {
		System.out.println(name + "학생이 공부합니다.");
	}

	// 4. block(instance block - 생성시마다 수행, static block - load시 1회 수행)
	{	//주로 사용 안 함. 왜? 생성자에서 하면 되니까 굳이.,.,?
		System.out.println("2. instance block");
	}
	static {
		System.out.println("1. static block");
	}

	// 5. inner class
	class InnerClass {

	}

}
