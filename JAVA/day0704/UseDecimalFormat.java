package day0704;

import java.text.DecimalFormat;
import static java.lang.Long.MAX_VALUE; //class명만 쓰고 컨트롤+스페이스!

public class UseDecimalFormat {

	public UseDecimalFormat() {
		//JDK1.7에서부터 숫자에 구분자로 언더바를 사용할 수 있다.(출력x)
		int i = 2_147_483_647;
		System.out.println(i);
		
		i = 2023;
		//Letter 0 : 해당 자리에 데이터가 없으면 0을 채워서 반환
		DecimalFormat df = new DecimalFormat("0,000,000");
		System.out.println(df.format(i));
				
		//Letter # : 데이터가 있는 것까지만 출력
		DecimalFormat df2 = new DecimalFormat("#,###,###");
		System.out.println(df2.format(i));
		
		//실수의 자릿수 설정 -> 0,# 상관없음! 섞어서도 가능
		double d = 2023.1234;
		DecimalFormat df3 = new DecimalFormat("#,###,###.###");
		System.out.println(df3.format(d));
		
		//MAX_VALUE는 9223372036854775807을 가지고 있다.
		//DecimalFormat 사용하여 3자리마다 ,를 넣어 출력하세요.
		long l = MAX_VALUE;
		DecimalFormat df4 = new DecimalFormat(",###");
		System.out.println(df4.format(l));
		
	}
	
	public static void main(String[] args) {
		
		new UseDecimalFormat();

	}

}
