package day0714.Work;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MemoInfo extends JDialog {
		
	public MemoInfo(JavaMemo jm) {
		super(jm,"메모장 정보",true);
		
		//컴포넌트 생성
		JButton jbtnClose = new JButton("닫기");
		jbtnClose.setBackground(Color.LIGHT_GRAY);
		JLabel jlTitle = new JLabel("메모장 정보");
		JTextArea jtaInfo = new JTextArea("이 메모장은 자바언어로 만들어진\n"
				+ "메모장으로 License는\nPL(Public License)로 "
				+ "자유롭게\n배포하고 사용하실 수 있습니다.\n작성자 양승연");
		jtaInfo.setEditable(false);
		
		//폰트
		jlTitle.setFont(new Font("맑은 고딕",Font.BOLD,20));
		jtaInfo.setFont(new Font("맑은 고딕",ABORT,17));
		jbtnClose.setFont(new Font("맑은 고딕",ABORT,13));
				
		//x,y,w,h
		setLayout(null);
		jbtnClose.setBounds(95,200,100,30);
		jlTitle.setBounds(90,15,200,30);
		jtaInfo.setBounds(12,60,500,200);
		jtaInfo.setBackground(getBackground());
		
		
		//has a
		MemoInfoEvt mie = new MemoInfoEvt(this);
		jbtnClose.addActionListener(mie);
		addWindowListener(mie);
		
		//add
		add(jbtnClose);
		add(jlTitle);
		add(jtaInfo);
		
		setResizable(false);
		
		setBounds(jm.getX()+100,jm.getY()+100,300,300);
		setVisible(true);
	}

}
