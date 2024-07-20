package day1018;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

import kr.co.sist.util.cipher.DataDecrypt;
import kr.co.sist.util.cipher.DataEncrypt;

public class TestMessageDigest {
	public static void main(String[] args) {
		String plainText = "nnn";
		try {
			//1.일방향 HASH Algorithm을 사용할 수 있는 객체 생성
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//2.일반 문자열(Plain Text)를 암호화 문자열(Cipher Text)로 변환
			md.update(plainText.getBytes());
			
			//3.암호화 문자열 받기(byte배열로 반환됨)
			byte[] chiperArr = md.digest();
			
			//4.Base64 encoder를 사용하여 인코딩
			Base64 base = new Base64();
			String chiperText = new String(base.encode(chiperArr));
			System.out.println(chiperText);
			
			
			///// 라이브러리 사용! 과정 간단해짐 /////
			
			String cipher1 = DataEncrypt.messageDigest("SHA-512", plainText);
			System.out.println(cipher1);
			
			//암호화(plain text -> cipher text)
			String text="test@test.com";
			DataEncrypt de = new DataEncrypt("a12345678901234567"); //대칭 키
			String cipher2 = de.encryption(text);
			System.out.println("농담 : " + cipher2);
			
			//복호화(cipher text -> plain text)
			DataDecrypt dd = new DataDecrypt("a12345678901234567"); //대칭 키
			String plain2 = dd.decryption(cipher2); //암호화된 문자열을 넣음
			System.out.println(plain2);
			
		} catch (NoSuchAlgorithmException e) {//해당 알고리즘을 지원하지 않을 때 발생하는 예외
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}
}
