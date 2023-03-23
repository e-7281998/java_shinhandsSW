package com.shinhan.day09;

import lombok.Setter;

@Setter
public class User1Thread extends Thread{
	Calculator calculator;
	public User1Thread() {
		setName("유저1 스레드");
	}
	@Override
	public void run() {
		calculator.setMemeory(100);
	}
}
