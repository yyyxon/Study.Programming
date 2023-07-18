package day0703;

import java.util.StringTokenizer;

public class UseStringTokenizer {
	
	public UseStringTokenizer() {
		
		String data = "Java, Oracle.JDBC, HTML.CSS, JavaScript";
		
//		StringTokenizer stk = new StringTokenizer(data); //공백을 기준으로 토큰을 생성
		//토큰으로 구분된 문자열은 사라진다. 기준 문자열은 OR 기능이 있다. 기준 문자열 여러개 작성가능
		StringTokenizer stk = new StringTokenizer(data,"., a"); //입력된 문자열로 토큰을 생성
		
		//기준 문자열 보호 true - 기준 문자열 토큰으로 보호(기준 문자열이 사라지지않음)
		//			  false - 기준 문자열을 버림
		
		System.out.println("토큰의 수 : " + stk.countTokens());
		//countTokens는 nextToken()할 때마다 줄어듦
		//데이터를 저장하지않으므로 인덱스가 없음				
		String value = "";
		while(stk.hasMoreTokens()) {
			value = stk.nextToken();
			System.out.println(value);
		}
		System.out.println("토큰의 수 : " + stk.countTokens());
		
		
	}//UseStringTokenizer
	
	public static void main(String[] args) {

		new UseStringTokenizer();
		
	}//main

}//class
