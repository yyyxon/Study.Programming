package day0703;

public class Test {

	public static void main(String[] args) {

		String str = "오늘은 ";
		str+="7월의 첫 월요일 ";
		str+="아 덥다~~~ ";
		str+="이번 주 수요일은 휴강^.^b";
		
		System.out.println(str+"포항항");
		//String의 경우 str 하나만 사용하는 것 같지만
		//+= 을 할 때마다 새로운 StringBuilder 객체가 생성됨
		
		StringBuilder sb = new StringBuilder("오늘은 ");
		sb.append("7월의 첫 월요일 ");
		sb.append("아 덥다~~~ ");
		sb.append("이번 주 수요일은 휴강^.^b");
		System.out.println(sb.append("포항항"));
		
	}//main

}//class
