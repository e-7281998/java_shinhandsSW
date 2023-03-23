package com.shinhan.day11;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamTest2 {
	public static void main(String[] args) {
		List<Student> data  = Arrays.asList(
			new Student("홍길이2", 500),	
			new Student("홍길이3", 400),	
			new Student("홍길이1", 100),	
			new Student("홍길이4", 300)
		);
		//결과 얻기
		//data.forEach(st -> System.out.println(st));
		
		//중간처리하고싶으면..
		//mapToInt : 중간 처리
		//map : 변형한다는 의미
		//average : 최종처리 ... 평균을 구함	
		//getAsDouble()값을 얻어 double로 바꾼다.
		double avg = data.stream().mapToInt(st -> st.getScore()).average().getAsDouble();
		//만약 학생이 없으면 (값이 없으면, .average()에서 에러남... 평균 계살할 것이 없어서... 런타임 에러
		//위와 같은것을 해결하기 위해 아래와 같이 해결해야 함. Optional로 처리....~
		System.out.println(avg);
		
		//OptionalDouble : double이 있을수도 있고 아닐수도 있다.
		OptionalDouble opAvg = data.stream().mapToInt(st -> st.getScore()).average();
		//ifPresentOrElse(있으면할거, 없으면 할거)
		opAvg.ifPresentOrElse(a -> {
			System.out.println("평균: " + a);
		}, () -> {	System.out.println("평균 계산할 수 없어유~");	});

	}
}
