package com.shinhan.day09;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumThread extends Thread{
	private long sum;
	private int begin;
	private int end;
	
	public SumThread(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=begin; i<=end; i++) {
			sum += i;
		}
	}
}
