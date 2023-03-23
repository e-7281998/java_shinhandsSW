package com.shinhan.day11;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.shinhan.day05.Account;

public class LamdaTest3 {
	public static void main(String[] args) {
		f9();
	}

	private static void f9() {
		BiFunction<String, String, Account> func2 = (no, owner) -> {
			System.out.println("계좌번호: " + no);
			System.out.println("owner: " + owner);
			return new Account(no, owner);
		};	
		Account acc = func2.apply("1234", "onew");
		System.out.println(acc);
		
		BiFunction<String, String, Account> func3 = Account::new;
		Account acc3 = func3.apply("5555", "hhh");
		System.out.println(acc3);
	}

	private static void f8() {
		//f7을 더 간편하게	//정적 메소드를 사용할 때 다음과 같이 사용하면 됨
		//들어온 두 값 중 근 값 return해줌ㄴ
		BiFunction<Integer, Integer, Integer> func1 = Math::max;
		int result = func1.apply(500, 100);
		System.out.println(result);		
	}

	private static void f7() {
		BiFunction<Integer, Integer, Integer> func1 = (a,b) -> Math.max(a,b);
		int result = func1.apply(50, 100);
		System.out.println(result);
	}

	private static void f6() {
		BiFunction<Integer, Integer, Integer> func1 = (a,b) -> {
			if(a>b)	return a;
			else return b;
		};
		int result = func1.apply(50, 100);
		System.out.println(result);
	}

	private static void f5() {
		//return T/F
		Predicate<Integer> func1 = (a) -> a > 10;
		boolean result = func1.test(20);
		System.out.println(result);
		
		Predicate<Account> func2 = (a) -> {
			System.out.println("========잔고 조사=========");
			System.out.println(a);
			return a.getBalance() >= 100;
		};
		result = func2.test((new Account("1234", "kein", 50)));
		System.out.println(result);
		
	}

	private static void f4() {
		BinaryOperator<Integer> func1 = (a, b) -> a + b;
		BinaryOperator<Integer> func2 = (a, b) -> a - b;
		System.out.println(func1.apply(100, 50));
		System.out.println(func2.apply(100, 50));
	}

	// 매개값, 리턴값 모두 있음
	private static void f3() {
		Function<String, Account> func1 = (a) -> new Account(a, null, 100);
		// 매개값 2개일 경우
		BiFunction<String, String, Account> func2 = (no, owner) -> {
			System.out.println("계좌번호: " + no);
			System.out.println("owner: " + owner);
			return new Account(no, owner, 100);
		};
		Account acc1 = func1.apply("22223333");
		Account acc2 = func2.apply("44445555", "kim");
		System.out.println(acc1);
		System.out.println(acc2);
	}

	// 생산자 Supplier
	private static void f2() {
		// 준건 없지만 받은 건 있음
		Supplier<String> a = () -> "자바";
		Supplier<String> b = () -> {
			System.out.println("---------");
			return "자바2";
		};

		Supplier<Account> c = () -> new Account();

		String ret1 = a.get();
		String ret2 = b.get();
//		
//		System.out.println(ret1);
//		System.out.println(ret2);
//		System.out.println(c.get());
	}

	// 소비자 Consumer
	private static void f1() {
		// 인터페이스 만들지 않고, 람다식 사용하기
		// Consumer 매개변수 1개
		Consumer<Integer> f = (a) -> System.out.println(a + 200);
		Consumer<String> f2 = (a) -> System.out.println(a + 200 + "원");
		Consumer<Account> f4 = (a) -> {
			System.out.println(a);
			a.deposit(1000);
			int result = a.withdraw(500);
			System.out.println(result + "원 출금 완료");
		};

		f.accept(100);
		f2.accept("돈 있니? ");
		// BiConsumer 매개변수 2개
		BiConsumer<String, Integer> f3 = (a, b) -> {
			System.out.println("a : " + a);
			System.out.println("b : " + b);
		};
		f3.accept("자바", 100);
		f4.accept(new Account("123", "ej", 1000));
	}
}
