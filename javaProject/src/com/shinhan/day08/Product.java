package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString	//얘 덕분에 객체의 주소가 뜨는 것을 방지해줌 
//@EqualsAndHashCode //얘 덕분에 내용을 비교할 수 있음
@EqualsAndHashCode(of = ("kind")) //kind가 같으면 같음 : return true;
@Getter
@Setter
public class Product<T, M> {
	T kind;
	M model;
}
