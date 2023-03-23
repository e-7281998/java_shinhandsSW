package ch01.verify;

public class Example {

	public static void main(String[] args) {
		f4();
		
	}

	private static void f4() {
		String str = "5";
//		int var = Int.parseInt(str);	//Integer로 사용해야 함.
	}

	private static void f3() {
		byte byteValue = 10;
		float floatValue = 2.5f;
		double doubleValue = 2.5;
		
//		byte result = byteValue +byteValue;
		int result2 = 5 + byteValue;
		float result3 = 5 + floatValue;
		double result4 = 5 + doubleValue;
	}

	private static void f2() {
		int intValue = 10;
		char charValue = 'A';
		double doubleValue = 5.7;
		String strValue = "A";
		
		double var = (double) intValue;
		byte var2 = (byte) intValue;
		int var3 = (int) doubleValue;
//		char var4 = (char) strValue;
	}

	private static void f1() {
		byte byteValue = 10;
		char charValue = 'A';
		
		int intValue = byteValue;
//		int intValue = charValue;
//		short shortValue = charValue;
		double doubleValue = byteValue;
		}
	

}
