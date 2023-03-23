package com.shinhan.day05;

//modifier의 종류
//접근권한: public, protected, 생략, private 中 1
//활용방법: static, final :여러개 선택O
public class Student{ // extends Object
	//1. field (: 데이터 저장하기 위한 변수들 정의) : instance변수(개인사용), staic변수(같이사용)
	private String stdId;	//private: Student class내에서만 접근가능
	public String name;		//public: 모든 package에서 접근가능
	String major;			//생략: 같은 package에서 접근가능
	protected int score;	//protected: 같은 package는 접근가능, 다른 package이면 자식은 접근 가능
	final String school = "신한금융대학";	//final: 초기화가 1회 (선언시, 생성시)
//	final String school;	//위처럼 선언시 초기화 하지 않았다면 생성할때 필수, 생성할때 하지 않으면 오류.
	public final static String NATION = "대한민국";	//final static : 상수, class변수, 초기화 1회 (선언시), 대문자
	public static int count;		//class 변수
	
	public Student(String stdId, String name) {
		//default 생성자는 컴파일시 자동으로 .class에 추가된다. 재정의하면 생성안됨
//		super();	//부모는 한번만 호출할 수 있음. this()를통해 이미 불렀기 때문에 이곳에선 호출 불가.
//		school = "신한금융대학";		
		this(stdId, name, null, 0);
	}
	
	public Student(String stdid, String name, String major) {
		this(stdid, name, major, 0);
	}

	public Student(String stdId, String name, String major, int score) {
		super();	//Object 상속받고 있는 중.	//코드를 생략해도 존재함. //맨 처음에만 호출 가능.
		this.stdId = stdId;
		this.name = name;
		this.major = major;
		this.score = score;
		count++;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public String getSchool() {
		return school;
	}

	public static String getNation() {
		return NATION;
	}

	@Override
	public String toString() {
		return "Student 정보 [stdId=" + stdId + ", name=" + name + ", major=" + major + ", score=" + score + ", school="
				+ school + "]";
	}
	
	
	
}
