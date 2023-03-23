package com.shinhan.day06;

public class ExceptionTest2 {

//	public static void main(String[] args) throws Exception{
//위와 같이 사용하면 내가 에러처리 안하고 에러 던짐(?) : throws Exception
	
public static void main(String[] args) throws Exception{
		//Exception : 자동으로 발생, 강제로 발생
//		int a = 10/0;	//자동으로 예외처리 발생
		String pass = "123456";
		
		char ch = pass.charAt(0);
		try {
			if(ch < 'A' || ch > 'Z') {
				//만약 LogrinException에서 
				//RuntimeException일 경우에는 컴파일 시 오류 안남.
				//에러나면 Exception객체 만들어진다. 우리가 강제로 만드는 것이므로
				//new를 통해 Exception객체를 만들어주고 사용하는 것이다.
				throw new LoginException("대문자로 시작해야 한다");
			}
		}catch(LoginException err) {
//			System.out.println(err.getMessage());
			err.printMessage();
		}
		System.out.println("main end");
	}

}
