package com.shinhan.day05;

//abstract class : 변수 + 상수 + 생성자 + 일반메서드 + 추상메서드
//규격서 : 상수 + 추상메서드 + (default 메서드 + static 메서드 + pravate 메서드)
public interface RemoteControl {
	
	//public abstract는 생략 가능
	public abstract void powerOn();
	
	void powerOff();
	
	//모든 구현 클래스에서 사용 가능
	//재정의 가능
	default void display() {
		System.out.println("모든 구현 클래스에 기능 추가");
	}
	
	//모든 구현 클래스에서 사용 가능
	//재정의 불가능
	static void dispay2() {
		System.out.println("재정의 불가!! 모든 구현 클래스에 기능 추가");
	}
}
