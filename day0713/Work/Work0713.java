package day0713.Work;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Work0713 extends JFrame{
	
	private JTextField idField;
	private JPasswordField pwField;
	private JLabel printLogin;
	
	public Work0713() {
		super("로그인");
		
		//컴포넌트
		Font font = new Font("맑은 고딕",Font.BOLD,15); 
		JLabel idLabel = new JLabel("아이디");
		JLabel pwLabel = new JLabel("비밀번호");
		JLabel printLabel = new JLabel("출력");
		
		//인스턴스 컴포넌트
		idField = new JTextField(10);
		pwField = new JPasswordField(10);
		printLogin = new JLabel();
		
		//폰트
		idLabel.setFont(font);
		pwLabel.setFont(font);
		printLabel.setFont(font);
		printLogin.setFont(new Font("궁서", Font.BOLD, 20));
		printLogin.setForeground(new Color(0x00416c));
				
		setLayout(null);
		
		//x,y,w,d
		idLabel.setBounds(100,60,60,20);
		idField.setBounds(100,90,150,30);
		pwLabel.setBounds(100,130,60,20);
		pwField.setBounds(100,160,150,30);
		printLabel.setBounds(100,200,60,20);
		printLogin.setBounds(100,230,1000,30);
		
		//추가
		add(idLabel);
		add(idField);
		add(pwLabel);
		add(pwField);
		add(printLabel);
		add(printLogin);
		
		//KeyListener도 가능
		WorkEvent we = new WorkEvent(this);
		idField.addActionListener(we);
		pwField.addActionListener(we);
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public JTextField getIdField() {
		return idField;
	}
	
	public JPasswordField getPwField() {
		return pwField;
	}

	public JLabel getPrintLogin() {
		return printLogin;
	}
}
