package com.shinhan.day05;

public class AnimalInheritenceTest3 {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
	}
	
	private static void call(Animal ani) {
		ani.method1();
		if(ani instanceof Dog) {
			Dog d2 =(Dog) ani;
			d2.method3();
			System.out.println(d2.a + ", "+d2.c);
		}else if(ani instanceof Cat) {
			Cat c2 = (Cat) ani;
			c2.method2();
			System.out.println(c2.a + ", "+c2.b);

		}
	}

	private static void f3() {
		Cat c1 = new Cat();
		Dog d1 = new Dog();
		call(c1);
		call(d1);
//		c1.method1();
//		d1.method1();
	}

	private static void f2() {
		//**내가 쓴것 :데이터타입을 따름: 즉 Animal 타입을 따르기 때문에 Cat의 것을 볼 수 없음.
		//**내가 쓴것 :부모 타입을 따르기 때문에 자식의 내용을 볼 수 없다.
		//field, method는 instance가 아닌 타입을 따른다.
		Animal c1 = new Cat();
		System.out.println(c1.a);
//		System.out.println(c1.b);	//Cat에 있는 필드임. 볼 수 없음
		c1.method1();
//		c1.method12();	//Cat에 있는 메소드임. 볼 수 없음.
	}
	
	private static void f1() {
		Cat c1 = new Cat();
		System.out.println(c1.a);
		c1.method1();
	}

}
