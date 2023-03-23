package exam.answer;

//정답
public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {
		int strLen = str.length();
		String answer = "";
		try {
			if (size <= strLen) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			}
			for (int i = 0; i < size - strLen; i++) {
				answer += fillChar;
			}
			answer += str;

		} catch (IllegalSizeException ex) {
			System.out.println(ex.getMessage());
		}

		return answer;
	}

}

class IllegalSizeException extends Exception {
	String result = "";

	IllegalSizeException(String message) {
		super(message);
	}
}
