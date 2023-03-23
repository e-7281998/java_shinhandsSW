package com.shinhan.day04;	//내것

import java.util.Arrays;	//남의 것

//Service : Business logic 구현 : 업무로직이 구현 된 것
public class BookService {
	BookVO bookList[];
	
	public BookService(BookVO bookList[]) {
		this.bookList = bookList;
	}
	
	public void printBookList(){
		System.out.println("=== 책 목록 ===");
		for(BookVO book:bookList) {
			//System.out.println(book.getTitle());
			
			//***다음 주석은 내가 설명 듣고 쓴 것
			//배열을 찍는게 아닌 BookVO를 출력하는 것임.
			//BookVO형의 인스턴스를 찍으면 toString이 오버라이드 되어있으므로 정해진대로 찍히는 것임
			
			System.out.println(book);
		}
	}
	
	public void printTotalPrice() {
		System.out.println("=== 책 가격의 총합 ===");
		int total = 0;
		for(BookVO book:bookList) {
			total += book.getPrice();
		}
		System.out.println("전체 책 가격의 합:" + total);
	}

}
