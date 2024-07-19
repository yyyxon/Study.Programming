package day1004;

import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	
	public List<TestVO> selectURL() {
		List<TestVO> list = new ArrayList<TestVO>();
		list.add(new TestVO("daum.png",
				"대한민국의 포털 사이트이다. 한메일이라는 이름으로 최초의 웹메일 서비스를 오픈",
				"daum.net"));
		
		list.add(new TestVO("sist_logo.png",
				"쌍용교육센터", "sist.co.kr"));
		
		list.add(new TestVO("bootstrap.png",
				"웹사이트를 쉽게 제작할 수 있게 도와주는 CSS Framework",
				"getbootstrap.com"));
		
		return list;
	}

}
