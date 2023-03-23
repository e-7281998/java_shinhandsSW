package com.shinhan.day03;

public class Account {
	private String accNo;
	private int balance;
	

	Account(String accNo, int balance){
		this.accNo = accNo;
		this.balance = balance;
		System.out.printf("%s 계좌가 개설되었습니다.\n",accNo);
		save();
	}
	
	void save() {
		System.out.println(accNo+ " 계좌의 잔고는"+ balance+ "원 입니다.");
		System.out.println("=============================");
	}
	
	//gether : 외부에서 값을 읽어가도록. 값을 바꿀 수는 없도록
	public int getBalance (){
		return balance;
	}
	
	String getAccNo() {
		return accNo;
	}
	
	void deposit(int amount) {
		balance += amount;
		System.out.println(accNo+ " 계좌에 "+ amount+ "원이 입금되었습니다.");
		save();
	}
	
	void withdraw(int amount) {
		balance -= amount;
		System.out.println(accNo+ " 계좌에 "+ amount+ "원이 출금되었습니다.");
		save();
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}
	
	

}
