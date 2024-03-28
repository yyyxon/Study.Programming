package day0720;

import java.io.Serializable;

import day0627.Clark;
import day0627.Person;

/**
 * instanceof
 * 객체가 어떤 클래스에서 생성되었는지 비교하는 연산자
 * @author user
 */
public class UseInstanceof {

	public void usePerson(Object obj) {
		if(obj instanceof Person) {
			//obj가 Person 객체인지
			System.out.println("Person으로 생성된 객체");
		}else {
			System.out.println("Person과 상관없는 객체");
		}//end else
	}//userPerson
	
	public void useSerializable(Object obj) {
		if(obj instanceof Serializable) { 
			System.out.println("객체 직렬화 가능");
		}else {
			System.out.println("객체 직렬화 불가능");
		}//end else
	}//userPerson

	public static void main(String[] args) {
		UseInstanceof ui = new UseInstanceof();
		Clark cl = new Clark();
		ui.usePerson(cl);
		day0629.Clark cl2 = new day0629.Clark();
		ui.usePerson(cl2);
		
		System.out.println("---------------------------------");
		
		String str = "오늘 점심은 뭐먹지?";
		ui.useSerializable(str);
		Object obj = new Object();
		ui.useSerializable(obj);
		
	}//main

}
