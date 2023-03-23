package exam;

//완료
public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung",10,'#'));
		System.out.println(leftPad("SDS",5,'*'));
		System.out.println(leftPad("Multicampus",5,'@'));
		
	}

	 

	public static String leftPad(String str, int size, char fillChar){
		int strLen = str.length();
		String answer = "";
		if(size < strLen) {
			return new IllegalSizeException().msg();
		}
		for(int i=0; i<size-strLen; i++) {
			answer+=fillChar;
		}
		answer+=str;		
		return answer;
	}

	
	
}

class IllegalSizeException  {
	String msg(){
		return "문자열의 길이보다 size가 큽니다.";
	}
}



