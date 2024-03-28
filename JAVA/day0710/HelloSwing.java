package day0710;

import javax.swing.JButton;
import javax.swing.JFrame;

//1.Window Component 상속
@SuppressWarnings("serial")
public class HelloSwing extends JFrame{
	
	public HelloSwing() {
		//JFrame 생성, 타이틀바 설정
		super("안녕 스윙");
		
		//2. 컴포넌트 생성
		JButton jbtn = new JButton("swing");
		
		//3.배치 (add) Layout Manager 사용
		add(jbtn);
		
		//4.윈도우 크기 설정 (setSize)
		setSize(300,250);
		
		//5.사용자에게 보여주기 (setVisible)
		setVisible(true);
		
		//6.윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//HelloSwing

	public static void main(String[] args) {
		new HelloSwing();
		
	}

}
