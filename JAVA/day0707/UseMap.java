package day0707;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UseMap {

	public void useHashtable() { //동기화o 동시접근x 속도느림
		//1.생성 : 11개의 행이 자동 생성
		Map<String, String> map = new Hashtable<String, String>();
		//2.값 할당
		map.put("java", "완벽한 OOP언어"); //WORA
		map.put("oracle", "대용량 데이터베이스");
		map.put("HTML", "Hyper Text Markup Language");
		map.put("CSS", "HTML design");
		
		//키가 같으면 기존 키에 덮어쓴다.
		map.put("HTML", "Tim berners'Lee가 고안한 웹 언어");
		
		//키가 존재하는지
		System.out.println("키가 존재? " + map.containsKey("java"));
		//대소문자 구분
		System.out.println("키가 존재? " + map.containsKey("Oracle"));
		
		//값 얻기
		System.out.println("대응하는 값 : " + map.get("java"));
		System.out.println("대응하는 값 : " + map.get("Oracle"));
		
		//모든 키 얻기
		Set<String> keySet = map.keySet();
		System.out.println("모든 키 얻기 : " + keySet);
		
		//모든 값 얻기
		Iterator<String> ita = keySet.iterator();
		String key;
		while(ita.hasNext()) {//ita로 key를 얻고 get method로
			key = ita.next(); //포인터는 next할 때마다 이동함
			System.out.printf("%s : %s\n",key,map.get(key));
		}
		
		//값 삭제
		map.remove("CSS");
		//map.clear(); //전체 삭제
		
		//순차적으로 입력되지않음
		System.out.println(map + " / " + map.size());
		
	}//useHashtable
	
	public void useHashMap() { //동기화x 동시접근o 속도빠름
		//Hashtable과 사용방법 동일
		//1.생성 : 11개의 행이 자동 생성
		Map<String, String> map = new HashMap<String, String>();
		//2.값 할당
		map.put("java", "완벽한 OOP언어"); //WORA
		map.put("oracle", "대용량 데이터베이스");
		map.put("HTML", "Hyper Text Markup Language");
		map.put("CSS", "HTML design");
		
		//키가 같으면 기존 키에 덮어쓴다.
		map.put("HTML", "Tim berners'Lee가 고안한 웹 언어");
		
		//키가 존재하는지
		System.out.println("키가 존재? " + map.containsKey("java"));
		//대소문자 구분
		System.out.println("키가 존재? " + map.containsKey("Oracle"));
		
		//값 얻기
		System.out.println("대응하는 값 : " + map.get("java"));
		System.out.println("대응하는 값 : " + map.get("Oracle"));
		
		//모든 키 얻기
		Set<String> keySet = map.keySet();
		System.out.println("모든 키 얻기 : " + keySet);
		
		//모든 값 얻기
		Iterator<String> ita = keySet.iterator();
		String key;
		while(ita.hasNext()) {//ita로 key를 얻고 get method로
			key = ita.next(); //포인터는 next할 때마다 이동함
			System.out.printf("%s : %s\n",key,map.get(key));
		}
		
		//값 삭제
		map.remove("CSS");
		//map.clear(); //전체 삭제
		
		//순차적으로 입력되지않음
		System.out.println(map + " / " + map.size());
	}//useHashMap
	
	public static void main(String[] args) {

		UseMap um = new UseMap();
		um.useHashtable();
		System.out.println("---------------------------");
		um.useHashMap();
			
	}//main

}//class
