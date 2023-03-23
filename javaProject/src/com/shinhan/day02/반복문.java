package com.shinhan.day02;

public class 반복문 {

	public static void main(String[] args) {
		forTest4();
	}

	private static void forTest4() {
		// 1-10합계
		int su = 1;
		int total = 0;
		for (; su <= 10; ++su) {
			if (su % 2 != 0)
				continue;

			System.out.print(su);
			System.out.print(su == 10 ? "" : "+");
			total += su;
		}
		System.out.println("=" + total);
	}

	private static void whileTest2() {
		int i = 100;
		// 1-10까지 출력
		do {
			System.out.println(i);
			i++;
		} while (i <= 10);
		System.out.println("method end" + i);
	}

	private static void whileTest() {
		int i = 1;
		// 1-10까지 출력
		while (true) {
			if (i > 10)
				break;
			System.out.println(i);
			i++;
		}
		System.out.println("method end" + i);
	}

	private static void forTest2() {
		int i = 1;
		// 1-10까지 출력
		for (;;) {
			if (i > 10)
				break;
			System.out.println(i);
			i++;
		}
		System.out.println("method end" + i);
	}

	private static void forTest() {
		int i;
		// 1-10까지 출력
		for (i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("method end" + i);
	}

}
