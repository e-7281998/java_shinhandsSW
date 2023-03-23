package com.shinhan.day07;

import java.util.Objects;

public class ProdectVO {
	private String name;
	private int price;
	private String maker;

	public ProdectVO(String name, int price, String maker) {
		this.name = name;
		this.price = price;
		this.maker = maker;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", maker=" + maker + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maker, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		//p1.equals(p2)으로 호출했을 경우
		//this = p1, obj = p2 
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdectVO other = (ProdectVO) obj;
		return Objects.equals(maker, other.maker) && Objects.equals(name, other.name) && price == other.price;
	}

}
