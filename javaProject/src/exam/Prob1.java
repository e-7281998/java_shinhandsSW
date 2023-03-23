package exam;

import java.util.Arrays;

//완료
public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		int jumsu = 0;
		String mainName = "";
		
		for (int i = 0; i < array.length; i++) { // 학생 1명 추출
			String name = "";
			String score = "";

			for (int j = 0; j < array[i].length(); j++) { // 학생 1명 길이
				char n = array[i].charAt(j);

				if (n >= '0' && n <= '9') { // 숫자 체크
					score += n;
				} else {
					name += n;
				}
			}
			
			if(jumsu < Integer.parseInt(score)) {
				mainName = name.replace("점","");
			}
			jumsu = Math.max( Integer.parseInt(score), jumsu);
		}
		System.out.println("최고점수는 " + mainName + "님 " + jumsu + "점 입니다.");

	}
}
