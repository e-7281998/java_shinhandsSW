package com.shinhan.day09;

public class WorkThread extends Thread{

	public boolean work = true;
	
	public WorkThread(String name) {
		//super(name);	//스레드 이름 저장 방법 1
		setName(name);	//스레드 이름 저장 방법 2
	
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName() + " 작업 처리!");
			}else {
				Thread.yield();	//나의 스레드가 잠깐 멈춤... 다른 쓰레드에 양보... 계속 진행
			}
		}
	}

}
