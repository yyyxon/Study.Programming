package day0713;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 간단한 마우스 이벤트를 처리하기위해 MouseAdapter 상속 
 * @author user
 */
public class TestMouseEvent extends MouseAdapter {

	private TestMouseDesign tmd; //null - 객체가 생성되지 않음
	
	/**
	 * TestMouseEvent클래스가 생성될 때 TestMouseDesign 객체를 입력받아
	 * 생성한다. (has a 관계)
	 * @param tmd
	 */
	//생성자로 받기
	public TestMouseEvent(TestMouseDesign tmd) {
		this.tmd = tmd;
	}

	//setter로 받기
	public void setTmd(TestMouseDesign tmd) {
		this.tmd = tmd;
	}

	@Override
	public void mouseClicked(MouseEvent me) {		
		String buttonType = "";
		
		switch (me.getButton()) {
		case MouseEvent.BUTTON1:
			buttonType = "왼쪽 버튼";
			break;
		case MouseEvent.BUTTON2:
			buttonType = "가운데 버튼";
			break;
		case MouseEvent.BUTTON3:
			buttonType = "오른쪽 버튼";
			break;
		}
		//jta 컴포넌트는 private이므로 getter method로 호출
		tmd.getJta().setText(buttonType + "으로 마우스 클릭!!");
	}

}
