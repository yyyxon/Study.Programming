package day0713;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SubWindow extends JDialog {
	
	private MainWindow mw;
	
	public SubWindow(MainWindow mw) {
		//JDialog의 생성자 중 JFrame을 받는 생성자 호출
		//JFrame, dialog 타이틀, modal창 여부(modal이면 부모창 선택x)
		super(mw,"자식창 타이틀바",true); //true : Modal, false : Non-Modal(default) 
		this.mw = mw;

		SubWindow sw = this; //JDialog 넣어줌~!
		//기본 Layout은 BorderLayout
		JLabel jlbl = new JLabel(new ImageIcon("E:/dev/workspace/java_se/src/day0713/img5.jpg"));
		JButton jbtn = new JButton("클릭");
		//Dialog는 setVisible 전에 이벤트가 등록되어야한다.
		//visible 이후에 있으면 동작x Frame은 상관없음
		jbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(sw, "집에갈 때 비 안오면 좋겠다.........");
				//dialog의 첫 번째 매개변수는 컴포넌트!를 넣어주어야함
				//this 하면 actionListener가 들어가게되므로 에러~~!
				//Dialog 창 위에 메시지창을 띄우고싶으므로 현재 window 객체를 넣어줌~!
			}
		});
		
		setLayout(null); //수동배치
		
		jlbl.setBounds(0,0,644,960);
		jbtn.setBounds(300,500,80,30);
		
		add(jlbl);
		add(jbtn);
		
		//setBounds(0,0,644,960);
		//부모창의 좌표를 얻어와서 자식창 띄우기
		
		setBounds(mw.getX()+100,mw.getY()+100,644,960);
		
		setVisible(true);
		
		//Dialog창은 DISPOSE_ON_CLOSE(EXIT하면 err)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}
}
