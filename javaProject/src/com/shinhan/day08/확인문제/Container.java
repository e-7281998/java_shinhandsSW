package com.shinhan.day08.확인문제;


public class Container<T> {
	T data;
	
	public Container() {

	} 

	public Container(T t) {
		super();
		this.data = data;
	}
	
	public void set(T data) {
		this.data = data;
	}
	
	public T get(){
		return data;
	}
}
