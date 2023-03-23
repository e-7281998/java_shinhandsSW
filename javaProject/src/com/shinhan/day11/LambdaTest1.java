package com.shinhan.day11;

public class LambdaTest1 {
	public static void main(String[] args) {
		f5();
	}

	private static void f5() {
		Calculable2 f = (a, b) -> a + b;
		Calculable2 f3 = (a, b) -> {
			System.out.println("더하는중");
			return a + b;
		};
		Calculable2 f2 = new Calculable2() {
			@Override
			public int calculate(int x, int y) {
				return x + y;
			}
		};
		int result1 = f.calculate(1, 2);
		int result2 = f2.calculate(3, 4);
		int result3 = f3.calculate(4, 5);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

	private static void f4() {
		Person p1 = new Person();
		p1.action1(new Workable() {
			@Override
			public void work(String name, String job) {
				System.out.println("이름은 " + name + "이고, 직업은 " + job + "이다.");
			}
		});

		p1.action1((a, b) -> System.out.println(a + "--" + b));
		p1.action1((a, b) -> {
			System.out.println("자네 이름은 ? " + a + "입니다!!");
			System.out.println("자네 직업은 ? " + b + "입니다!!");
		});

		Workable f = (a, b) -> {
			System.out.println("그대 이름은 ? " + a + "입니다!!");
			System.out.println("그대 직업은 ? " + b + "입니다!!");
		};
		p1.action1(f);

		// return 필요 없는 경우
//		p1.action2(s -> System.out.println(s + " 반가워요 ^^"));
		Speakable f2 = s -> s + "!!!!!!";
		p1.action2(f2);

	}

	private static void work(Runnable r) {
		Thread t1 = new Thread(r);
		t1.start();
	}

	private static void f3() {
		// Runnable은 메소드 1개만 있는 인터페이스임

		// Runnable r = () -> { System.out.println("두줄짜리");};
		// work(r);

		// 위에 것 보다 더 간단하게.
		// 내가 씀 : work에서 Runnable 타입으로 받으므로, r에 그냥 함수 던져준 것임
		work(() -> {
			System.out.println("A");
		});
		work(() -> {
			System.out.println("B");
		});
		work(() -> {
			System.out.println("C");
		});
		work(() -> {
			System.out.println("D");
		});
	}

	private static void action(Calculable func) {
		func.calculate(10, 15);
	}

	private static void f2() {
		// 1. 구현 클래스를 이용
		// 2. 익명 구현 클래스 이용
		/*
		 * (new Calculable() {
		 * 
		 * @Override public void calculate(int x, int y) {
		 * System.out.println("------익명 구현 클래스------"); System.out.println("더하기 : " + x
		 * + " + " + y + " = " + (x+y)); } }).calculate(20, 10);
		 */
		Calculable f = new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("------익명 구현 클래스------");
				System.out.println("더하기 : " + x + " + " + y + " = " + (x + y));
			}
		};
		Calculable f2 = new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("------익명 구현 클래스------");
				System.out.println("빼기 : " + x + " - " + y + " = " + (x - y));
			}
		};

		Calculable f3 = (a, b) -> {
			System.out.println("------람다 표현식------");
			System.out.println("빼기 : " + a + " * " + b + " = " + (a * b));
		};

		action(f);
		action(f2);
		action(f3);

	}

	private static void f1() {
		// 1. 구현 클래스를 이용
		// MyClassImplement a = new MyClassImplement();
		// MyInterface가 부모이므로 다음과 같이 사용 가능
		MyInterface a = new MyClassImplement();
		a.print();

		// 2. 익명 구현 클래스 이용
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("일회용 익명 구현 클래스입니당~~~");
			}
		}).print();

		MyInterface b = new MyInterface() {
			@Override
			public void print() {
				System.out.println("다회용 익명 구현 클래스입니당~~~");
			}
		};
		b.print();

		// 3. 람다식 이용...js:화살표 함수 =>
		MyInterface c = () -> System.out.println("람다식 이용합니당~~~");
		c.print();
	}
}
