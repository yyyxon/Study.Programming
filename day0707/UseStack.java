package day0707;

import java.util.Stack;

public class UseStack {

	public UseStack() {
		//1.생성
		Stack<String> stk = new Stack<String>();
		//List<String> 이나 Vector<String>도 가능하지만(is a)
		//그럼 스택이 아닌 리스트가 되어버림
		
		//2.값 할당
		stk.push("드세요");
		stk.push("맛있게");
		stk.push("점심을");
		
		//3. 값 얻기
		//pop하면 나오고 사라짐 get하면 사라지지않음
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());
		//부모의 method를 사용하지 않는다.
//		System.out.println(stk.get(0));
		while(!stk.empty()) {
			System.out.println(stk.pop());
		}
		
		System.out.println(stk); 
		
	}//UseStack
	
	public static void main(String[] args) {

		new UseStack();
		
	}//main

}//class
