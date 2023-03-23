package com.shinhan.day05;
//상속

import java.io.Serializable;
import java.util.Objects;

//부모 class로 사용할 예정
public class Account implements Comparable<Account>, Serializable{	// extends Object 가 기본적으로 상속됨

	//1. field
	private String accNo;
	private String owner;
	private int balance;
	
	//생성자
	//default 생성자는 지우지말고 놔두는 것이 좋음.
	//상속 시 오류 날 수 있음.
	public Account() {
		super();
	}
	
	public Account(String accNo, String owner ) {
//		super();	//이렇게 super()를 사용하지 않아도 자동으로 가장 첫번째로 실행됨.
		this.accNo = accNo;
		this.owner = owner;

	}

	public Account(String accNo, String owner, int balance) {
//		super();	//이렇게 super()를 사용하지 않아도 자동으로 가장 첫번째로 실행됨.
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	//2. 메서드
	public void deposit(int amount) {
		balance += amount;
	}
	
	public int withdraw(int amount) {
		if(amount > balance) {
			System.err.println("잔고 부족");
			return 0;
		}
		balance -= amount;
		return amount;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accNo, balance, owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accNo, other.accNo) && balance == other.balance && Objects.equals(owner, other.owner);
	}

	@Override
	public int compareTo(Account acc) {
		if(this.equals(acc)) return 0;
		
//		return owner.compareTo(acc.owner);
//		return owner.compareTo(acc.owner) * (-1);	//des

		int result = acc.balance - balance;
		if(result == 0) {
			return owner.compareTo(acc.owner) * -1;
		}
		return result;	
	}
	

	
}
