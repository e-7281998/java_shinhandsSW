package com.shinhan.day08;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target은 적용받을 대상을 정한다.
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default "-";	//value는 기본으로 설정되며, default로 -를 설정해놓은 것임.
	int number() default 7;	//기본으로 7이 찍힘
	 String ej() default "쩡";	//ej을 만든 것임.
	
}
