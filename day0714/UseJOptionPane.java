package day0714;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UseJOptionPane extends JFrame implements ActionListener {
	
	private JButton jbtnInput, jbtnConfirm, jbtnMsg;
	
	public UseJOptionPane() {
		super("JOptionPane 연습");
		
		jbtnInput = new JButton("입력 다이얼로그");
		jbtnConfirm = new JButton("확인 다이얼로그");
		jbtnMsg = new JButton("메시지 다이얼로그");
		
		jbtnInput.addActionListener(this);
		jbtnConfirm.addActionListener(this);
		jbtnMsg.addActionListener(this);
		
		JPanel jpInput = new JPanel();
		JPanel jpConfirm = new JPanel();
		JPanel jpMsg = new JPanel();

		jpInput.add(jbtnInput);
		jpConfirm.add(jbtnConfirm);
		jpMsg.add(jbtnMsg);
		
		setLayout(new GridLayout(3,1));
		
		add(jpInput);
		add(jpConfirm);
		add(jpMsg);
		
		setBounds(100,100,300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJOptionPane()
	
	public void useInputDialog() {
		//부모 클래스 사용하지 않아도 됨
		//메시지, Default value
		String name = JOptionPane.showInputDialog("당신의 이름을 입력해주세요.","홍길동");
		System.out.println(name+"님 안녕");
	}//useInputDialog
	
	public void useConfirmDialog() {
		//int num = JOptionPane.showConfirmDialog(this, "오늘은 금요일 입니까?");
		int num = JOptionPane.showConfirmDialog(this, "오늘은 금요일 입니까?",
						"오늘의 점심은?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.ERROR_MESSAGE);
		System.out.println("선택한 값 : " + num);
		//예 : 0
		//아니오 : 1
		//취소 : 2
		//JOptionPane.YES_NO_OPTION 또는 YES_OPTION - 예,아니오
		switch (num) {
		case JOptionPane.OK_OPTION:
			JOptionPane.showMessageDialog(this, "\"예\"를 누르셨습니다.");
			break;
		case JOptionPane.NO_OPTION:
			String input = JOptionPane.showInputDialog(this,"오늘의 요일을 입력해주세요.","월");
			JOptionPane.showMessageDialog(this, input+"요일 입니다.");
			break;
		default:
			System.out.println("취소를 선택하셨습니다.");
			break;
		}	
	}//useConfirmDialog
	
	public void useMessageDialog() {
		JOptionPane.showMessageDialog(this, "오늘은 불금입니다.", "오늘의 요일은?", JOptionPane.QUESTION_MESSAGE);	
		//PLAIN_MESSAGE : 아이콘 없음
		//ERROR_MESSAGE : 에러 아이콘
		//WARNING_MESSAGE : 주의 아이콘
		//QUESTION_MESSAGE : 질문 아이콘
	}//useMessageDialog

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnInput) {
			//method 호출로 처리 - action method가 깔끔해짐
			//action method 에서 일처리x
			useInputDialog(); 
		}
		
		if(ae.getSource() == jbtnConfirm) {
			useConfirmDialog();
		}
		
		if(ae.getSource() == jbtnMsg) {
			useMessageDialog();
		}
	}//actionPerformed

	public static void main(String[] args) {
		new UseJOptionPane();
	}//main

}//class
