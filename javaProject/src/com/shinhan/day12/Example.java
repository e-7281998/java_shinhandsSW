package com.shinhan.day12;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class Example {
	
	static Student[] students = {
			new Student("홍", 10, 60),
			new Student("홍", 20, 70),
			new Student("홍", 30, 80),
			new Student("홍", 40, 90),
			new Student("홍", 50, 100),
	};
	
	public static void main(String[] args) {
		double engAvg = avg(s -> s.getEnglishScore());
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("영어평균 : " + engAvg);
		System.out.println("수학평균 : " + mathAvg);
		System.out.println("----------------------");
		
		//Stream 활용
		engAvg = Arrays.stream(students).mapToInt(s -> s.getEnglishScore()).average().orElse(0);
		mathAvg = Arrays.stream(students).mapToInt(s -> s.getMathScore()).average().orElse(0);
		System.out.println("영어평균 : " + engAvg);
		System.out.println("수학평균 : " + mathAvg);
		System.out.println("----------------------");

		//람다표현식 + Stream 활용
		engAvg = avg2(s -> s.getEnglishScore());
		mathAvg = avg2(s -> s.getMathScore());
		System.out.println("영어평균 : " + engAvg);
		System.out.println("수학평균 : " + mathAvg);
		System.out.println("----------------------");

	}
	
	//람다표현식  + Stream 활용
	private static double avg2(ToIntFunction<Student> f) {
		return Arrays.stream(students).mapToInt(f).average().orElse(0);
	}

	//람다표현식만 사용한 예제
	private static double avg(Function<Student> f) {
		//f에 (s -> s.getEnglishScore)가 들어옴
		double result = 0;
		for(Student st:students) {
			double d = f.apply(st);
			result += d;
		}
		
		return result/students.length;
	}
}
