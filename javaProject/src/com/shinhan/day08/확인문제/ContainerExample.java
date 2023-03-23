package com.shinhan.day08.확인문제;

import com.shinhan.day08.ch12LAB2.Money;

public class ContainerExample {
	public static void main(String[] args) {
		f4();

	}

	private static void f4() {
		Container<String> container1 = containerFactory("Book");
		String s = container1.get();
		System.out.println(s);
		
		Container<Integer> container2 = containerFactory(200);
		Integer s2 = container2.get();
		System.out.println(s2);
		
	}

	private static <T> Container<T> containerFactory(T data) {
		return new Container<T>(data);
	}

	private static <K, V> Container2<K, V> makeContainer(K key, V value) {

//		return new Container2<>(key, value);	//생략 가능
		return new Container2<K, V>(key, value);
	}

	private static void f3() {

		Container2<String, Integer> container3 = makeContainer("aa", 100);

		Container2<String, String> container1 = new Container2<>();
		container1.set("홍", "100");

		System.out.println("key=" + container1.getKey());
		System.out.println("key=" + container1.getValue());

		Container2<String, Money> conainer2 = new Container2<>();
		conainer2.set("홍", new Money(100));

		System.out.println("key=" + conainer2.getKey());
		System.out.println("key=" + conainer2.getValue());
	}

	private static void f2() {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();

		Container<Integer> container2 = new Container<Integer>(null);
		container2.set(6);
		int value = container2.get();
	}
}
