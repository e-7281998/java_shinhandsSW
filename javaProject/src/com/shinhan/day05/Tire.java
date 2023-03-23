package com.shinhan.day05;

//abstract class: 추상 클래스 : 추상 메서드가 1개 이상 있다.
//추상 클래스 안에는 반드시 추상 메서드가 있다. 
public abstract class Tire {

	//추상메서드 : 정의는 있고 구현 { }은 없다.
	//구현은 상속받은 자식클래스가 반드시 한다. (override 의무)
	//override하려면 부모보다 접근자가 넓어야 한다.
	//부모를 통해 자식을 보기 위해 만듬
	public abstract void roll();
//	public abstract void roll() { };	//불가 : { } 구현이 있다. abstract(추상)이 존재하면 구현하면 안됨. 구현은 자식만 가능
	
	void f1() {
		System.out.println("타이어 클래스의 f1 메서드");
	}
	
	void f2() {
		System.out.println("타이어 클래스의 f1 메서드");
	}
}
