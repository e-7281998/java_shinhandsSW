package com.shinhan.day05;

public class AccountTest {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
	}

	private static void f1() {
		Account acc = new Account("112-0525", "shi", 50000);
		acc.deposit(3000);
		int amount = acc.withdraw(50000);
		System.out.println(amount + "출금");
	}

	private static void f2() {
		CheckingAccount acc = new CheckingAccount("112-0525", "kim", 50000, "112-0525");
//		CheckingAccount acc = new CheckingAccount("112-0525", "kim", 50000, "112-5525");	//계좌 불일치
		acc.deposit(0);
		int amount = acc.withdraw(100);
		System.out.println(amount + "출금");

		amount = acc.pay("112-0525", 400);
		System.out.println(amount + "출금");
		System.out.println("잔액은" + acc.getBalance());
	}

	private static void f3() {
		CreditLineAccount acc = new CreditLineAccount("112-0525", "kim", 1000, 500);
		acc.deposit(2000);
		int amount = acc.withdraw(3500);
		System.out.println(amount + "출금");
		System.out.println("잔액은"+acc.getBalance() );

	}

}
