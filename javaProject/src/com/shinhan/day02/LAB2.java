package com.shinhan.day02;

import java.util.Scanner;

public class LAB2 {

	public static void main(String[] args) {
		numDay(2010, 2);
	}

	//void : return 값이 없다.
	//static : class가 메모리에 load될 때 method영역에 올라간다.
	//public : 모든 패키지에서 이 함수를 호출할 수 있다.
	public static void numDay(int year, int month) {
		
		int lastDay = 0;
		
		switch(month) {
		case 1,3,5,7,8,10,12:
			lastDay = 30;
			break;
		case 4,6,9,11:
			lastDay = 31;
			break;
		case 2:
			lastDay = quiz6(year) ? 29 : 28;
			break;
		default:
			break;
		}
		
		System.out.println(lastDay == 0 ? "잘못된 월" : lastDay);
		
	}
	private static boolean quiz6(int year) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("년을 입력하세요:");
//		int num = sc.nextInt();
		int num = year;
		boolean result = false;

		if (num % 4 == 0) {
			if (num % 100 != 0 || num % 400 == 0)
				result = true;
		}
		
		System.out.println(result ? "윤년임" : "윤년아님");

		return result;
	}

	private static void quiz5() {
//		int sum=0, sum2=1;
//		
//		for(int i=1; i<=15; i++) {
//			sum += i;
//			sum2 += sum;
//			System.out.println(i);
//		}
//		
//		System.out.println("15번째까지의 합 :" + sum2);
	}

	private static void quiz4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요:");
		int num = sc.nextInt();
		int sum = 0, n = 0;

		for (int i = 1; i <= 1000; i++) {
			if ((i % num) == 0) {
				n++;
				sum += i;
			}
		}

//		for(i=num; i<1000; i+=num) {
//			sum+=i;
//		}

		System.out.println(num + "의 배수 개수: " + n);
		System.out.println(num + "의 배수 합: " + sum);

	}

	private static void quiz3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요:");
		int num = sc.nextInt();
		int sum = 1;

		for (int i = 1; i <= num; i++) {
			sum *= i;
		}
		System.out.println(sum);

	}

	private static void quiz2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2 ~ 100 사이의 정수를 입력하세요:");
		int num = sc.nextInt();
		boolean result = true;

		for (int i = 2; i < (num / 2); i++) {
			if (num % i == 0) {
				result = !result;
				break;
			}
		}

		if (result) {
			System.out.println(num + "은 소수입니다.");
		} else {
			System.out.println(num + "은 소수가 아닙니다.");
		}

	}

	private static void quiz1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 : ");
		int dan = sc.nextInt();

		if (dan < 2 || dan >= 10) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		}

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d", dan, i, dan * i);
			System.out.println();
		}
	}

}
