package com.shinhan.day10;

//Thread.start()하면 run()이 호출된다.
//1. Thread 상속
class MyThreadA extends Thread{
	String name;
	
	MyThreadA(String name){
		super(name);
	}

	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(getName() + " : " + i);
			try {
//				Thread.sleep(500);	
				sleep(500);	//sleep은 static이므로 위와 같다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

//2. 이미 상속중이라면 Runnable interface 구현
class MyThreadB extends Object implements Runnable{

	@Override
	public void run() {
		for(int i=11; i<=20; i++) {
			System.out.println(Thread.currentThread().getName()+ " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class Review {
	public static void main(String[] args) {
		Thread t1 = new MyThreadA("스레드A");
		Thread t2 = new Thread(new MyThreadB());
		
		Thread t3 = new Thread() {
			public void run() {
				for(int i=100; i<=110; i++) {
					System.out.println(getName() + " : " + i);
					try {
						sleep(500);	//sleep은 static이므로 위와 같다
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				for(int i=200; i<=210; i++) {
					System.out.println(Thread.currentThread().getName()+ " : " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
