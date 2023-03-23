package com.shinhan.day08.확인문제;

public class Util<K, V> {
	K key;
	V value;
	
	public Util(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public static <K, V> V getValue(Pair<K, V> pair, K key) {
		if(pair.getKey().equals(key))	return pair.getVlaue();
		return null;
	}
	
	public static< P extends Pair<K,V>, K,V> V getValue2(P pair, String key) {
		if(pair.getKey().equals(key))	return pair.getVlaue();
		return null;
	}
	
}
