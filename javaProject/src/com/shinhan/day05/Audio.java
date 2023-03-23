package com.shinhan.day05;

//interface를 구현한 클래스
public class Audio implements RemoteControl, Wifi{	//다중 인터페이스

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName()+"오디오가 전원켠다.");
	}

	@Override
	public void display() {
		RemoteControl.super.display();	//부모에 있는 것 실행
		System.out.println("default 메서드 재정의");
	}
	
	//override아님. 이름만 똑같은 것임.
	//호출하려면 Audio타입이라고 따로 정해야 가능.
	void display2(){
		System.out.println("!!!!!!!!!");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName()+"오디오가 전원끈다.");		
	}

	@Override
	public void wifiTurnOn() {
		System.out.println("wifi turn on!!");
	}
	
}
