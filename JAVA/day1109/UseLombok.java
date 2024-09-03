package day1109;

import kr.co.sist.vo.TestVO;

public class UseLombok {

	public static void main(String[] args) {
		TestVO tVO = new TestVO();
		tVO.setAddr("우리집");
		tVO.setName("농담곰");
		tVO.setNum(10);
		
		System.out.println(tVO);
		System.out.println(tVO.getAddr());
		System.out.println(tVO.getName());
		System.out.println(tVO.getNum());
	}

}
