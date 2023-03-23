package com.shinhan.day02;

public class 전은정 {

	public static void main(String[] args) {
		method4_6();
	}


	private static void method4_6() {
		for(int i=1; i<=5; i++) {
		}
	}


	private static void method4_5() {
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++){
				if((4*i + 5*j )== 60)
				System.err.printf("(%d,%d)", i,j);
			}
		}
	}


	private static void method4_4() {
		
		while(true) {
			int fst = (int)(Math.random()*6+1);
			int scd = (int)(Math.random()*6+1);
			
			if(fst + scd == 5) break;
		}
	}


	private static void method4_3() {
		int sum = 0;
		
		for(int i=3; i <= 100; i+=3) {
			sum += i;
		}
		System.out.printf("3의 배수의 합은 %d 입니다.", sum);
	}


	private static void method3_7() {
		double x = 5.0;
		double y = 0.0;
		double z = 5 % y;
		
		if(Double.isNaN(z)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		}else {
			double result = z + 10;
			System.out.println("결과: " + result);
		}
	}

	private static void method3_6() {
		double x = 10;
		double y = 5;
		System.out.println((x > 7) && (y <= 5));
		System.out.println((x % 3 == 2) || (y % 2 != 1));
	}

	private static void method3_5() {
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0;	
//		double area = (lengthTop + lengthBottom) * height *1.0 / 2;
//		double area = (double)(lengthTop + lengthBottom) * height / 2;
		
		System.out.println(area);
	}

	private static void method3_4() {
		int value = 365;
		System.out.println(value / 100 * 100);
	}

	private static void method3_3() {
		int pencils = 534;
		int students = 30;
		
		//학생 한 명이 가지는 연필 수
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		//남은 연필 수
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
	}

	private static void method3_2() {
		int score = 85;
		String result = (!(score>90)? "가": "나");
		System.out.println(result);
	}
	
	private static void method3_1() {
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);
	}

}
