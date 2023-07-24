package day0710;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * BorderLayout
 * - Window Component의 기본 레이아웃
 * East,West,North,South,Center로 구성되고, 각 영역에는 하나의 컴포넌트만 배치된다.
 * setLayout(new BorderLayout()); 코드로 Layout을 적용
 * @author user
 */


@SuppressWarnings("serial")
//1.Window Component를 상속
public class TestBorderLayout extends JFrame {
	
	public TestBorderLayout() {
		super("BorderLayout 연습");
		
		//2.컴포넌트 생성
		JLabel jlblWest = new JLabel("서쪽"); //Label은 정보 전달을 하기 위한 이름표 컴포넌트
		JLabel jlblEast = new JLabel("JLabel 동쪽");

		JButton jbtnNorth = new JButton("북쪽"); //Button은 클릭했을 때 동작하기위한 컴포넌트
		JButton jbtnSouth = new JButton("남쪽");
		
		JTextArea jtaCenter = new JTextArea("가운데"); //여러줄의 문자열을 입력받기위한 컴포넌트
		
		//3.배치관리자 설정 (setLayout)
		//setLayout(new BorderLayout());
		
		//4.위치를 설정하여 배치 (add)
		//String
		add("North",jbtnNorth);
		add("East",jlblEast);
		
		//Constant 사용
		add(jtaCenter,BorderLayout.CENTER);
		add(jlblWest,BorderLayout.WEST);
		add(BorderLayout.SOUTH, jbtnSouth);
		
		//5.윈도우 크기설정 (setSize)
		setSize(500,500);
		
		//6.사용자에게 보여주기 (setVisible)
		setVisible(true);
		
		//7.윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//TestBorderLayout
	
	public static void main(String[] args) {
		new TestBorderLayout();
	}//main

}//class
