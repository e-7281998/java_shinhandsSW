package com.shinhan.day09;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"title", "price"})	//동등비교(기본: 주소, 재정의:내용)  //동일하다고 판별할 조건(of) : 배열로 저장됨
//'틀'에는 데이터 저장하지 않음.
public class Book<T> extends Object implements Comparable<Book>{	//기본적으로 Object를 상속 : Object의 기능 사용 가능
	//private : 외부로부터 정보은닉
	private T title;
	private int price;
	private String publisher;
	private String author[];
	private static int count;	//static : 공용으로 사용	//롬복 게터에 만들어지지 않음
	//final : 최후의 값 : 값 수정 불가	
//	private final String company; //static 없으므로 생성자 소유, 생성시 초기화 해도 됨.
	private static final String COMPANY = "신한출판사";	//static이 있으면 무조건 초기화 필요.
	
	//static이므로 new안했을 때 T타입이 정해져야 함.
	//그러나 사용할때 정할 것이므로 리턴 타입 앞에 <T>을 사용함 : T는 사용할 때 결정할 것임을 알림
	public static <T> Book<T> makeBook(T title, int price) {
//		new Book();
		//new String[] 하는 이유 : 변수를 따로 안줬기 때문
		return new Book(title, price, "홍대 출판사", new String[] {"기범", "민호"});
	}
	
	//롬복의 어노테이션 이용했음.
	//deault 생성자	
	public Book(){ 
	}
	
	public Book(T title, int price, String publisher, String[] author) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.author = author;
		count++;
	}
	

	//static 없음 : 인스턴스 소유
	/*
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String[] getAuthor() {
		return author;
	}
	public void setAuthor(String[] author) {
		this.author = author;
	}
	*/
	
	//static 있음 : 클래스 소유
	public static int getCount() {
		return count;
	}
	/*
	public static void setCount(int count) {
		Book.count = count;
	}
	public static String getCompany() {
		return COMPANY;
	}
	*/
	
	/*
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", publisher=" + publisher + ", author="
				+ Arrays.toString(author) + "]";
	}
	*/
	
	/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return price == other.price && Objects.equals(title, other.title);
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, title);
	}
	
	*/
	
	@Override
	public int compareTo(Book obj) {
		return price - obj.price;	//음수면 : 앞에것이 더 작음 : 호출한애가 작음
	}
	
}
