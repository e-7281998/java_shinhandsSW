package exam.answer;

import java.util.Arrays;

//완료
public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		
		
		//방법1
		Arrays.stream(answer).forEach(value -> counter[value-1]+=1);
		
		//방법2
		/*
		for(int num: answer) {
			counter[num-1]++;
		}
		*/
		for(int i=0; i<counter.length; i++) {
			System.out.println((i+1) +"의 갯수는 " + counter[i] + "개 입니다.");
		}
	}
}
