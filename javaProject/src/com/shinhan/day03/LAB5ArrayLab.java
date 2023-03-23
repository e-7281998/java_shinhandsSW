package com.shinhan.day03;

import java.util.Arrays;

public class LAB5ArrayLab {

	public static void main(String[] args) {
//		method1();
		
		//Quiz2
		int arr1[][] = { { 30, 30, 30, 30 }, { 40, 40, 40, 40 }, { 50, 50, 50, 50 } };
		int arr2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//		int arr3[][] = {{29, 28, 27, 26},{35, 34, 33, 32},{41, 40, 39, 38}};
		int arr3[][] = new int[3][4];
		int arr4[][] = sub(arr1, arr2, arr3);

		prn(arr3);
		System.out.println("============================");
		prn(arr4);
	}

	// Quiz2
	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		// arr1-arr2

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}

		//굳이c를 return하지 않아도 됨
		//왜? 어차피 c에는 arr3의 "주소값"이 들어가 있기 때문이다.
		//배열은 참조타입이므로 주소값이 저장된다.
		
		return c;
	}

	public static void prn(int[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}

	}

	// Quiz1
	private static void method1() {
		// select sort : 하나 선택후 다음이랑 계속 비교
		int arr[] = { 3, 24, 1, 55, 17, 43, 5 };

		System.out.println("원본: " + Arrays.toString(arr));

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					// 바꾸기
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

}
