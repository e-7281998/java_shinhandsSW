package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
//public class Car {
//위의 코드로 하면 sort로 비교 불가.
//다음과 같이 implements로 Comparable을 상속해야 함.
//Comparable<T> : T에는 구현한 타입으로 넣어주면 굳이 형변환하지 않아도  됨.

public class Car implements Comparable<Car> {
	String model;
	int price;
	
	@Override
	public int compareTo(Car obj) {
//		//가격으로 sort학 싶다면
//		return price - obj.price;	//어샌딩소트
		
		//A와 B를 비교하게 되면 주체가 되는 것은 A다.
		//값은 -1 0 1이 있는데 내가 앞이므로 A는 -1이된다.
		//반면 B는 1이된다.?
		//때문에 오름차순 : 어샌딩소트를 하게되면
		//-1-1 = 음수가 됨다.?
		//반면 내림차순 : 디샌딩소트를 하게 되면
		//1-(-1)이 되므로 양수가 된다.?
		
		int result = price - obj.price;	//가격으로 디샌딩
		//가격이 같으면 모델로 디샌딩
		if(result == 0) return obj.model.compareTo(model);
		return result;
	}
}
