package com.shinhan.day08.ch12LAB2;

//문제 4번
public class Money {
	int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Money add(Money money) {
		return new Money(this.amount + money.amount);
	}

	public Money minus(Money money) {
		return new Money(this.amount - money.amount);
	}

	public Money multiply(Money money) {
		return new Money(this.amount * money.amount);	
		}

	public Money devide(Money money) {
		return new Money(this.amount / money.amount);
//		return new Money(amount / money.amount);	//this 생략 가능
	}

	public boolean equals(Object object) {
//		if(!(object instanceof Money money))	return false;
//		return this.amount == money.amount;

		//자동 완성되는 코드와 똑같이 구현해봄.
		//위위 코드도 가능 (내가 한거)
		if(this == object) return true;
		if(object == null || getClass() != object.getClass())	return false;
		return amount == ((Money)object).amount;
		
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + "]";
	}

	public static void main(String[] args) {
		Money five = new Money(5);
		Money two = new Money(2);
		Money three = new Money(3);
		Money ten = new Money(10);
		
		System.out.println(five);
		System.out.println(two.add(three));

		if (five.equals(two.add(three)) && three.equals(five.minus(two)) && ten.equals(five.multiply(two))
				&& two.equals(ten.devide(five))) {
			System.out.println("Money Class 구현을 완료 하였습니다.");
		}
	}

}
