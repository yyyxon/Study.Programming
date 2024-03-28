package day0714;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Work0713 extends JFrame {
	JTextField jtfId;
	JPasswordField jpfPw;
	JLabel jlblOutput;
	
	public Work0713() {
		super("숙제");
		//컴포넌트
		jtfId = new JTextField();
		jpfPw = new JPasswordField();
		jlblOutput = new JLabel();
		Font font = new Font("휴먼둥근헤드라인",Font.PLAIN,12);
		jlblOutput.setFont(font);
		//타이틀바
		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPw.setBorder(new TitledBorder("비밀번호"));
		jlblOutput.setBorder(new TitledBorder("출력"));
		//관계설정
		jtfId.addKeyListener(new Work0713Event(this));
		jpfPw.addKeyListener(new Work0713Event(this));
		//레이아웃
		setLayout(new GridLayout(3,1));
		//추가
		add(jtfId);
		add(jpfPw);
		add(jlblOutput);
		//기타 설정
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//Work0713
	
	public JTextField getJtfId() {
		return jtfId;
	}//getJtfId

	public JPasswordField getJpfPw() {
		return jpfPw;
	}//getJpfPw

	public JLabel getJlblOutput() {
		return jlblOutput;
	}//getJlblOutput

	public static void main(String[]args) {
		new Work0713();
	}//main

}//class
