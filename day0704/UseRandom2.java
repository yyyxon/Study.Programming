package day0704;

import java.util.Arrays;
import java.util.Random;

public class UseRandom2 {
	
	//1. 1~45사이의 수를 6개 발생시켜 배열에 넣고 반환하는 일을 하는 method
	public int[] lotto() {
		int[] lotto = new int[6];
		Random random = new Random();

		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(45)+1; //발생한 난수를 마지막방에 삽입
			for(int j = 0; j < i; j++) { //발생된 난수가 이전방에 들어있는지 확인
				if(lotto[j] == lotto[i]) { //현재방과 값이 같은 방이 있다면
					i--; //바깥 for에서 사용하는 index를 감소
					break; //안쪽 for를 빠져나감
				}
			}
		}
		return lotto;
	}
	
	//2. 위의 일을 호출하여 출력하는 method
	public void printLotto() {
		int[] lotto = lotto();
		Arrays.sort(lotto); //오름차순으로 배열 정렬
		System.out.println(Arrays.toString(lotto)); //출력
//		for(int num : lotto) {
//			System.out.println(num);
//		}
	}
	
	public static void main(String[] args) {
		//3.method 호출
		new UseRandom2().printLotto();
	}

}
