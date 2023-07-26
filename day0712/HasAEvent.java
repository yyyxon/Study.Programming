package day0712;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * has a 관계로 이벤트를 처리하기위해서는 Design 객체를 받아와야한다.
 * @author user
 */
public class HasAEvent implements ActionListener{
	
	private HasADesign had;
	
	public HasAEvent(HasADesign had) {
		this.had = had;
	}//HasAEvent

	@Override
	//2.이벤트를 처리할 수 있는 abstract method를 Override
	public void actionPerformed(ActionEvent ae) {
		//3.이벤트 처리 코드 기술
		JOptionPane.showMessageDialog(had, "안녕하세요? 이벤트입니다.");
		
	}//actionPerformed
}
