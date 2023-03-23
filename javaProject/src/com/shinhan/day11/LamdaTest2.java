package com.shinhan.day11;

public class LamdaTest2 {
	public static void main(String[] args) {
		f1(100);
		f2(100);
	}
	static String subject = "자바";
	
	private static void f2(int su1) {	//파라메터 : 지역변수
		int su2 = 200;	//지역 변수
		int su3 = 300;
		su3++;	//내부 클래스에서 사용하지 않았으므로 값 수정 가능
		//내부 클래스에서 지역변수를 사용한다면, final의 특성을 가진다.
		// : 수정 붛가. 
		//su1 ++;
		//su2 ++;
		//1.익명 구현 클래스
		Calculable2 f = (a, b) -> {
			System.out.println("람다식 표현 : "+ LamdaTest2.subject);
			//su1 ++;
			//su2 ++;
			return a + b + su1 + su2;
		};
		int result = f.calculate(1, 2);
		System.out.println(result);
	}

	private static void f1(int su1) {	//파라메터 : 지역변수
		int su2 = 200;	//지역 변수
		int su3 = 300;
		su3++;	//내부 클래스에서 사용하지 않았으므로 값 수정 가능
		//내부 클래스에서 지역변수를 사용한다면, final의 특성을 가진다.
		// : 수정 붛가. 
		//su1 ++;
		//su2 ++;
		//1.익명 구현 클래스
		Calculable2 f = new Calculable2() {
			@Override
			public int calculate(int x, int y) {
				System.out.println("익명 구현 객체");
				//su1++; //지역변수는 final의 특성을 가지고 있어 값 변경 불가.
				//su2++; //지역변수는 final의 특성을 가지고 있어 값 변경 불가.
				return x + y + su1 + su2;
			}
		};
		int result = f.calculate(1, 2);
		System.out.println(result);
	}
}
