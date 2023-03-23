package com.shinhan.day09;

public class ThreadTest2 {
	public static void main(String[] args) {
		f1();
		System.out.println("main end");
	}

	private static void f1() {
		//Thread를 익명 구현 객체로 만들기	//사용 후 버리기
		//Thread t1 = new MyThread1();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for(char i='A'; i<='Z'; i++) {
					System.out.println("[" + Thread.currentThread().getName() +"] i: " + i);
					try {
						sleep((int)Math.random() * 100);	// 0~ 100ms만큼 쉼	//전체 밑줄이면  : Exception일 것. : 던질 수 없음, 직접 처리해야 함 (try/catch)
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for(int i=1; i<=26; i++) {
					System.out.println("[" + getName() +"] i: " + i);
					try {
						sleep((int)Math.random() * 100);	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(char i='a'; i<='z'; i++) {
					System.out.println("[" + Thread.currentThread().getName() +"] i: " + i);
					try {
						//sleep은 스레드 것이므로 Thread.sleep해야 함
						Thread.sleep((int)Math.random() * 100);	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		//흐름이 네개임 : main , t1, t2, t3
		t1.start();
		t2.start();
		t3.start();
		
	}
}
