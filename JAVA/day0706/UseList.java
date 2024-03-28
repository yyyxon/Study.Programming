package day0706;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class UseList {

	/**
	 * JDK 1.1에서부터 지원하는 모든 객체를 저장할 수 있는 문법
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void useNonGeneric() {
		//1.생성(is a => 각 요소의 데이터형을 다르게 줄 수 있음)
		List list = new ArrayList();
		//2.값 할당
		//기본형 데이터형을 전달할 수 없음
		//-> 객체로 만들어 전달(1.5부터는 자동 autoboxing)
		list.add(Integer.valueOf(7));
		list.add(Integer.valueOf(6));
		list.add("안녕하세요");
		list.add(Boolean.valueOf(true));
		//3.값 사용
		for(int i=0; i<list.size(); i++) {
			//꺼내서 사용할 때 에러가 발생할 수 있다.
			System.out.println(list.get(i));
		}
		
	}
	
	public void useArrayList() {
		//1.생성 Generic 사용 -> 기본형 데이터형은 못 씀!! 객체로 작성
		List<Integer> list = new ArrayList<Integer>();
		
		//2.할당 - add
		System.out.println(list.isEmpty()); //list가 비었는지
		list.add(2023); //autoboxing : Integer.valueOf(정수)
		Integer ii = Integer.valueOf(7); //참조형은 객체의 주소 저장 -> autoboxing
		list.add(ii);
		list.add(Integer.valueOf(6));
		list.add(Integer.parseInt("12"));
		//Generic이 사용되면 선언된 데이터형으로만 값을 입력할 수 있다. (참.조.형)
		//list.add("39"); //Integer가 아닌 String이라 add 불가
		list.add(40);
		
		//3.사용
		System.out.println(list.isEmpty()); //isEmpty가 좋다!
		System.out.println(list.size() == 0); 
		
		//4.값 얻기 - get
		int i = list.get(0); //add할 땐 객체를 넣어야줘야하지만 
		System.out.println(i); //get할 땐 자동으로 기본형 데이터형으로 바뀜
		i = list.get(1);
		System.out.println(i);
		System.out.println();
		
		//5.일괄 처리 - 반복문
		for(int j = 0; j < list.size(); j++) {
			System.out.printf("list.get(%d) = %d\n",j,list.get(j));
		}
		
		System.out.println();
		
		//리스트를 배열로 복사하기
		//리스트의 크기대로 배열을 생성
		//generic 맞게 데이터형 설정
		Integer[] arr = new Integer[list.size()];  

		//배열에 리스트 복사
		list.toArray(arr);
		
		//리스트 방의 값을 삭제 (방의 크기가 줄어든다.)
		//삭제한 인덱스부터 뒤의 인덱스가 앞으로 당겨짐
		list.remove(2);
		list.remove(2);
		
		System.out.println("--arr 배열 출력--");
		for(Integer arrI : arr) {
			System.out.println(arrI.intValue());
		}//end for
		System.out.println("----출력 끝-----\n");
		
		//toString Override해서 주소가 아닌 메시지가 나옴
		System.out.println(list + " / " + list.size() + "개" + "\n");
		
		//리스트는 중복값을 저장할 수 있다.
		List<String> nameList = new ArrayList<String>();
		nameList.add("강다연");//0
		nameList.add("김다영");//1
		nameList.add("김선경");//2
		nameList.add("김인영");//3
		nameList.add("김선경");//4 //중복 저장 가능
		nameList.add("김주민");//5
		
		for(String value : nameList) {
			System.out.println(value); //FIFO
		}
		
	}//useArrayList
	
	/**
	 * ArrayList와 부모가 같으므로 사용방법 동일
	 * ArrayList - 동기화x 동시접근 가능
	 * Vector - 동기화o 동시접근 불가능
	 */
	public void useVector() {
		//1.생성 Generic 사용 -> 기본형 데이터형은 못 씀!! 객체로 작성
		//객체다형성 : 부모의 기능을 알면 모든 자식을 다 사용할 수 있다.
		List<Integer> list = new Vector<Integer>();
				
		//2.할당 - add
		System.out.println(list.isEmpty()); //list가 비었는지
		list.add(2023); //autoboxing : Integer.valueOf(정수)
		Integer ii = Integer.valueOf(7); //참조형은 객체의 주소 저장 -> autoboxing
		list.add(ii);
		list.add(Integer.valueOf(6));
		list.add(Integer.parseInt("12"));
		//Generic이 사용되면 선언된 데이터형으로만 값을 입력할 수 있다. (참.조.형)
		//list.add("39"); //Integer가 아닌 String이라 add 불가
		list.add(40);
				
		//3.사용
		System.out.println(list.isEmpty()); //isEmpty가 좋다!
		System.out.println(list.size() == 0); 
				
		//4.값 얻기 - get
		int i = list.get(0); //add할 땐 객체를 넣어야줘야하지만 
		System.out.println(i); //get할 땐 자동으로 기본형 데이터형으로 바뀜
		i = list.get(1);
		System.out.println(i);
		System.out.println();
		
		//5.일괄 처리 - 반복문
		for(int j = 0; j < list.size(); j++) {
			System.out.printf("list.get(%d) = %d\n",j,list.get(j));
		}
		
		System.out.println();
		
		//리스트를 배열로 복사하기
		//리스트의 크기대로 배열을 생성
		//generic 맞게 데이터형 설정
		Integer[] arr = new Integer[list.size()];  

		//배열에 리스트 복사
		list.toArray(arr);
		
		//리스트 방의 값을 삭제 (방의 크기가 줄어든다.)
		//삭제한 인덱스부터 뒤의 인덱스가 앞으로 당겨짐
		list.remove(2);
		list.remove(2);
		
		System.out.println("--arr 배열 출력--");
		for(Integer arrI : arr) {
			System.out.println(arrI.intValue());
		}//end for
		System.out.println("----출력 끝-----\n");
		
		//toString Override해서 주소가 아닌 메시지가 나옴
		System.out.println(list + " / " + list.size() + "개" + "\n");
		
		//리스트는 중복값을 저장할 수 있다.
		//부모가 같으므로 사용 방법이 같다.
		List<String> nameList = new Vector<String>();
		nameList.add("강다연");//0
		nameList.add("김다영");//1
		nameList.add("김선경");//2
		nameList.add("김인영");//3
		nameList.add("김선경");//4 //중복 저장 가능
		nameList.add("김주민");//5
		
		for(String value : nameList) {
			System.out.println(value); //FIFO
		}
	}//useVector
	
	/**
	 * 값의 수정이 빈번할 때 좋다.
	 */
	public void useLinkedList() {
		//1.생성
		List<String> nameList = new LinkedList<String>();
		//2.데이터추가
		nameList.add("강다연");
		nameList.add("김다영");
		nameList.add("김인영");
		nameList.add("김주민");
		//김선경이 누락
		
		System.out.println(nameList);
		//누락된 데이터 추가
		nameList.add(2,"김선경");
		System.out.println(nameList);
	}//useLinkedList
	
	public static void main(String[] args) {
		UseList ul = new UseList();
		
		System.out.println("------------Non Generic------------");
		ul.useNonGeneric();
		System.out.println("-------------Array List------------");
		ul.useArrayList();
		System.out.println("---------------Vector--------------");
		ul.useVector();
		System.out.println("------------Linked List------------");
		ul.useLinkedList();
		
	}//main

}//class
