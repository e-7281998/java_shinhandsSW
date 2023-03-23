package com.shinhan.day09;

//멀티 스레드 만드는 방법
//1. 상속 : extends Thread... run() 메서드 재정의
//2. 이미 부모 클래스를 상속받고 있다면 Runnable interface 구현한다.
//다중상속은 불가하기 때문에 
public class MyThread3 extends Object implements Runnable{
//Runnable는 interface임 : 추상 메소드 run()을 반두시 구현할 의무가 있음


	@Override
	public void run() {
		for(char i='A'; i<='Z'; i++) {
			//Runnable interface은 스레드가 아니지만 스레드로 사용하는 것임
			//때문에 Thread.currentThread()을 생략할 수 없음
			System.out.println("[" + Thread.currentThread().getName() +"] i: " + i);
		}
	}
	
}
