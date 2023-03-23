package com.shinhan.day09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용을 저장압니다.");
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
}
