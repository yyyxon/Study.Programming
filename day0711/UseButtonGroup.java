package day0711;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class UseButtonGroup extends JFrame {
	
	public UseButtonGroup() {
		super("버튼 그룹 연습");
		JLabel jlbl = new JLabel("성별");
		JRadioButton jrb = new JRadioButton("남자");
		JRadioButton jrb2 = new JRadioButton("여자",true);

		//버튼 그룹으로 묶기
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb);
		bg.add(jrb2);
		
		setLayout(new FlowLayout());
		add(jlbl);
		add(jrb);
		add(jrb2);
		setBounds(100,200,300,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new UseButtonGroup();
	}//main

}//class
