package day0711;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Hungarian Notation
 * - 컴포넌트의 종류 + 하는일의 형식으로 객체명을 부여
 * 복합 레이아웃
 * - 여러개의 Layout을 복합하여 사용
 * @author user
 */
@SuppressWarnings("serial")
//1.Window component 상속
public class ComplexLayout extends JFrame {
	
	public ComplexLayout() {
		super("여러 레이아웃의 사용");
		
		//2.컴포넌트 생성
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(14);
		JComboBox<String> jcbClass = new JComboBox<String>();
		jcbClass.addItem("A 클래스");
		jcbClass.addItem("B 클래스");
		jcbClass.addItem("C 클래스");
		jcbClass.addItem("D 클래스");
		JButton jbtnAdd = new JButton("입력");
		JTextArea jtaNameDisp = new JTextArea();
				
		//3.배치
		//패널에 배치(Container Component)
		JPanel jpNorth = new JPanel(); //기본이 FlowLayout
		//jpNorth.setLayout(new BorderLayout()); => border로 변경
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jcbClass);
		jpNorth.add(jbtnAdd);
		
		//프레임에 배치
		add(jpNorth,"North");
		add(jtaNameDisp,"Center");
		
		//4.윈도우 크기 설정
		setSize(450,400);
		
		//5.가시화
		setVisible(true);
		
		//6.종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//ComplexLayout

	public static void main(String[] args) {

		new ComplexLayout();
		
	}//main

}//class
