package com.shinhan.day05;

// 자식도 추상클래스가 되면 오버라이드하지 않아도 됨.
//public abstract class Computer extends Machine{
//
//}

//자식은 
public class Computer extends Machine {
	public Computer(int a) {
		// 부모에게 default 생성자가 없음.
		// 왜 ? 생성자를 재정의해서
		// 때문에 super()를 반드시 해줘야 함.
		super(a);

	}

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

}