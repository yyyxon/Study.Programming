package day0814;

import java.sql.Connection;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class UseSingle {

	public static void main(String[] args) {
		//Sigleton Pattern이 적용된 클래스 사용
		//하나의 객체만 생성됨
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		Singleton single3 = Singleton.getInstance();
		
		//Singleton st = new Singleton(); //직접 객체화 불가능
		
		System.out.println(single + " / " + single2);
		
		try {
			Connection con = DbConn.getInstance().getConnection("localhost", "scott", "tiger");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
