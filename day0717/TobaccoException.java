package day0717;

/**
 * 사용자 정의 예외 클래스
 * @author user
 */
@SuppressWarnings("serial")
public class TobaccoException extends Exception {
	
	public TobaccoException() {
		super("지나친 흡연은 건강에 해롭습니다."); //부모 클래스 생성자 호출
	}//TobaccoException
	
	public TobaccoException(String msg) {
		super(msg);
	}//TobaccoException

}//class
