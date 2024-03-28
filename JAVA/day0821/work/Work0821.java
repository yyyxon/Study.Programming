package day0821.work;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Work0821 extends JFrame{
	
	private DefaultListModel<Integer> dlmEmpno;
	private JList<Integer> jlEmpno;
	
	public Work0821() {
		super("사원 정보 조회");
		
		//JList
		dlmEmpno = new DefaultListModel<Integer>();
		jlEmpno = new JList<Integer>(dlmEmpno);
		JScrollPane jspEmpno = new JScrollPane(jlEmpno);
		
		//JLabel
		JLabel jlTitle = new JLabel("사원 번호");
		
		//Font
		Font font = new Font("맑은 고딕",ABORT,15);
		jlTitle.setFont(font);
		jlEmpno.setFont(font);
		
		//JPanel
		JPanel jpNorth = new JPanel();
		jpNorth.add(jlTitle);
		
		//Event
		Work0821Evt wEvt = new Work0821Evt(this);
		jlEmpno.addMouseListener(wEvt);
		
		add("North",jpNorth);
		add(jspEmpno);
		setBounds(700,300,300,360);
		setVisible(true);
	}//Work0821

	public DefaultListModel<Integer> getDlmEmpno() {
		return dlmEmpno;
	}

	public JList<Integer> getJlEmpno() {
		return jlEmpno;
	}
	
	public static void main(String[] args) {
		new Work0821();
	}//main

}//class
