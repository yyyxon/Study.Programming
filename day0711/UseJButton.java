package day0711;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 아이콘을 사용한 버튼 객체 사용
 * @author user
 */
@SuppressWarnings("serial")
public class UseJButton extends JFrame {
	
	public UseJButton() {
		super("버튼과 아이콘");
		
		//이미지 아이콘 생성 (절대경로)
		ImageIcon ii = new ImageIcon("E:/dev/workspace/java_se/src/day0711/images/img1.png");
		ImageIcon ii2 = new ImageIcon("E:/dev/workspace/java_se/src/day0711/images/img2.png");
		ImageIcon ii3 = new ImageIcon("E:/dev/workspace/java_se/src/day0711/images/img3.png");
		ImageIcon ii4 = new ImageIcon("E:/dev/workspace/java_se/src/day0711/images/img4.png");
		
		JButton jbtn = new JButton("울고있는 차차",ii);
		JButton jbtn2 = new JButton("신나는 차차",ii2);
		JButton jbtn3 = new JButton("보고있는 차차",ii3);
		
		//풍선 도움말
		jbtn.setToolTipText("울먹이는 차차ㅠㅠ");
		jbtn2.setToolTipText("신나는 차차^ㅇ^");
		jbtn3.setToolTipText("뭐가 있지?");
		
		//마우스 포인터가 올라갔을 때 이미지 변환
		jbtn3.setRolloverIcon(ii4);
		
		//텍스트 위치 변경
		//수직위치 - TOP,CENTER,BOTTOM
		jbtn.setVerticalTextPosition(JButton.BOTTOM);
		jbtn3.setVerticalTextPosition(JButton.BOTTOM);
		//수평위치 - LEFT,CENTER,RIGHT
		jbtn2.setHorizontalTextPosition(JButton.CENTER);
		jbtn3.setHorizontalTextPosition(JButton.LEFT);
		
		setLayout(new GridLayout(1,3));
		
		add(jbtn);
		add(jbtn2);
		add(jbtn3);

		setBounds(100,100,1200,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new UseJButton();
	}//main

}//class
