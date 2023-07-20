package day0704;

import java.util.Random;

/**
 * Random <br>
 * 난수를 사용할 목적으로 만들어진 클래스
 * @author user
 */
public class UseRandom {
	public UseRandom() {
		//1.생성
		Random random = new Random();
		//toString을 override하지 않아 주소 출력
		//System.out.println(random);
		
		//2.method 호출
		//정수의 난수
		int num = random.nextInt(); //-21억~ +21억 사이의 정수가 반환
		System.out.println(Math.abs(num%10));//%범위의 수 => 해당 범위만큼의 수만 나옴
		
		num = random.nextInt(10); //nextInt(범위의수)!간편!
		System.out.println(num);
		
		//실수의 난수
		System.out.println(random.nextFloat());
		System.out.println(random.nextDouble());
		//(casting)(nextDouble()*범위의수)
		System.out.println((int)(random.nextDouble()*10));
		
		//불린의 난수
		boolean flag = random.nextBoolean();
		System.out.println(flag);
		
		//1~45의 수 중 하나를 출력
		System.out.println(random.nextInt(45)+1);
		
	}//UseRandom

	public static void main(String[] args) {
		
		new UseRandom();

	}//main

}//class
