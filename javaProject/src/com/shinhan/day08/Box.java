package com.shinhan.day08;

//제네릭 적용 안함
public class Box {
	Object kind;	//아무나 와도 됨
	int price;
	
	
	public Box(Object kind, int price) {
		super();
		this.kind = kind;
		this.price = price;
	}

	public void setKind(Object kind) {
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
