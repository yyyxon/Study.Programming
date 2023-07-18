package day0703;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseDate {

	public UseDate() {
		//1.생성
		Date date = new Date();
		System.out.println(date);
		//2.method로 일을 함
		//System.out.println(date.getYear()+1900);
		//비추천 method는 가급적 사용하지 않는다.
	}//UseDate
	
	@Override
	public String toString() {
		return "더이상의 주소는 생략한다.";
	}

	public static void main(String[] args) {
		UseDate ud = new UseDate();
		System.out.println(ud.toString());
	}//main

}//class
