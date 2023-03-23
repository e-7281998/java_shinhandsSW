package com.shinhan.day05;

public class CreditLineAccount extends Account {

	int creditLine;

	public CreditLineAccount(String accNo, String owner, int balance, int creditLine) {
		super(accNo, owner, balance);
		this.creditLine = creditLine;
	}

	// override(덮어쓰기, 재정의) : 시그니처가 같아야 한다.
	// 이름, 매개변수, return type 모두 같아야 한다.
	// modifier는 같거나 더 넗어야 한다.
	
	public void deposit(int amount) {
		//내가 오버라이드한 것 수행하고, 부모것 수행해
		System.out.println("입금하다 ... override test");
		super.deposit(amount);
	}

	@Override // 오버라이드 한 것이 맞는지 확인해줌, 생략 가능
	public int withdraw(int amount) {
		// super.~은 부모의 메소드를 호출
//		return super.withdraw(amount);

		int total = getBalance() + creditLine;
		if (amount > total) {
			System.err.println("잔고 부족");
			return 0;
		}
		setBalance(getBalance() - amount);
		return amount;
	}

	void test() {
		System.out.println(getAccNo());
		System.out.println(getOwner());
		System.out.println(getBalance());

	}
}
