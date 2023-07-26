package day0712;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//1.Window Component 상속, 이벤트를 처리할 Listener 구현
@SuppressWarnings("serial")
public class UseWindowEvent extends JFrame implements WindowListener{
	
	public UseWindowEvent() {
		//JFrame 생성, 타이틀바 설정
		super("윈도우 이벤트");
		
		//2. 컴포넌트 생성
		JButton jbtn = new JButton("hello swing~");
		
		//3. 이벤트에 등록
		/*this.*/addWindowListener(this);
		
		//3.배치 (add) Layout Manager 사용
		add(jbtn);
		
		//4.윈도우 크기 설정 (setSize)
		setSize(300,250);
		
		//5.사용자에게 보여주기 (setVisible)
		setVisible(true);
		
		//6.윈도우 종료처리
		
	}//HelloSwing

	public static void main(String[] args) {
		new UseWindowEvent();
		new HelloEvent();
		new HasADesign();
		new UseJList();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		//System.exit(0); //현재 JVM에서 동작하는 모든 instance를 종료시킨다.
		dispose(); //현재 윈도우만 종료 -> windowClosed가 호출 됨
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}

}
