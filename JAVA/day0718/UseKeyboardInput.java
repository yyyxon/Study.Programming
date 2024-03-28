package day0718;

import java.io.IOException;
import java.io.InputStream;

/**
 * 키보드에서 눌린 키의 값 받기
 * @author user
 */
public class UseKeyboardInput {

	public UseKeyboardInput() throws IOException {
		System.out.println("아무키나 누르고 엔터");
		//int unicode = System.in.read();
		//System.out.println("입력한 키 : " + unicode + ", " + (char)unicode);
		//가장 처음에 입력한 값을 가져옴(유니코드 값)
		
		int code = -1;
		while((code = System.in.read()) != 13) {
			//System.out.print((char)code);
			// \n - 13, \r - 10
			System.out.println((char)code);
		}
		
	}
	
	//예외 발생 코드와 예외 처리 코드 분리
	public static void main(String[] args) {
		try {
			new UseKeyboardInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
