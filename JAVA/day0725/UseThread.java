package day0725;

//1.Thread 상속
public class UseThread extends Thread{
	//Thread는 선점형으로 실행할 때마다 결과가 다름

	//2.Thread의 run method를 Override
	public void run() {
		//3.Thread로 동작할 코드 정의
		for(int i=0; i < 500; i++) {
			System.out.println("run---i : " + i);
		}//end for
	}//run
	
	public static void main(String[] args) {
		//4.클래스의 객체화
		UseThread ut = new UseThread();
		
		//5.start method를 호출하여 run method를 호출
		//Thread class를 직접 상속받았으므로 start method 바로 사용 가능
		ut.start(); //run()을 직접 호출하면 순차적으로 실행함
					//start()는 Thread를 사용하는 것이므로 동시에 작업함
		System.out.println("----------------");
		for(int i=0; i < 500; i++) {
			System.out.println("main===i : " + i);
		}//end for
	}//main

}//class
