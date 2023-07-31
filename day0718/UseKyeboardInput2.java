package day0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UseKyeboardInput2 {

	/**
	 * 한글을 깨지지 않도록 읽어 들이기 위해 
	 * 8bit Stream과 16bit Stream을 연결하여 사용
	 * @throws IOException 
	 */
	public UseKyeboardInput2() throws IOException {
		System.out.println("아무키나 누르고 엔터");
		
		//InputStream is = System.in;
		//InputStreamReader isr = new InputStreamReader(is);
		//BufferedReader br = new BufferedReader(isr);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String msg = br.readLine(); //줄 단위로 읽는다.
		System.out.println("입력 문자열 : " + msg);
	}
	
	public static void main(String[] args) {
		try {
			new UseKyeboardInput2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
