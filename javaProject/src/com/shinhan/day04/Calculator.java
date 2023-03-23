package com.shinhan.day04;

//Class : Object를 만들기 위한 틀(설계도)
//Object: class를 이용해 만들어진 실체(instance)
public class Calculator {
	// 1. field (특징, 속성, 변수) : static(class변수), non-static(instance변수)
	private String color;
	private int price;
	private String model;
	static String company = "shinhan"; // static은 메소드 영역에 생성됨

	// 2.생성자(new할 때 자동으로 실행되는 메서드)... compile시 자동으로 default생성자가 제공.
	// 생성자는 초기화가 목적
	// 생성자를 정의하면 default 생서자 제공안됨.
	// this : 이 class를 이용해서 만든 현재객체로 다음의 경우에 사용함.
	// 1. 매개변수 이름과 멤버변수 이름이 충돌=> 구분이 필요 (this.price가 멤버변수임)
	// 2. 하나의 생성자가 다른 생성자를 호출할 때 사용
	// 생성자 overloading : 이름은 같고 매개변수 사양이 다르다.
	Calculator(String color) {
		this(null, color, 0);
	}

	Calculator(String model, String color) {
		this(model, color, 1000);
	}

	Calculator(String model, String color, int price) {
		this.model = model;
		this.color = color;
		this.price = price;
	}

	// 3. method(일반 메소드)... 기능(동사)
	// static, non-static

	// private로 정보은닉되어있는 멤버 변수를 읽는 기능 getter
	// private로 정보은닉되어있는 멤버 변수를 수정하는 기능 setter
	// getter, setter함수 자동만들기
	// : 우클릭 > source (단축키 :alt + shift+s) > Generate Getter and Setter
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	//처음부터 메모리에 올라감
	//static에서는 this사용 불가, instatnce 변수 사용 불가
	public static void powerOn() {
		//static이므로 instance변수를 사용할 수 없다. 
		//System.out.println(color + "," + model + "모델의 계산기 전원을 켠다.");
		System.out.println(company + "회사의 계산기 전원을 켠다.");
	}

	void poweOff() {
		System.out.println(color + "," + model + "모델의 계산기 전원을 끈다.");
	}

	int add(int a, int b) {
		return a + b;
	}

	int sub(int a, int b) {
		return a - b;
	}

	// 4.block (instance, static)
	{
		System.out.println("instance 생성시마다 수행된다."); // new 하기 전에 생성됨
		System.out.println("=================");
	}
	static {
		System.out.println("class load시에 1회 수행됨");
		System.out.println("=================");
	}

	// 5. inner class
	class AA {

	}

}
