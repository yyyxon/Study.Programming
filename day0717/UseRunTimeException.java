package day0717;

/**
 * Runtime Exception
 * 개발자가 try-catch를 하지 않아도 에러가 발생하지 않는 예외
 * -> 예외 발견이 어렵다.
 * @author user
 */
public class UseRunTimeException {

	public static void main(String[] args) {
		//arguments로 두 수를 입력받아 나눈 후 결과를 출력하는 일
		try {
			int num = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = 0;
			result = num/num2;
			
			System.out.println(num + "/" + num2 + " = " + result);			
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("사용법) java UseRuntimeException 값1 값2 의 형식으로 사용해주세요.");
			System.err.println(aioobe.getMessage()); //간단한 메시지, 에러 발생 위치를 알 수 없음
			//out : 정상 , err : 비정상
			//err 상황이므로 out이 아닌 err
			System.err.println(aioobe); //예외발생객체와 간단한 메시지
			aioobe.printStackTrace(); //예외발생라인 수까지 알려줌, 콘솔에 자동으로 출력
		}catch(NumberFormatException nfe) {
			System.err.println("값은 숫자형태만 입력 가능합니다.");
			nfe.printStackTrace();
		}catch(ArithmeticException ae) {
			System.err.println("0으로 나눌 수 없습니다.");
			ae.printStackTrace();
		}catch(Exception e) {
			//부모이므로 모든 예외를 다 잡을 수 있다. 
			//-> 다른 예외처리를 할 필요가 없음 -> 부모 Exception 위에 자식 Exception 처리 x
			//모든 Exception의 부모 클래스는 Exception
			//부모 클래스는 자식 클래스를 모두 담을 수 있음
			System.err.println("개발자가 인지하지 못한 예외를 처리");
		}finally {
			//에러가 나도, 나지않아도 반드시 실행
			//생략 가능
			System.out.println("반드시 실행되어야 할 코드 정의");
			System.out.println("사용해주셔서 감사용");
		}
	}//main

}//class
