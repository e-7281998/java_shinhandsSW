package com.shinhan.day06;

public class OuterClass {
	// 1.field : instance 필드(멤버 변수: 객체로 접근), static 필드(클래스로 접근)
	int a = 10;
	static int b = 20;	//OuterClass.b 로 접근해야 함.

	// 2. 생성자...default제공
	// 3. 메서드 : instance 메소드, static 메소드
	void method1() {
		System.out.println("OuterClass... instance method1");
	}

	static void method2() {
		System.out.println("OuterClass... instance method2");
	}

	// 4. block(instance block {}, satic block : static {}

	int score = 100;
	// 5. inner class : 3가지 : instance, class, local
	class InstanceInnerClass {
		int score = 200;	//멤버변수 : new 하면 생성되는 것
		String s1 = "InstanceInnerClass임";
		//InstanceInnerClass가 로드 될 때 static 올라감
		static String s2 = "InstanceInnerClass static임";

		void method3(/*int score : 매개변수 : 얘도 지역변수임*/) {
			int score = 300;	//지역변수 : 함수 내의 변수
			System.out.println(score);	//클래스와 가까운 변수 우선임 : 300
			System.out.println(this.score);	//현재 객체의 score 호출됨 : 200
			System.out.println(OuterClass.this.score);	//바깥의 score 호출 : 100
			//outer클래스 호출할 때 아우터클래스.this.변수
			
			System.out.println("InstanceInnerClass... instance method3");
			System.out.println("외부의 instance 필드 접근 :" + a);
			System.out.println("외부의 static 필드 접근 :" + b);
		}

		//InstanceInnerClass를 new로 생성하지 않아도 호출할 수 있음
		static void method4() {
			System.out.println("InstanceInnerClass... instance method4");
			System.out.println("InstanceInnerClass... instance method3");
			//필드 접근 불가능 method4는 static이므로
			//System.out.println("외부의 instance 필드 접근 :" + a);
			System.out.println("외부의 static 필드 접근 :" + b);
		}
	}

	static class StaticInnerClass {
		String s1 = "StaticInnerClass임";
		static String s2 = "StaticInnerClass static임";

		void method3() {
			System.out.println("StaticInnerClass... instance method3");
			//바깥을 new해야 a가 올라옴
			//System.out.println("외부의 instance 필드 접근 :" + a);
			System.out.println("외부의 static 필드 접근 :" + b);}

		static void method4() {
			System.out.println("StaticInnerClass... instance method4");
			//바깥을 new해야 a가 올라옴
//			System.out.println("외부의 instance 필드 접근 :" + a);
			System.out.println("외부의 static 필드 접근 :" + b);		}
	}

	//LocalClass : 함수 내에 있는 class,static 불가
	void f1() {
		//*****static에서 non-static 호출 불가*****
		
		//지역 변수는 내부 class에서 사용하면 final 특성을 가진다.
		//final int max = 100;임
		int max = 100;
//		max++;	//사용 하면 method5()의 System.out.println(max); 오류남 : max는 final의 특성을 가짐. 최종값임.
		// f1메서드 안에서만 사용할 수 있음.
		class LocalClass {
			String s3 = "LocalClass임";
			//LocalClass이 로드될때 static 같이 올라감
			static String s4 = "LocalClass static임";

			void method5() {
				System.out.println("LocalClass... instance method5");
				System.out.println(s3);
				System.out.println(s4);
				System.out.println(a);
				System.out.println(b);
				System.out.println(max);
				//max = 200;	//변경 불가
				System.out.println("====================");
			}

			static void method6() {
				System.out.println("LocalClass... instance method6");
				System.out.println("LocalClass... instance method5");
				//static 아니므로 사용 불가
//				System.out.println(s3);
				System.out.println(s4);
//				System.out.println(a);
				System.out.println(b);
				}

		}
		
		LocalClass local = new LocalClass();
		System.out.println(local.s3);
		System.out.println(LocalClass.s4);
		local.method5();
		LocalClass.method6();
	}
}
