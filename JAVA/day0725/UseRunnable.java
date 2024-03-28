package day0725;

public class UseRunnable implements Runnable {
	//2.run method Override
	@Override
	public void run() {
		//3.Thread로 동작할 코드 정의
		for(int i=0; i < 500; i++) {
			System.out.println("run---i : " + i);
		}//end for
	}
	
	public void test() {
		for(int i=0; i < 500; i++) {
			System.out.println("test===i : " + i);
		}//end for
	}
	
	public static void main(String[] args) {
		//4.Runnable 구현한 클래스를 객체화
		UseRunnable ur = new UseRunnable();
		
		//5.Thread객체와 has a 관계 설정
		//Runnable interface를 상속받았으므로 has a 관계 설정후 start method 호출
		Thread t = new Thread(ur);
		
		//6.start() 호출
		t.start();
		
		ur.test();
		
	}//main


}//class
