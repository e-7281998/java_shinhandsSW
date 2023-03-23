package com.shinhan.day06;

//사용자 정의 예외
//만드는 이유 : 업무상 Exception처리를 일관성 있게 하기 위해서 만든다.
//extends Exception을 상속 받는다. : 일반적일때
//RuntimeException만들면 컴파일시 X, 실행시 오류 잡는다.
//extends 상위Exception
public class LoginException extends Exception{
//	String errMsg;
	public LoginException(String errMsg) {
//		this.errMsg = errMsg;	//굳이 할 필요 없음
		super(errMsg);	//Exception(부모)에 보내서 자동으로 넣어줌	//getMessage()로 출력 가능.
		//위와 같이 호출하는 것을 명시적으로 호출한다고 한다.
	}
	
	public void printMessage() {
		System.out.println("로그인 : " + getMessage());
	}
}
