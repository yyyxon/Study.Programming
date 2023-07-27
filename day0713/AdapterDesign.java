package day0713;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AdapterDesign extends JFrame {

	public AdapterDesign() {
		super("XxxAdaper class를 사용한 윈도우 이벤트 처리");
		
		//이벤트에 등록
		AdapterEvent ae = new AdapterEvent(this);
		addWindowListener(ae);
		
		setSize(800,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new AdapterDesign();
		
	}//main

}//class
