package com.shinhan.day05;

//Quiz 7_9
class A{
	
}

class B extends A{}
class C extends A{}
class D extends B{
	int max = 100;
}
class E extends B{}
class F extends C{}


public class InheritenceTest3 {

	public static void main(String[] args) {
//		f4();
		f5();
	}

	private static void f5() {
		//자동형변환 : 부모타입 = 자식객체
		D v1 = new D();	//자신
		B v2 = new D();	//부모
		A v3 = new D();	//조부모
		
		System.out.println(v1.max);
//		System.out.println(v2.max);	//불가
		//강제형변환 : 자식타입 = (자식타입)부모타입객체
		D v4 = (D)v2;
		System.out.println(v4.max);
		
//		System.out.println(v3.max);
		D v5 = (D) v3;
		System.out.println(v5.max);
		
//		E v6 = (E)v2;	//컴파일시에 오류 없음, 실행시 오류남
		//본래 생성된 instance로만 형변환이 가능
		E v7 = (E) v3;	//컴파일시 오류 없음, 실행시 오류	//조부모는 불가능
		
		//형변환 가능한지 체크하자
		System.out.println ((v3 instanceof D) ? "응" : "아니 형변환 불가");
		System.out.println ((v3 instanceof E) ? "응" : "아니 형변환 불가");
		if(v3 instanceof D dd) {	//ver.12 부터 형변환 결과 받을 변수 추가.
//			D dd = (D) v3;	//ver.12이전일 경우
			System.out.println(dd.max);
		}
	}

	private static void f4() {
		CarTest car = new CarTest();
		HankokTire a = new HankokTire();
		car.go(a);
//		car.go(new KumhoTire());
	}

}
