package com.shinhan.day05;

//부모 : 추상클래스는 추상 메서드가 존재할 수 있다.
public abstract class Machine {
	
	public int b = 10;
	private int c = 20;
	int a = 30;
	protected int d = 40;
	
	public void f1() {}
	protected void f2() {}
	void f3() {}
	private void f4() {}
	
	//default생성자가 생성되지 않음 : 생성자 재정의해서
	public Machine(int a) {
	}
	
	public void powerOn() {
		
	}
	
	public void powrOff() {
		
	}
	
	//추상 메서드 없어도 추상 클래스 가능인듯...?
	public abstract void work();
}
