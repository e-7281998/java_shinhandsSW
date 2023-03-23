package com.shinhan.day09;

//공유 영역
public class BathRoom {
	boolean isFirst = true;
	public void use(String name) {
		synchronized (this) {	
			if(isFirst && name.equals("탬")) {
				try {
					//notify(), notifyAll()에 의해 신호오기전까지 
					wait();	//일시정지상태로 간다.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			isFirst = false;
			//이 객체의 공유 영역을 사용하고 있을 때 건들 ㄴㄴ
			System.out.println(name +"이 입장한다.");
			System.out.println(name +"이 사용한다.");
			System.out.println(name +"이 퇴장한다.");
			System.out.println("================");	
			//자고 있는 스레드 다 깨워랏
			notifyAll();	//신호를 보낸다 : waite() 상태에 있는 Thread가 실행대기상태(Runnable)로 간다.
		}	
	}
	
	//전체 동기화
	/*
	public synchronized void use(String name) {
		System.out.println(name +"이 입장한다.");
		System.out.println(name +"이 사용한다.");
		System.out.println(name +"이 퇴장한다.");
		System.out.println("================");
	}
	*/
	
}
