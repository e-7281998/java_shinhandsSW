package com.shinhan.day07.선생님ObjectTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode(of = {"model"})
//@ToString
//위의 것들 한번에 쓰고 싶으면 @Data사용
//@Data 사용에 없으면 따로 추가하기

@Data
@AllArgsConstructor
//@NoArgsConstructor

//maker빼고 같으면 같은거임 : exclude사용해서 그럼
//@EqualsAndHashCode(exclude = ("maker"))

@RequiredArgsConstructor	//필수로 꼭 들어가야해 
public class Computer {
	@NonNull	//null을 허용하지 않아. => model은 필수로 존재해야 해
	private String model;
	private int price;
	private String maker;
}
