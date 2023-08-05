package day0726;

import java.util.Random;

public class UseSleep2 implements Runnable {
	
	@Override
	public void run() {
		System.out.print("loading");
		for(int i = 0; i < 15; i++) {
			System.out.print(".");
			try {
				Thread.sleep(new Random().nextInt(1001));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("finish");
	}//run

	public static void main(String[] args) {
		Thread t = new Thread(new UseSleep2());
		t.start();
	}//main

}//class
