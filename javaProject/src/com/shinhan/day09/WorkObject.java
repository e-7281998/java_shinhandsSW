package com.shinhan.day09;

//공유영역
public class WorkObject {
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "작업A 실행....");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "작업B 실행....");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
