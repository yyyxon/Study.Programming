package day1121;

import java.util.HashMap;
import java.util.Map;

import day1121.sub.Person;

public class UseMap {
	
	public static void main(String[] args) {
		//interface를 이용한 객체 다형성
		
		//1.Map 생성
		Map<String, Person> map = new HashMap<String, Person>();
		
		//2.값 할당
		map.put("nong", new Damgom());
		map.put("heun", new Doonge());
		map.put("shin", new Jjanggu());
		
		//3.값 사용
		String key = "nong";
		
		//interface를 사용하면 값을 얻어서 사용하는 코드가 줄어든다.
		if(map.containsKey(key)) {
			Person p = (Person)map.get(key);
			System.out.println(p.execute());
		}//end if
		
	}

}
