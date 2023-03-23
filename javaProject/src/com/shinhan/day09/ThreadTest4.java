package com.shinhan.day09;

import com.shinhan.day05.Account;

public class ThreadTest4 {
	public static void main(String[] args) throws InterruptedException {
//		f1();	//yield 연습
//		f2();	//join test
//		f3();	//동기화
//		f4();	//동기화 Calculator
//		f5();
//		f6();	//wait, notify
//		f7();
//		f8();
//		f9();
		f10();	
	}
	
	private static void f10() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true);	//main Thread 종료시 데몬이 종료
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main end");
	}

	private static void f9() {
		SafeThread t1 = new SafeThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
	}
	
	private static void f8() {
		SafeThread t1 = new SafeThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
	}

	private static void f7() {
		SafeThread t1 = new SafeThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.setStop(true);
//		t1.stop()// 사용하지 않는 것이 좋다 : 위험함 : 위 코드로 사용하기
	}

	//Thread에서 다른 Thread에 신호 보내기 : wait(), notify();
	private static void f6() {
		WorkObject obj = new WorkObject();
		ThreadA t1 = new ThreadA(obj);
		ThreadB t2 = new ThreadB(obj);
		t1.start();
		t2.start();
	}

	private static void f5() {
		ShareArea share = new ShareArea(
				new Account("123456", "성춘향", 1000),
				new Account("454545", "이몽룡" , 2000));
		TransferThread t1 = new TransferThread(share);
		PrintThread t2 = new PrintThread(share);
		t1.start();
		t2.start();
	}

	private static void f4() {
		User1Thread t1 = new User1Thread();
		User2Thread t2 = new User2Thread();
		
		//2개의 스레드가 공유하는 공유 영역이다.
		Calculator cal = new Calculator();
		t1.setCalculator(cal);
		t2.setCalculator(cal);
		
		t1.start();
		t2.start();
	}

	//동기화 (공유 영역을 하나의 스레드가 사용중일 때 다른 스레드가 접근 금지)
	private static void f3() {
		BathRoom bathRoom = new BathRoom();
		BathThread t1 = new BathThread(bathRoom, "탬");
		BathThread t2 = new BathThread(bathRoom, "쫑");
		BathThread t3 = new BathThread(bathRoom, "밍");
		BathThread t4 = new BathThread(bathRoom, "밤");
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	//join test
	private static void f2() {
		SumThread t1 = new SumThread(1, 50);
		SumThread t2 = new SumThread(51, 100);
		t1.start();
		t2.start();
		
		//여러 흐름으로 나누어져있을 때, 다 끝나고 나서 사용해야 할 때
		try {
			//만나서 내려가고 싶음	
			t1.join();	//없으면 비동기로 처리됨. 다음 문장 : t1.getSum() 에서 0이 출력되어버림 : 계산이 끝나지않아도 실행해서
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		System.out.println(t1.getSum() + t2.getSum());
		System.out.println("main 끝");
	}
	
	//yield 연습
	//InterruptedException : 프로그램 중단 에러?
	private static void f1() throws InterruptedException {
		WorkThread t1 = new WorkThread("[스레드A]");
		WorkThread t2 = new WorkThread("[스레드B]");
		
		t1.start();
		t2.start();
		
		//5초간 일시정지
		Thread.sleep(5000);	//단위 ms
		//t1의 work를 false...t1스레드가 다른 스레드에 양보.
		t1.work = false;
		//10초 후
		Thread.sleep(10000);
		// work를 다시 true
		t1.work = true;
		
	}
}
