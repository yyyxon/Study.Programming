package day0726;

public class UseSleep {
	
	public UseSleep() {
		for(int i=0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초씩 sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new UseSleep();
	}//main

}//class
