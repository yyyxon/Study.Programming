package day0706;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class UseSet {
	
	public void useHashSet() {
		//1.생성
		Set<String> set = new HashSet<String>();
		//2.값 추가 - 값은 순차적으로 입력되지 않는다.
		set.add("홍희진");
		set.add("홍찬영");
		set.add("홍지성");
		set.add("차준식");
		set.add("정민교");
		set.add("장용석");
		
		//중복값은 입력되지 않는다.
		set.add("차준식");
		set.add("차준식");
		//배열로 복사
		//1.set의 크기로 배열을 생성
		String[] nameArr = new String[set.size()];
		//2.복사
		set.toArray(nameArr);
		
		//값 얻기 - iterator 
		//=> set은 검색의 기능이 없음(get method가 없음)
		//Iterator와 Set의 Generic이 같아야 함
		//1.Iterator 제어권 넘겨주기
		Iterator<String> ita = set.iterator();
		//2.element가 존재한다면 (List와 사용 방법 동일)
		while(ita.hasNext()) {
			System.out.println(ita.next()); //값을 얻고 다음 element로 이동
		}

		//값 삭제 - 특정 값(remove), 전체(clear)
		//set.remove(object) - 일치하는 객체가 존재하면 삭제
		//set.remove(1); => 인덱스는 사용 불가
		set.remove("홍찬영"); //특정 값 삭제
		set.remove("홍희진");
		System.out.println(set + " / " + set.size() + "개" + "\n");
		set.clear(); //전체 값 삭제
		System.out.println(set + " / " + set.size() + "개" + "\n");
		
		//배열에 복사된 값을 기존의 for loop를 사용하여 출력
		for(int i = 0; i < nameArr.length; i++) {
			System.out.println(nameArr[i]);
		}
	}//HashSet
	
	//업무 : set을 사용하여 로또 번호를 구하고, 배열로 반환
	public Integer[] lotto() {
		Random random = new Random();
		Set<Integer> lottoSet = new HashSet<Integer>();
		Integer[] lottoArr = new Integer[6];
		
		while(lottoSet.size() < 6) {
			lottoSet.add(random.nextInt(45)+1);
		}
				
		return lottoSet.toArray(lottoArr);
	}
	
	
	//업무 사용 : 로또번호 출력
	public void printLotto() {
		Integer[] lottoArr = lotto();
		System.out.print("로또 번호 : ");
		for(int i = 0; i < lottoArr.length; i++) {
			System.out.printf("%d  ",lottoArr[i]);
		}
	}

	public static void main(String[] args) {
		UseSet us = new UseSet();
		us.useHashSet();
		System.out.println();
		us.printLotto();
	}

}
