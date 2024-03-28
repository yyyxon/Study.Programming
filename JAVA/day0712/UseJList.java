package day0712;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJList extends JFrame {
	
	public UseJList() {
		super("MVC Pattern이 도입된 클래스");
		
		//1.Model 생성
		DefaultListModel<String> dlmLunch = new DefaultListModel<String>();
		
		//2.View 생성
		JList<String> jlLunch = new JList<String>(dlmLunch);
		
		//JList는 ScrollBar가 없음
		JScrollPane jspCenter = new JScrollPane(jlLunch);
		jspCenter.setBorder(new TitledBorder("점심메뉴"));
		
		//3.값 사용
		//값 추가 -> Model사용 (addElement)
		dlmLunch.addElement("지하식당");
		dlmLunch.addElement("백암왕순대");
		dlmLunch.addElement("그릴 645");
		dlmLunch.addElement("호보식당");
		dlmLunch.addElement("김천-푸드카페");
		dlmLunch.addElement("김남완 초밥집");
		dlmLunch.addElement("백종원의 새마을식당");
		
		//값 삭제
		dlmLunch.removeElementAt(2);
		
		add("Center",jspCenter);
		setSize(400,300);
		setVisible(true);
		
		//값 얻기
		JOptionPane.showMessageDialog(this, dlmLunch.getElementAt(0));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJList

	public static void main(String[] args) {
		new UseJList();
	}//main

}//class
