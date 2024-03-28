package day0814;

public class Singleton {
	private static Singleton single;
	
	private Singleton() {
		//외부에서 직접 객체화 할 수 없도록 접근 지정자를 private로
		System.out.println("생성자");
	}//Singleton
	
	public static Singleton getInstance() {
		if(single == null) {
			//객체가 죽었을 때 대비하는 코드
			single = new Singleton();
		}//end if
		
		return single;
	}
	
}//class
