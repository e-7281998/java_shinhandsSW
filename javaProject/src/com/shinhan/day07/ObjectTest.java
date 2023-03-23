package com.shinhan.day07;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Car { // 기본으로 Object 상속 받음
	String model;
	int price;

	public Car(String model, int price) {
		super(); // Object 부모 호출
		this.model = model;
		this.price = price;
	}

	//동등비교 (예+: HashSet은 중복 불가) : hashCode(), equals()가 모두 같아야 같은 객체로 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(model, other.model) && price == other.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price);
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}

}

public class ObjectTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
//		f6();
	}

	private static void f6() {
		// Set : 순서가 없다. 중복을 허용안함.
		Set<String> data = new HashSet<String>();
		data.add("월");
		data.add("화");
		data.add("수");
		data.add("월");
		data.add("월");

		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void f5() {

//		Car obj1 = new Car("A", 100);
//		Car obj2 = new Car("B", 100);
//		Car obj3 = new Car("C", 100);
//		Car obj4 = new Car("D", 100);
//		Car obj5 = new Car("E", 100);
//		Car obj6 = new Car("F", 100);
		Set<Car> data = new HashSet<Car>();
		data.add(new Car("A", 100));
		data.add(new Car("B", 100));
		data.add(new Car("C", 100));
		data.add(new Car("D", 100));
		data.add(new Car("F", 100));
		data.add(new Car("F", 100));
		for (Car s : data) {
			System.out.println(s);
			System.out.println(s.hashCode());
			System.out.println("==========");
		}
	}

	private static void f4() {
		Car obj1 = new Car("A", 100);
		Car obj2 = new Car("B", 100);
		// default 생성자 없음 사용 불가
//		obj1.model = "A모델";
//		obj1.price = 200;

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2 ? "주소가 같다." : "주소가 다르다"); // 주소 비교
		System.out.println(obj1.equals(obj2) ? "내용이 같다." : "내용이 다르다"); // Car equals() : 내용비교로 재정의 됨

		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	}

	private static void f3() {
		Date obj1 = new Date();
		Date obj2 = new Date();

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2 ? "주소가 같다." : "주소가 다르다"); // 주소 비교
		System.out.println(obj1.equals(obj2) ? "내용이 같다." : "내용이 다르다"); // Date equals() : 내용비교로 재정의 됨
	}

	private static void f2() {
		String obj1 = new String();
		String obj2 = new String();

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2 ? "주소가 같다." : "주소가 다르다"); // 주소 비교
		System.out.println(obj1.equals(obj2) ? "내용이 같다." : "내용이 다르다"); // String equals() : 내용비교로 재정의 됨
	}

	private static void f1() {
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2 ? "주소가 같다." : "주소가 다르다"); // 객체는 주소 비교
		System.out.println(obj1.equals(obj2) ? "주소가 같다." : "주소가 다르다"); // Object equals() : 주소비교
	}

}
