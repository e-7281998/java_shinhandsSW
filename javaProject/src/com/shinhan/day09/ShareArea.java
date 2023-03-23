package com.shinhan.day09;

import com.shinhan.day05.Account;

import lombok.AllArgsConstructor;

//공유 자원으로 이용할 클래스
//계좌가 2개 있다.
@AllArgsConstructor
public class ShareArea {
	Account sung;
	Account lee;
	
//	public ShareArea(Account sung, Account lee) {
//		super();
//		this.sung = sung;
//		this.lee = lee;
//	}
	
	void transfer() {
	//synchronized block 이용
		synchronized (this) {
			//출금한다.
			int amount = lee.withdraw(100);
			System.out.println("Lee 계좌에서 "+amount+"원 출금");
			//입금한다.
			sung.deposit(amount);
			System.out.println("Sung 계좌에" + amount+ "원 입금");
		}	}

	//메서드의 활용방법: synchronized 이용
	synchronized void printBalance() {
		//잔액출력
		System.out.println("잔액: " + (lee.getBalance() + sung.getBalance()));

	}
	
}
