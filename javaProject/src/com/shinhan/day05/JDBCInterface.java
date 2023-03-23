package com.shinhan.day05;

//interface : 규격서 (정의 있고, 구현 없음)
public interface JDBCInterface {
	// 1. 상수 (인터페이스는 변수 사용 불가능)
	public static final String JDBC = "JAVA Database Connection";
	// 다음과 같이 public static final은 생략이 가능
	String JDBC2 = "JAVA Database Connection";

	// 2. 추상메서드 : public abstract 생략 가능
//	void dbConnect(String dbName);
	public abstract void dbConnect(String dbName);

	// 다음과 같이 public abstract void 생략 가능
	void dbConnect2(String dbName);

	// 3. 상위 버전에서 추가됨 : default method, public 생략 가능
	default void select() {
		System.out.println("default method : 인터페이스를 구현한 모든 class의 공통 코드");
		System.out.println("구현 calss에서 재정의 가능");
		insert();
	}

	// 4. 상위 버전에 추가됨 : static method
	// static이므로 interface 소유 : 인터페이스이름.update()로 사용 가능
	static void update() {
		System.out.println("default method : 인터페이스 소유의 코드");
		System.out.println("구현 calss에서 재정의 불가능");
		insert2();
	}

	// 5. private : default에서 호출
	// 인터페이스이름.update()로 사용 가능
	private void insert() {

		System.out.println("==============================");
	}

	// 6. private static : static에서 호출
	private static void insert2() {

		System.out.println("==============================");
	}
}
