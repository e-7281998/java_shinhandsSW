package com.shinhan.day05;

public abstract class KumhoTire extends Tire {
	
	String intro = "최고!!!";
	void method2() {
		System.out.println("금호타이어만 가진당");
	}
	
	@Override
	public void roll() {
		System.out.println("금호 타이어가 굴러간다잉~~~");
	}
}
