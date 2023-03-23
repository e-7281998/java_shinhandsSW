package com.shinhan.day04;

public class PlayBird {

	public static void main(String[] args) {
		Duck duck = new Duck("꽥꽥이", 2, 15);
		duck.fly();
		duck.sing();
		duck.display();

		Sparrow sparrow = new Sparrow("짹짹이", 2, 15);
		sparrow.fly();
		sparrow.sing();
		sparrow.display();
		
		System.out.println(duck);
		System.out.println(duck.toString());

	}

}
