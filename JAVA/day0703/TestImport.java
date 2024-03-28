package day0703;

//import 단축어 : ctrl+shift+o
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Date; //이름이 같고 패키지가 다르다면 둘 중 하나만 import가능

/**
 * import 연습
 * @author user
 */
public class TestImport {

	public static void main(String[] args) {
		//TestImport 클래스가 존재하는 패키지에 Date 클래스가 없으므로 err
		//Date d; //Date 클래스를 사용하는 패키지에 Date 클래스가 있어야 사용 가능함
				  // -> import를 사용
		
		Date d = null;
		java.sql.Date d2 = null; //sql의 Date 사용
		
		//import를 정의하지 않으면 full path로 처리할 수 있음
		//full path : 클래스가 사용될 때마다 패키지를 명시하는 것 -> 패키지명.클래스명 객체명 = ...
		java.awt.List List = new java.awt.List();
		
		SimpleDateFormat sdf = null;
		DecimalFormat df = null;
		
		
	}//main

}//class
