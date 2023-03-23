package com.shinhan.day04;

//자바의 최상위 class (최상위 부모) : Object (toString, equals,,,)
//모든 클래스는 object를 물려받음.
public class Duck {
	String name;
	int legs;
	int length;
	
	
	public Duck(String name, int legs, int length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}

	void fly() {
		System.out.println("오리("+name+")는 날지 않습니다.");
	}
	
	void sing() {
		System.out.println("오리("+name+")는 소리내어 웁니다.");
	}

	public void setName(String name) {
		this.name = name;
	}
	
	void display() {
		System.out.println("오리의 이름은 "
				+ name
				+ " 입니다. 다리는 "
				+ legs
				+ "개이고 길이는 "
				+ length
				+ "입니다.");
	}
	
	//override (덮어쓰기, 재정의) : 이미 가지고 있는 기능을 재정의한다.
	//이름, 매개변수, return 모두 같아야 한다.
	//단, 접근제한자는 같거나 더 넓어져야한다.
	//public > procected :같은 패키지는 가능, 다른 패키지는 상속 > 생략 : 같은 클래스만 > private
	
	
	
	//불가 : 접근제한자가 더 좁아짐
//	String toString() {	
//		return null;
//	}
	//오버라이딩이 아니라 새로운 메소드임 : 매개변수가 달라짐
//	public String toString(int a) {
//		return null;
//	}
	
	//source에서 생성 가능
	@Override
	public String toString() {
		return "Duck [name=" + name + ", legs=" + legs + ", length=" + length + "]";
	}

}
