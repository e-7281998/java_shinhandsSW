package com.shinhan.day03;

public class EnumTest {

	// 상수 : 변하지 않는 값
	final static double PI = 3.141592;
	static final int MONDAY = 1;
	static final int SUNDAY = 2;
	static final int SUCCESS = 2;

	public static void main(String[] args) {
//		f1();
//		f2(LoginEnum.SUCCESS);
		f3();

	}

	private static void f3() {
		WeekEnum[] weecks =  WeekEnum.values();	//값들을 다 가져와라
		for(WeekEnum week:weecks) {
			System.out.println(week.ordinal() + " = >"+week.name());
//			String weekName = f4(week);
			String weekName = f5(week);
			System.out.println(weekName);
			System.out.println("**********");
		}
	}

	private static String f5(WeekEnum week) {

		String result = null;
		
		//enum으로 switch문장 사용시에는 WeeckEnum.MONDAY로 사용하지 않아도 된다.(데이터 타입 명시 안해도 됨)
		//이미 WeekEnum type으로 사용중이기 때문이다.
		switch (week) {
		case MONDAY:
			result = "월요일";
			break;
		case TUSEDAY:
			result = "화요일";
			break;
		case WENDESDAY:
			result = "수요일";
			break;
		case THURSDAY:
			result = "목요일";
			break;
		case FRIDAY:
			result = "금요일";
			break;
		case SATURDAY:
			result = "토요일";
			break;
		case SUNDAY:
			result = "일요일";
			break;
		default:
			break;
		}
		return result;
	}

	private static String f4(WeekEnum week) {
		String result = null;

		if (week == WeekEnum.MONDAY) {
			result = "월요일";
		} else if (week == WeekEnum.TUSEDAY) {
			result = "화요일";
		} else if (week == WeekEnum.WENDESDAY) {
			result = "수요일";
		} else if (week == WeekEnum.THURSDAY) {
			result = "목요일";
		} else if (week == WeekEnum.FRIDAY) {
			result = "금요일";
		} else if (week == WeekEnum.SATURDAY) {
			result = "토요일";
		} else if (week == WeekEnum.SUNDAY) {
			result = "일요일";
		}

		return result;
	}

	private static void f2(LoginEnum login) {
		System.out.println(login == LoginEnum.SUCCESS);
		System.out.println(login == LoginEnum.FALSE);

		LoginEnum arr[] = LoginEnum.values();
		for (LoginEnum aa : arr) {
			// ordinal은 선언한 순서
			System.out.println(aa.ordinal() + " == " + aa.name());
		}
	}

	private static void f1() {
		System.out.println(PI);
		int input = 2;
		System.out.println(input == SUNDAY);
	}

}
