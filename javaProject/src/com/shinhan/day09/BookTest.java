package com.shinhan.day09;

class Box {

}

public class BookTest {
	public static void main(String[] args) {
		Book<String> b0 = new Book<String>("이것이자바다", 30000, "퍼스트존", new String[] { "진기", "태민" });
		Book<String> b1 = new Book<String>("이것이자바다", 30000, "퍼스트존", new String[] { "진기", "태민" });
		Book<Integer> b2 = new Book<>(999, 30000, "퍼스트존", new String[] { "진기", "태민" });
		Book<Box> b3 = new Book<Box>(new Box(), 30000, "퍼스트존", new String[] { "진기", "태민" });
		Book<String> b4 = Book.makeBook("스킓트", 25000);
		Book<Box> b5 = Book.makeBook(new Box(), 5000);
		
		int result = b1.compareTo(b4);
		System.out.println(result);
		
		System.out.println(b1.equals(b0));
		System.out.println(Book.getCount());
	}
}
