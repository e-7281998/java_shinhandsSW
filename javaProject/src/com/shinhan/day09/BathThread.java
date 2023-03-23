package com.shinhan.day09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BathThread extends Thread{
	BathRoom room;
	String userName;
	
	
	//start하면 3번 작동 됨
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			room.use(userName);
		}
	}
	
	
}
