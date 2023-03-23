package com.shinhan.day06;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		Button b1 = new Button();
		Button b2 = new Button();
		
		Button.ClickListener listener1 = new OkayListener();
		Button.ClickListener listener2 = new CancelListener();
		test(b1, listener1);
		test(b2, listener2);
//		Button.ClickListener listener = new OkayListener();
//		b1.setListener(listener);
//		b1.buttonClick();
//		
//		Button.ClickListener listener2 = new CancelListener();
//		b1.setListener(listener2);
//		b1.buttonClick();
		
	}
	
	static void test(Button b1, Button.ClickListener listener) {
		b1.setListener(listener);
		b1.buttonClick();
	}

}
