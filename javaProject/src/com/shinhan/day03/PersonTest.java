package com.shinhan.day03;

public class PersonTest {

	public static void main(String[] args) {
//		Person person1 = new Person();
//		Person person2 = new Person("철수", 3);
//
//		person1.selfIntroduce();
//		person2.selfIntroduce();
		
//		System.out.printf("전체 인구수는 %d명 입니다.", Person.getPopulation());

		Person persons[] = new Person[2];
		persons[0] = new Person();
		persons[1] = new Person("기범", 33);
		
		for(Person p:persons) {
			p.selfIntroduce();
		}
		
		System.out.printf("전체 인구수는 %d명 입니다.", Person.getPopulation());

	}
}
