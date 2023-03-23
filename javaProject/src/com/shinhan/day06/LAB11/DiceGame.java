package com.shinhan.day06.LAB11;

//Ex
class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
//		System.out.println(new PracticeRandom());

		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n){	// throws IllegalArgumentException이 없어도 된다 => 런타입 exception이다.
		int count = 0;
		
		try {
			if (n < 0) {
				throw new IllegalArgumentException("던지는 횟수는 음수여야 합니다.");
			}
		}catch(IllegalArgumentException err) {
			System.out.println(err.getMessage());
		}
		
		for(int i=0; i<n; i++) {
				Dice d1 = new Dice(8);
				Dice d2 = new Dice(8);

				int result1 = d1.play();
				int result2 = d2.play();
				
				System.out.println((i+1) +"번째) " + result1 + " / " + result2);

				if (result1 == result2) {
					count++;
				}
				System.out.println("======================");
			}
			
		return count;
	}
}

//Math.random 연습 클래스임.
class PracticeRandom {

	// 0-1사이의 정수
	double a = Math.random();

	// 1-10정수
	int b1 = (int) (a * 10); // 0<= ~ <10
	int b2 = (int) (a * 10) + 1; // 1<= ~ <=10

	{
		System.out.println(a);
		System.out.println(b1);
		System.out.println(b2);
	}
}