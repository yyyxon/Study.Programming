package day0717;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * throws
 * 예외 날림
 * 업무처리 method에서 예외처리 코드를 분리할 때 사용
 * 업무처리시에 발생할 수 있는 문제를 알 수 있다.
 * @author user
 */
public class UseThrows {
	
	//업무처리 클래스에서는 try~catch를 배제한 업무처리에만 집중할 수 있다.
	//업무 처리 method -> throws
	//업무 사용 method -> try~catch
	public void classLoad() throws ClassNotFoundException {
		String[] className = {"day0717.UseRuntimeException", "java.lang.String",
		                      "UseCompileException"};
		Class.forName(className[new Random().nextInt(className.length)]);
		System.out.println("클래스 로딩 성공");
	}//classLoad

	//업무를 사용하는 method에서는 업무사용과
	//업무사용시에 발생할 수 있는 에러상황에 대한 처리를 할 수 있다.
	public void useClassLoad() {
		try {
			classLoad(); //class를 로드할 때, 클래스가 없을 수 있는 문제가 발생할 수 있다.
			//System.out.println("성공");
		} catch (ClassNotFoundException e) {
			//예외가 발생했을 때 제공할 코드
			JOptionPane.showMessageDialog(null, "뎨둉합니다");
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {

		new UseThrows().useClassLoad();
		
	}

}
