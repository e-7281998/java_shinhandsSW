package com.shinhan.day04;

public class App {

	public static void main(String[] args) {
//		f1();
		
		App aa = new App();
		aa.sum(1,2);	//자동으로 형변환 도미
		sum(1,2,3);
		aa.sum(1.5,2.5);
		
		Integer a = new Integer(100);	//err는 아니고 추천안 함 (옛날에 씀)
		Integer a2 = 100;
		System.out.println(Integer.MAX_VALUE);
	}

	//메서드 Overloading : 메서드 이름은 같고 매개변수 사양이 다르다.
	//가변길이 매개변수,,, 자신과 파라메터의 개수가 같은것이 있으면 그곳으로 가지만, 없다면 가변길이 매개변수가 있는 곳으로 호출된다.
	void sum(int... a){	//or int[] a
		int total = 0;
		for(int su:a) {
			total+=su;
		}
		System.out.println("가변길이 매개변수: "+total);
	}
	//파라메터 자동형변환이 된다.
	//만약 int로 받는 함수가 없다면 그 다음에 있는 double로 받는 함수로 간다.
	//자동으로 형변환을 한다.
	void sum(int a, int b){
		System.out.println("합계 : " + (a+b));
	}
	void sum(double a, double b){
		System.out.println("합계 : " + (a+b));
	}
	static void sum(int a, int b, int c){
		System.out.println("합계 : " + (a+b+c));
	}
	
	private static void f1() {
		Calculator arr[] = new Calculator[4];
		arr[0]= new Calculator("red");	//new하면 heap영역에 인스턴스가 생성됨
		arr[0].setModel("A모델");
		arr[1] = new Calculator("blue");
		arr[2] = new Calculator("B모델", "pink");
		arr[3] = new Calculator("c모델", "vv",52);
		
		for(Calculator cc:arr) {
			print(cc);
		}
	}

	private static void print(Calculator cal) {
		System.out.println(cal.getModel());
		System.out.println(cal.getColor());
		System.out.println(cal.getPrice());
		cal.poweOff();
		//powerOn()은 static으로 선언됨
		//그러므로 인스턴스 소유의 메소드가 아닌, 클래스 소유의 메소드임
		//cal.powerOn();	//틀린것은 아님.
		Calculator.powerOn();
		System.out.println(cal.add(1, 2));
		System.out.println(cal.sub(3, 1));
	}

}
