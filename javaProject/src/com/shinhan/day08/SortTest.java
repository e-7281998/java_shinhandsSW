package com.shinhan.day08;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	public static void main(String[] args) {
//		f3();
		f4();
	}

	private static void f4() {
		Car arr[] = { new Car("A", 800), new Car("X", 100), new Car("B", 800), new Car("E", 800), new Car("D", 1000) };
		Arrays.sort(arr); // sort하려면 반드시 Comparable이 필요하다.

		print("Before", arr);
		print("가격 asc, 모델 desc, after", arr);

		Arrays.sort(arr, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				
				int result = o2.price - o1.price;
				if(result == 0) return o1.model.compareTo(o2.model);
				//문자일경우 A와 C의 차이(거리)?를 나타냄?
				return result;
			}

		}); 
		print("가격 desc, 모델 asc, after", arr);

	}

	private static void print(String title, Car[] arr) {
		System.out.println("=========" + title + "=========");
		for (Car car : arr) {
			System.out.println(car);
		}
	}

	private static void f3() {
		Money arr[] = { new Money(10), new Money(5), new Money(8), new Money(16), new Money(6), };
		System.out.println("before: " + Arrays.toString(arr));
		// Comparable 인터페이스를 구현하지 않으면 비교 불가
		// 그러므로 Money 클래스에 implements Comparable<Money> 추가
		Arrays.sort(arr);
		System.out.println("after: " + Arrays.toString(arr));

		Arrays.sort(arr, new Comparator<Money>() {

			@Override
			public int compare(Money o1, Money o2) {
				return o2.amount - o1.amount;
			}
		});// Comparator 인터페이스를 익명구현
		System.out.println("Desc after: " + Arrays.toString(arr));
	}

	private static void f2() {
		// ASCII code: A[65], a[97]
		String arr[] = new String[] { "HTML", "CSS", "javascript", "React", "Vue", "Java", "next" };
		System.out.println("before: " + Arrays.toString(arr));
		Arrays.sort(arr); // 원본을 바꿈
		System.out.println("after: " + Arrays.toString(arr));
		Arrays.sort(arr, new Comparator<String>() {
			// arr과 'Comparator의 익명 구현 클래스의 String'으로 비교하고 싶음
			@Override
			public int compare(String o1, String o2) {
				// o1은 arr, o2는 익명
				return o2.compareTo(o1); // 디샌딩 : 뒤에것을 기준으로하면 내림차순
			}

		});
		System.out.println("after: " + Arrays.toString(arr));

	}

	private static void f1() {
//		int arr[] = new int[] {100,30,80,20,99};
		Integer arr[] = new Integer[] { 100, 30, 80, 20, 99 };
		System.out.println("before: " + Arrays.toString(arr));
		Arrays.sort(arr); // 원본을 바꿈
		System.out.println("after: " + Arrays.toString(arr));
		// Integer 위로만 가능
		Arrays.sort(arr, new DecendingInteger());
		System.out.println("after: " + Arrays.toString(arr));
	}
}
