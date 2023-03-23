package com.shinhan.day06;

class Car{
	class Tire{}	//instatnce 클래스
	static class Engine{}	//static 클래스
	void go(int score2) {	//지역 변수는 내부 calss에서 사용되면 final특성을 갖는다.
		int score = 100;
//		score = 300;	//로컬 클래스의 f1에서 사용 불가
//		score2 = 300;	//로컬 클래스의 f1에서 사용 불가
		//내부에서만 클래스 사용 가능
		class LocalClass{
			void f1() {
				//둘 다 final 변수이기 때문에 값 변경 불가.
//				score = 300;
//				score2 = 400;
				System.out.println(score);
				System.out.println(score2);
			}
		}
		LocalClass v1 = new LocalClass();
		System.out.println(v1);
		v1.f1();
	}
}

public class Quiz09_4_Car {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.go(800);
		
		Car.Tire v2 = new Car().new Tire();
		Car.Engine v3 = new Car.Engine();
	}
}
