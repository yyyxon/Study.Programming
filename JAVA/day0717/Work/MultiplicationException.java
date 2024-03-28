package day0717.Work;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MultiplicationException extends Exception{

	public MultiplicationException() {
		JOptionPane.showMessageDialog(null, "2부터 9사이의 숫자를 입력해주세요.","ERROR",JOptionPane.WARNING_MESSAGE);
	}
	
}
