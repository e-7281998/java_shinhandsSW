package com.shinhan.day06;

public class AnonymousTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		//익명 클래스
		RemoteControl tv = new RemoteControl(){
			int a = 10;
			public void method() {
				System.out.println("구현 class에서 메서드 추가");
			}

			@Override
			public void turnOn() {
				System.out.println("전원 켠다.");
				method();
			}

			@Override
			public void turnOff() {
				System.out.println("전원 끈다.");
			}
			
		};
		
		//RemoteControl 타입이므로, RemoteControl에 있는 것만 호출 가능
		//a, method1은 호출 불가.
		tv.turnOff();
		tv.turnOn();
		
		
	}

	private static void f3() {
		// 2. 익명 객체
		(new Colorable() {

			@Override
			public void setForeground(String color) {
				System.out.println("익명 포그라운드 :" + color);
			}

			@Override
			public void setBackground(String color) {
				System.out.println("익명 백그라운드 :" + color);

			}
		}).setBackground("green");
	}

	private static void f2() {
		// 2. 익명 객체
		// **나 : 인터페이스의 객체 생성은 안되지만 재정의믄 가능
		// 한번만 쓰고 버리려고
		Colorable a = new Colorable() {

			@Override
			public void setForeground(String color) {
				System.out.println("익명 포그라운드 :" + color);
			}

			@Override
			public void setBackground(String color) {
				System.out.println("익명 백그라운드 :" + color);

			}
		};
		a.setBackground("blue");
		a.setBackground("red");
	}

	private static void f1() {
		// 1. 일반적인 방법
		Book book = new Book();
		book.title = "이것이 자바다";
		book.setForeground("white");
		book.setBackground("black");

		Cup cup = new Cup();
		cup.size = 30;
		cup.setForeground("yellow");
		cup.setBackground("pink");
	}

}
