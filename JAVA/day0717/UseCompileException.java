package day0717;

/**
 * 개발자가 반드시 처리해야하는 Compile Exception
 * @author user
 */
public class UseCompileException {

	public static void main(String[] args) {
		try {
			//컴파일 예외는 개발자가 반드시 처리해야한다.
			//bytecode가 제대로 만들어지지 않음
			Class c = Class.forName("java.lang.String");
			System.out.println(c + "을 로딩하였습니다.");
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
		}
	}

}
