package com.shinhan.day06.복습;

public class LabelTest {

	public static void main(String[] args) {
		Label v1 = new Label(20, 5, "black", "small", "이름입력");
		Resizable v2 = new Label(20, 5, "black", "small", "이름입력");
		Colorable v3 = new Label(20, 5, "black", "small", "이름입력");
		Changeable v4 = new Label(20, 5, "black", "small", "이름입력");
		
		work(v1);
//		work(v2);
//		work(v3);
		work(v4);
	}
	
	//자동 형변환  부모타입 객체 잠조변수 - 자식객체
	static void work(Changeable aa) {
		if(aa instanceof Label label) {
			label.setBackground("yello");
			label.setBackground(null);
			label.setBackground(null);
		}
	}

}
