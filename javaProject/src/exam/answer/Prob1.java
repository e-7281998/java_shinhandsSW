package exam.answer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//정답지
public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}
	
	//방법2 : 정규표현식
	private static void printMaxScore(String[] array) {
		
		int maxScore = 0;
		String maxName = "";
		
		
		for(String str:array) {
//			String regExp = "(([가-힣]+)\d+)점";	//\d는 숫자
			String regExp = "([가-힣]+)([0-9]+)점";
			Pattern pat = Pattern.compile(regExp);
			Matcher mat = pat.matcher(str);
			if(mat.find()) {
				String name = mat.group(1);
				String score = mat.group(2);
//				System.out.println(name);
//				System.out.println(score);

				int iscore = Integer.parseInt(score);
				if(iscore > maxScore) {
					maxScore = iscore;
					maxName = name;
				}
			}
		}
		System.out.println("최고점수는 " +maxName + "님 " + maxScore + "점 입니다.");

	}

	//방법1 : 반복문
	/*
	private static void printMaxScore(String[] array) {
		int maxScore = 0;
		String maxName = "";
		
		for(String str:array) {
			char[] charArr = str.replace("점","").toCharArray();	//문자열을 배열로 바꿔줌
			String name = "";
			String score = "";
			for(char ch:charArr) {
				if(Character.isDigit(ch)) {
					score += ch;
				}else{
					name += ch;
				}
			}
			int n = Integer.parseInt(score);
			if(n > maxScore) {
				maxScore = n;
				maxName = name;
			}
		}
		System.out.println("최고점수는 " +maxName + "님 " + maxScore + "점 입니다.");

	}
	*/
}
