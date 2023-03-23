package com.shinhan.day02;

import java.util.Scanner;

public class LAB3 {

	public static void main(String[] args) {
		// public : 모든 패키지에서 접근이 가능하다.
		// static : >java LAB3 실행하면 실행하기 전에 LAB3 class의 byte 코드가 method영역에 올라감
		// static붙은 method, variable들이 올라간다.
		// void : return 값이 없다.

//		double result = sum(1,100);
//		System.out.println(result);

		calc(2, 5);
		calc(5, 15);
		calc(250, 30);

	}

	private static void calc(int i, int j) {
		Scanner sc = new Scanner(System.in);

		int k = 0, l = 0, num = 1;
		l = Math.min(i, j);

		for (int m = l; m >= 1; m--) {
			if (i % m == 0 && j % m == 0) {
				num = m;
				break;
			}
		}

		System.out.println(num);
	}

	private static double sum(int i, int j) {
		int total = 0;
		for (int loop = i; loop <= j; loop++) {
			total += loop;
		}

		return total;
	}
}
