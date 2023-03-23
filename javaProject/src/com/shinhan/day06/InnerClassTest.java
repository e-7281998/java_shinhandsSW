package com.shinhan.day06;

public class InnerClassTest {

	public static void main(String[] args) {
//		f1();
		f2();
//		f3();
//		f4();
	}

	private static void f4() {
		//LocalClass
		OuterClass outer = new OuterClass();
		outer.f1();
	}

	private static void f3() {
		OuterClass.StaticInnerClass v1;
		v1 = new OuterClass.StaticInnerClass();
		System.out.println(v1.s1);
		System.out.println(OuterClass.StaticInnerClass.s2);
		v1.method3();
		OuterClass.StaticInnerClass.method4();
	}

	private static void f2() {
		//2. instance inner class 사용

//		OuterClass outer = new OuterClass();
//		OuterClass.InstanceInnerClass v1 = outer.new InstanceInnerClass();
		OuterClass.InstanceInnerClass v1 = new OuterClass().new InstanceInnerClass();
		System.out.println("InstanceInnerClass 필드" + v1.s1);
		System.out.println("InstanceInnerClass static필드" + OuterClass.InstanceInnerClass.s2);

		v1.method3();
		OuterClass.InstanceInnerClass.method4();
	}

	// 기본
	private static void f1() {
		// 1. 일반적인 class 사용
		OuterClass v1 = new OuterClass();
		System.out.println("instance 필드" + v1.a);
		System.out.println("instance 필드" + OuterClass.b);
		v1.method1();
		OuterClass.method2();
	}

}
