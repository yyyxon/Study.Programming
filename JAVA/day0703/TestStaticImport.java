package day0703;

import static java.lang.Integer.MAX_VALUE;
//import static java.lang.Long.MAX_VALUE; //같은 이름의 상수나 변수는 하나만 선언 가능
import static java.lang.Integer.parseInt;

/**
 * static import <br>
 * 다른 클래스의 static 변수, 상수, static method를 
 * 클래스명 없이 바로 사용할 때
 * @author user
 */
public class TestStaticImport {

	public static void main(String[] args) {
		
		System.out.println(MAX_VALUE);//클래스명 없이 constant 사용
		System.out.println(Integer.parseInt("10"));
		System.out.println(parseInt("20")); //클래스명 없이 method사용
		System.out.println(parseInt("30"));
		System.out.println(parseInt("40"));

	}//main

}//class
