package com.shinhan.day03;

public class ComputerTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		System.out.println("생성된 컴퓨터 개수: "+ Computer.count);	//클래스 변수이기 때문에 인스턴스 생성전에 사용 가능하다.

		Computer com1 = new Computer();
		Computer com2 = new Computer("삼성");
		Computer com3 = new Computer("window", 1000);
		Computer com4 = new Computer("LG","linux", 2000);
		
//		System.out.println("생성된 컴퓨터 개수: "+ com1.count);
//		System.out.println("생성된 컴퓨터 개수: "+ com2.count);
//		System.out.println("생성된 컴퓨터 개수: "+ com3.count);
//		System.out.println("생성된 컴퓨터 개수: "+ com4.count);
		//count는 클래스 변수다. 왜 ? static으로 선언되었으므로.
		//때문에 접근할 때 변수.count가 아닌 클래스.count (클래스.static변수) 로 호출해야 한다.
		System.out.println("생성된 컴퓨터 개수: "+ Computer.count);
		
		dispay(com1);
		dispay(com2);
		dispay(com3);
		dispay(com4);
		
		
	}

	private static void dispay(Computer com) {
		System.out.println("============================");
		System.out.println(com.getModel());
		com.computerInfoPrint();
	}

}
