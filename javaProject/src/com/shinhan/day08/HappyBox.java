package com.shinhan.day08;

//네가 타입을 결정해라  <T>
public class HappyBox<T> {
	T kind;	//아무나 와도 됨
	int price;
	
	
	public HappyBox(T kind, int price) {
		super();
		this.kind = kind;
		this.price = price;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Box [kind=" + kind + ", price=" + price + "]";
	}

	
}
