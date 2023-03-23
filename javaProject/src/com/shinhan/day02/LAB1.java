package com.shinhan.day02;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
		method4();
	}

	public static void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("직각 역삼각형을 출력할 줄 수 :");
		int rowCount = sc.nextInt();
		for (int row = 1; row <= rowCount; row++) {
			for (int col = 1; col <= rowCount + 1 - row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void quiz3() {
		Scanner sc = new Scanner(System.in);

		int val, total = 0;

		System.out.print("숫자를 입력하세요. : ");
		val = sc.nextInt();

		int start = val % 2 == 0 ? 2 : 1;

		for (int i = start; i <= val; i += 2) {
			total += i;
			System.out.println(i);
		}

		System.out.printf("총합은 %d 입니다.", total);
		sc.close();
	}

	private static void quiz2() {
		Scanner sc = new Scanner(System.in);

		String ment = "";

		System.out.print("문자열을 입력하세요. :");
		ment = sc.nextLine().toUpperCase();

		for (int i = 1; i <= ment.length(); i++) {
			System.out.println(ment.substring(0, i));
		}
		sc.close();

	}

	private static void quiz1() {
		Scanner sc = new Scanner(System.in);

		int start, end, increment, total = 0;

		System.out.print("초기값을 정수로 입력하세요. : ");
		start = sc.nextInt();
		System.out.print("마지막값을 정수로 입력하세요. : ");
		end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요. : ");
		increment = sc.nextInt();

		sc.close();

		for (int i = start; i <= end; i += increment) {
			total += i;
		}
		if (total > 1000)
			total += 2000;

		System.out.printf("총합은 %d 입니다.", total);
	}

}
