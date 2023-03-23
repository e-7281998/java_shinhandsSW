package com.shinhan.day05;

//interface를 구현한 클래스
public class Television implements RemoteControl{

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName()+"전원켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName()+"전원끈다.");		
	}
	
}
