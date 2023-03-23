package com.shinhan.day04;

//class: public 또는 생략
//=========================
//public 
//protected : 같은 패키지 접근 가능, 다른패키지는 상속받으면 가능
// private : 같은 클래스 내에서만 가능
// default: 같은 패키지만 가능
//=========================
public class Phone {
	// 1. field : public/protected/생략/private

//	String model;	//같은 클래스만 접근 가능
	public String model;
	protected int price;

	// 2. 생성자 : public / 생략/private
//	private Phone() {
//		// TODO Auto-generated constructor stub
//	}
	public Phone() {
		// TODO Auto-generated constructor stub
	}

	// 3. 메서드
	public void f1() {

	}

	protected void f2() {

	}

	void f3() {

	}

	private void f4() {

	}

}

//day04에서만 사용 가능
//class Phone {
//
//}