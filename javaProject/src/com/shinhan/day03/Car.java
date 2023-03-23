package com.shinhan.day03;

//class : 설계도. object 만드는 틀
//object : class를 이용해서 만든 독립된 개체(실체 instance)
public class Car {
	//1. field (속성, 멤버변수)
	String model;
	String color;
	int price;
	
	//2. 생성자메서드 (생성시 초기화가 목적)
	//컴파일시에 자동으로 .class에 파라메터가 없는 default생성자가 만들어진다.
	//즉, 생성자를 정의하는 것은 필수가 아니다.
	//생성자 정의하면 default 생성자가 자동으로 만들어지지는 않는다.
	//public이 들어가야 다른 패키지에서 생성자를 사용할 수 있다.
	//생성자는 return 정의가 없다.
	//클래스와 같은 이름이어야 한다.
	public Car(){
		System.out.println("3.Car의 default생성자");
	}
	
	//3. 일반메서드 (method, 기능, 동작)
	void go() {
		System.out.println("메서드 호출 : 자동차가 간다.");
	}
	//4. block (instance block, static block)
	//{}중괄호가 있으면 블럭이다.
	
	{
		System.out.println("2.instance block ... 생성시마다 실행");
	}
	static {
		//staic이 가장 먼저만들어짐
		System.out.println("1.static block ... class가 로드시 한번 수행");
	}
	
	
	//5. inner class
}
