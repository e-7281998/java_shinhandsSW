package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"subject", "writer"})
public class Board implements Comparable<Board>{
	private int boardNo;
	private String subject;
	private String content;
	private String writer;
	
	@Override
	public int compareTo(Board board) {
		int result1 = subject.compareTo(board.subject);	//어샌딩
		int result2 = writer.compareTo(board.writer);	//어샌딩
		if(result1 == 0) {
			//다음을 포함하면 중복 허용됨
			if(result2 == 0) return boardNo - board.boardNo;
			return result2;
		}

		return result1;
	}
	
	
}
