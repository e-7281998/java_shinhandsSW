package com.shinhan.day08.확인문제;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Container2<K, V> {
	K key;
	V value;
	
	Container2(){
		
	}

	public Container2(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	void set(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
}
