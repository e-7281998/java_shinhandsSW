package com.shinhan.day09;

import lombok.Getter;

@Getter
public class Calculator {
	int memeory;

	public void setMemeory(int memeory) {
		synchronized (this) {
			this.memeory = memeory;
			System.out.println(Thread.currentThread().getName() + " ==> 메모리 저장값 : " + this.memeory);

		}
	}
/*
	public synchronized void setMemeory(int memeory) {
		this.memeory = memeory;
		System.out.println(Thread.currentThread().getName() + " ==> 메모리 저장값 : " + this.memeory);
	}
*/
}
