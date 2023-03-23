package com.shinhan.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.shinhan.day05.Account;

public class StreamTest {
	public static void main(String[] args) {
		f6();
	}
	
	private static void f6() {
		Account[] arr = {
				new Account("111", "kim1"),
				new Account("222", "kim2"),
				new Account("333", "kim3"),
		};
		
		List<Account> data1 = Arrays.asList(arr);
		//병렬처리하고 싶을때: 여러개의 스트림으로 하고 싶을 때 > parallelStream() : 안하면 현재는 main스레드만 돌고 있다고 찍힘
		data1.parallelStream().forEach(acc -> {
			System.out.println(acc);
			System.out.println(Thread.currentThread().getName());
			System.out.println("**********************-");

		});
		System.out.println("--------------------");
		data1.forEach(acc -> System.out.println(acc));
	}
	
	private static void f5() {
		Set<Account> arr = new HashSet<>();
		arr.add(new Account("111", "kim1"));
		arr.add(new Account("222", "kim2"));
		arr.add(new Account("333", "kim3"));

		arr.stream().forEach(acc -> System.out.println(acc));
		System.out.println("--------------------");

		arr.forEach(acc -> System.out.println(acc));
	}

	private static void f4() {
		Account[] arr = {
				new Account("111", "kim1"),
				new Account("222", "kim2"),
				new Account("333", "kim3"),
		};
		//이미 배열인 것을 리스트로 바꾸기, 대신 수정 불가임
		List<Account> data1 = Arrays.asList(arr);
		data1.stream().forEach(acc -> System.out.println(acc));
		System.out.println("--------------------");
		//아래처럼 stream 없이 바로 forEach를 돌 수 있음
		//다만, 위처럼 스트림으로 하면 중간에 작업을 처리할 수 있음
		//아래처럼 하면 반복하고 끝내버림 ? 
		data1.forEach(acc -> System.out.println(acc));
	}

	private static void f3() {
		Account[] arr = {
				new Account("111", "kim1"),
				new Account("222", "kim2"),
				new Account("333", "kim3"),
		};
		
		Arrays.stream(arr).forEach(acc -> System.out.println(acc));
	}

	private static void f2() {
		// 배열
		String arr1[] = { "자바", "자바스크립트", "리액트", "웹" };

		// 1.내부 반복자를 이용하고자한다면 먼저 stream을 얻는다.
		Stream<String> st = Arrays.stream(arr1);
		// 2. 내부 반복자로 값을 처리한다.
		Consumer<String> consumerF = (s) -> {
			System.out.println(s + "*******");
		};
		st.forEach(consumerF);
		
		//위의 것 한번에 
		Arrays.stream(arr1).forEach((s) -> System.out.println(s+"----"));
	}

	private static void f1() {
		// 1. 배열
		int arr1[] = new int[] { 100, 20, 50, 40, 30, 50 };

		// 스트림 만듬 Arrays.stream(arr1);
		// forEach는 IntConsumer : int를 내가 주면 자기가 소비만 하는애
		// 내부 반복자 이용 : 안에서 알아서 반복해서 해결함
		Arrays.stream(arr1).forEach(a -> System.out.println(a));

		// Original Stream
		IntStream is = Arrays.stream(arr1);
		IntConsumer func1 = (a) -> System.out.println(a);
		is.forEach(func1);
	}
}
