package com.shinhan.day09;

import lombok.Setter;

@Setter
public class User2Thread extends Thread{
	Calculator calculator;
	public User2Thread() {
		setName("유저2 스레드");
	}
	@Override
	public void run() {
		calculator.setMemeory(50);
	}
}
