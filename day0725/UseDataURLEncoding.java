package day0725;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseDataURLEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String msg =  "오늘은 후덥지근한 화요일"; 
		//일반문자열 => 사람이 볼 수 있으나 패킷에 실을 수 없음
		String encode = ""; 
		try{
			System.out.println("일반 문자열 : " + msg);
			encode = URLEncoder.encode(msg,"UTF-8");//패킷에 실을 수 있도록 encoding
			System.out.println("encode된 문자열 : " + encode);
			String decode = URLDecoder.decode(msg, "UTF-8");
			System.out.println("decode된 문자열 : " + decode);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}//main
	
}//class
