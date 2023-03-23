package com.shinhan.day03;

//JavaBeans기술 규격서에 나와있음
//: field는 private(정보은닉) 해야한다고. (외부에서 값을 마음대로 접근할 수 없도록)
//함수는 공개해라 (내부에서 값을 변경해 보여줄 수 있으므로)
public class Computer {
	// 일반적으로는 정보은닉을 한다.(private 함)
	private String model;
	private String os;
	private int price;
	//int count;	//변수:instance 변수, static변수(class변수, object 공유변수)	//아무것도 선언하지 않았으므로 instance변수임. new하면 생성됨
	static int count;	//메소드 영역에 있음. 클래스당 하나 존재함. 공유하는 변수.
	
	// 생성자. 컴파일하면 default 생성자 만들어짐. 초기화 하는 것

	// public이 없어서 다른 패키지에서 사용할 수 없음
	//하나의 생성자가 다른 모양의 생성자를 호출할 수 있다.
	//왜? 그렇지 않으면 중복되는 코드가 많아 유지보수가 어렵다.
	//그러므로 생성자가 가장 많은 친구를 호출하면 된다. this(매개변수)
	Computer() {
		this("AA","mac",500);
//		System.out.println("default 생성자로 생성");
	}

	// 생성자 Overloading : 생성자 이름은 같고 매개변수 사양이 다르다.
	// 다른 패키지에서 사용 가능 : public 있으므로
	public Computer(String model) {
//		System.out.println("arg1 생성자로 생성");
//		this.model = model;
		this(model, null, 0);
	}

	public Computer(String os, int price) {
//		System.out.println("arg2 생성자로 생성");
//		this.os = os;
//		this.price = price;
		this(null, os, price);
	}

	public Computer(String model, String os, int price) {
		System.out.println("arg3 생성자로 생성");
		this.model = model;
		this.os = os;
		this.price = price;
		count++;
	}

	// 일반 메서드
	public void computerInfoPrint() {
		System.out.println("model: " + model);
		System.out.println("os: " + os);
		System.out.println("price: " + price);
	}

	public String getModel() {
		return model;
	}

	public String getOs() {
		return os;
	}

	public int getPrice() {
		return price;
	}

}
