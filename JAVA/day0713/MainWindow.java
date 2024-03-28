package day0713;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener{
	
	public MainWindow() {
		super("자식창 띄우기");
		
		JButton jbtnOpenWin = new JButton("자식창을 띄웁니다.");
		
		//글꼴 변경
		//1.Font생성(종류,효과,크기) or(|)로 효과 여러개 적용 가능
		Font font = new Font("휴먼편지체",Font.ITALIC | Font.BOLD,25);
		jbtnOpenWin.setFont(font);
		//2.컴포넌트에 적용
		jbtnOpenWin.addActionListener(this);
		//폰트 색(전경색) 변경
		jbtnOpenWin.setForeground(Color.WHITE);
		//바닥 색(배경색) 변경
		jbtnOpenWin.setBackground(Color.orange);
		
		add(jbtnOpenWin);
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//MainWindow
	
	public static void main(String[] args) {
		new MainWindow();
	}//main

	@Override
	public void actionPerformed(ActionEvent e) {
		new SubWindow(this);
		
		
	}//actionPerformed

}//class
