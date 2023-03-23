package com.shinhan.day09;

//멀티 스레드 만드는 방법
//1. 상속 : extends Thread... run() 메서드 재정의
public class MyThread1 extends Thread{
	public MyThread1() {
	}
	
	public MyThread1(String threadName) {
		super(threadName);	//스레드 이름 저장하기 : Thread에 기본으로 있음
	}

	@Override
	public void run() {
//		super.run();
		for(int i=1; i<=26; i++) {
			//내가 스레드이므로(상속 받았으므로)
			// Thread.currentThread(). 생략해도 됨
			System.out.println("[" + getName() +"] i: " + i);
		}
	}
	
}
