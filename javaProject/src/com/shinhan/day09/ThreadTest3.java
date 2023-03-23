package com.shinhan.day09;

public class ThreadTest3 {
	public static void main(String[] args) {
		System.out.println("mian Thread start~~~~");
		
		//스레드 이름 주기
		Thread t1 = new MyThread1("숫자 출력 스레드");	//스레드 생성자 따로 만들어줘야 함
		Thread t2 = new MyThread2("대문자 출력 스레드");
		
		Runnable r = new MyThread3();
		Thread t3 = new Thread(r);
		t3.setName("소문자 출력 스레드");	//runnable 스레드 이름 넣기
		
		//스레드의 상태를 알 수 있음 : 현재 NEW
		System.out.println(t1.getState().name());	
		System.out.println(t2.getState());
		System.out.println(t3.getState().name());	
		
		t1.start();
		t2.start();
		t3.start();
		
		//스레드의 상태를 알 수 있음 : 현재 RUNNABLE
		System.out.println(t1.getState().name());	
		System.out.println(t2.getState());
		System.out.println(t3.getState().name());	
		
		System.out.println("mian Thread end....");
	}
}
