package day0711;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
//1.Window Component 상속
public class ManualLayout extends JFrame {

	public ManualLayout() {
		super("수동 배치");
		//2.컴포넌트 생성
		JButton jbtn = new JButton("버튼");
		String[] namesArr = "강다연,김다영,김선경,김인영,김주민,박상준,박서현,서효민".split(",");
		JList<String> jl = new JList<String>(namesArr);
		JPasswordField jpf = new JPasswordField();
		
		//3.배치관리자 해제
		//null -> heap의 주소x 객체 생성x
		setLayout(null);
		
		//4.컴포넌트의 크기 설정 (setSize)
		//수동배치 시 컴포넌트의 크기가 없어짐
		jbtn.setSize(80,30);
		
		//5.컴포넌트의 배치 위치 설정 (setLocation)
		jbtn.setLocation(30,40);

		//5-1.크기 설정과 위치를 한 번에 (setBounds)
		jl.setBounds(120, 115, 120, 180); //x,y,width,height
		jpf.setBounds(270,370,120,40);
		
		//6.배치
		add(jbtn);
		add(jl);
		add(jpf);
		
		//7.윈도우 크기 설정
		setSize(500,500);
		
		//8.가시화
		setVisible(true);
		
		//9.종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ManualLayout();
	}//main

}//class
