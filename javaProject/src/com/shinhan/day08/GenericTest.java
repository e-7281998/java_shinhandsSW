package com.shinhan.day08;

import java.util.ArrayList;



import com.shinhan.day08.ch12LAB2.Money;

public class GenericTest {

	public static void main(String[] args) {
		wildCardTest4();
	}
	
	private static void wildCardTest4() {
		HappyBox<String> box = new HappyBox<String>("S", 200);
//		wildCardTest4_1(box);
		HappyBox<Integer> box2 = new HappyBox<Integer>(5, 200);
//		wildCardTest4_2(box2);
		HappyBox<ChildA> box3 = new HappyBox<ChildA>(new ChildA(),10);
		wildCardTest4_3(box3);

	}
	private static void wildCardTest4_3(HappyBox<? super ChildA> param) {
		System.out.println("wildCardTest4_3");
	}
	private static void wildCardTest4_2(HappyBox<? extends Number> param) {
		System.out.println("wildCardTest4_2");
	}
	private static void wildCardTest4_1(HappyBox<?> param) {
		System.out.println("wildCardTest4_1");
	}

	private static void wildCardTest3() {
		//? extends super
		
		//Worker의 상위만 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
//		Course.registerCourse3(new Applicant<Student>(new Student()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
//		Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
//		Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));

	}
	
	private static void wildCardTest2() {
		//? extends super
		
		//Student의 하위만 가능
//		Course.registerCourse2(new Applicant<Person>(new Person()));
		Course.registerCourse2(new Applicant<Student>(new Student()));
//		Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));	
		
	}
	
	private static void wildCardTest() {
		//? extends super
		
		//? : 모든 타입
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));

	}

	private static <T> void genericExtendsMethod4(HappyBox<? super Number> param) {	//HappyBox 제네릭에 Number의 상위만 가능
		System.out.println("genericExtendsMethod3.........");
		System.out.println("? super Number : Number의 상위만 가능");
	}
	
	private static <T> void genericExtendsMethod3(HappyBox<? extends Number> param) {	//HappyBox 제네릭에 Number의 자식만 가능
		System.out.println("genericExtendsMethod3.........");
		System.out.println("? extends Number : Number의 자식만 가능");
	}
	
	//제네릭타입 제한(extends, super, ?)
	private static <T> void genericExtendsMethod2(HappyBox<?> param) {	//HappyBox 첫 번째 제네릭에 제한을 검
		System.out.println("genericExtendsMethod2.........");
		System.out.println("?는 제한이 없다.");
	}

	private static void metohd3() {
		genericExtendsMethod(new ChildA());
		genericExtendsMethod(new ChildB());
//		genericExtendsMethod(new Money(100));	//Parent를 상속받지 않았기 때문에 사용 불가
		
		genericExtendsMethod2(new HappyBox<>("사과", 0));
		genericExtendsMethod3(new HappyBox<>(3, 0));
		genericExtendsMethod4(new HappyBox<>(3, 0));
	}

	private static <T extends Parent> void genericExtendsMethod(T param) {
		System.out.println("genericExtendsMethod.........");
	}

	//타이 제한 걸기
	//extends Number는 Number를 상속받은 하위 class만 가능함을 의미
	public static <T extends Number> boolean compare(T a,T b) {
		return a.equals(b);
	}
	
	private static void metohd2() {
		int a = 10;	//Integer로 자동으로 박싱이 됨.
		int b  = 20;
		boolean result = compare(a,b);
		System.out.println(result);
		
		String s1 = "자바1";
		String s2 = "자바11";
//		result = compare(s1, s2);	//타입에 제한을 걸어서 Number 하위가 아니므로 불가.
		System.out.println(result);
	}
	
	//제네릭 메서드
	private static <T, A, B> int boxing2(T kind, A a, B b) {
		return 100;
	}


	private static <T> HappyBox<T> boxing(T i) {
		return new HappyBox<T>(i, 100);
	}

	//제네릭 메서드 주석부터 이 메서드 바로 위까지 사용시 main에 method1 넣기
	private static void metohd1() {
		HappyBox<String> box1 = Boxing("해피박스");
		HappyBox<Integer> box2 = boxing(525);
		HappyBox<Money> box3 = Boxing(new Money(718));
		System.out.println(box1);		
	}

	//static 다음에 나오는 처음에 <T>는 이 함수가 제네릭 메소드임을 알림
	private static <T> HappyBox<T> Boxing(T kind) {
			//리턴 타입이 T임. 이 제네릭 사용하는애가 타입을 결정해서 보낼거야.
			return new HappyBox<T>(kind, 100);
	}

	private static void f5() {
		//제네릭은 기본형으로 제한할 수 없음, 객체만 가능
		//int안됨 => Integer가능
		Product<String, Integer> p1 = new Product<>("책", 1000);
		Product<String, Integer> p2 = new Product<>("책", 000);
		System.out.println(p1);
		System.out.println(p1.equals(p2));
	}
	private static void f4() {
		ArrayList<Money> data = new ArrayList<>();
		data.add(new Money(1));
		data.add(new Money(12));
		data.add(new Money(13));
		data.add(new Money(15));
		
//		for(Object d:data) {	//Object형도 가능, 부모니까
		for(Money d:data) {
			System.out.println(d);
		}
	}

	private static void f3() {
		ArrayList<String> data = new ArrayList<>();
		data.add("월");
		data.add("목");
		data.add("토");
		data.add("월");
		
//		for(Object d:data) {	//Object형도 가능, 부모니까
		for(String d:data) {
			System.out.println(d);
		}
	}

	private static void f2() {
		//무조건 String형만 가능
		HappyBox<String> b1 = new HappyBox<String>("바나나", 100);
		HappyBox<String> b2 = new HappyBox<>("컴퓨터", 100);	//우측은 생략해도 됨 <>
		HappyBox<String> b3 = new HappyBox<>("책", 100);
		
		String s1 = b1.kind;
		String s2 = b2.kind;
		String s3 = b3.kind;
		
		//무조건 Money형만 가능
		HappyBox<Money> b4 = new HappyBox<Money>(new Money(300), 100);
		HappyBox<Money> b5 = new HappyBox<>(new Money(300), 200);	//우측은 생략해도 됨 <>
		HappyBox<Money> b6 = new HappyBox<>(new Money(400), 300);
		
		Money m1 = b4.kind;
		Money m2 = b5.kind;
		Money m3 = b6.kind;
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m2.equals(m3));
	}

	private static void f1() {
		
		//제네릭스 사용하지 않은 예제 : 형변환을 진행해줘야함 : 불편함
		Box b1 = new Box("바나나", 100);
		Box b2 = new Box(500, 100);
		Box b3 = new Box(new Money(300), 100);
		
		String s1 = (String)b1.kind;
		int s2 = (Integer)b2.kind;
		Money m = (Money)b3.kind;
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(m);
	}

}
