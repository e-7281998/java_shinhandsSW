package com.shinhan.day09;

//멀티 스레드 만드는 방법
//1. 상속 : extends Thread... run() 메서드 재정의
public class MyThread2 extends Thread{
	
	public MyThread2() {
		
	}
	
	public MyThread2(String threadName) {
		super(threadName);
	}

	@Override
	public void run() {
//		super.run();
		for(char i='A'; i<='Z'; i++) {
			System.out.println("[" + getName() +"] i: " + i);
		}
	}
	
}
