package exam;

import java.util.Arrays;

//완료
public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		
		for(int i=0; i<counter.length; i++) {
			int cnt = 0;
			for(int j=0; j<answer.length; j++) {
				if(answer[j] == (i+1)) {
					cnt++;
					counter[i] = cnt;
				}
			}
			System.out.println((i+1)+ "의 갯수는 "+cnt+"개 입니다.");
		}
	}
}
