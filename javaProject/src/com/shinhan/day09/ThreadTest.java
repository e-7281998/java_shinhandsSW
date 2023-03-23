package com.shinhan.day09;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("스레드 이름 : " + Thread.currentThread().getName() + "....시작");

		//스레드 사용하기	
		//MyThread1 t1 = new MyThread1();
		//MyThread는 Thread 상속 받았으므로 다음과 같이 부모 클래스로 받을 수 있음
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		
		Runnable r = new MyThread3();	//Runnable은 스레드 아니므로 Runnable로 받고,
		Thread t3 = new Thread(r);		//스레드에 다시 담아줘야 함.
		
		//스레드가 run을 수행하도록 한다.
		t1.start();		//.start로 run을 실행하는 것임
		t2.start();
		t3.start();
		
		for(int i= 100; i<= 110; i++) {
			System.out.println(Thread.currentThread().getName() + i + "!!!!");
		}
		
		System.out.println("스레드 이름 : " + Thread.currentThread().getName() + "....끝");
	}

	private static void f2() {
		System.out.println("스레드 이름 : " + Thread.currentThread().getName() + "....f2");
		for(int i=1; i<=26; i++) {
			System.out.println(Thread.currentThread().getName() +" ) i: " + i);
		}
	}

	private static void f1() {
		System.out.println("스레드 이름 : " + Thread.currentThread().getName() + "....f1");
		for(char i='A'; i<='Z'; i++) {
			System.out.println(Thread.currentThread().getName() +" ) i: " + i);
		}

	}
}
