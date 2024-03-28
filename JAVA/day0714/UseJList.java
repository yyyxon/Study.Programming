package day0714;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame {
	private JList<String> jlFriends, jlBlockFriends;
	
	private DefaultListModel<String> dlmFriends;
	private DefaultListModel<String> dlmBlockFriends;
	
	private JTextField jtfInputName;
	
	private JScrollPane jspFriends;
	private JScrollPane jspBlockFriends;
	
	public UseJList() {
		super("내 친구인가?");
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		dlmFriends = new DefaultListModel<String>();
		dlmBlockFriends = new DefaultListModel<String>();
		
		//JList
		jlFriends = new JList<String> (dlmFriends);
		jlBlockFriends = new JList<String> (dlmBlockFriends);
		
		//JTextField
		jtfInputName = new JTextField();
		
		//font
		jtfInputName.setFont(font);
		jlFriends.setFont(font);
		jlBlockFriends.setFont(font);
		
		//JScrollPane
		jspFriends = new JScrollPane(jlFriends);
		jspBlockFriends = new JScrollPane(jlBlockFriends);
		
		//Border
		jspFriends.setBorder(new TitledBorder("친구"));
		jspBlockFriends.setBorder(new TitledBorder("차단된 친구"));
		jtfInputName.setBorder(new TitledBorder("친구 추가"));
		
		//디자인 클래스에서 이벤트 클래스를 생성
		//디자인 클래스에서 이벤트 클래스를 사용하기위해서 생성하는 것
		UseJListEvent ujle = new UseJListEvent(this);
		jtfInputName.addActionListener(ujle);
		jlFriends.addMouseListener(ujle);
		jlBlockFriends.addMouseListener(ujle);
		addWindowListener(ujle);
		
		//수동 배치
		setLayout(null);
		
		//x,y,w,h
		jtfInputName.setBounds(30,20,200,45);
		jspFriends.setBounds(30,80,200,260);
		jspBlockFriends.setBounds(250,80,200,260);
		
		//추가
		add(jtfInputName);
		add(jspFriends);
		add(jspBlockFriends);
		
		setSize(500,410);
		setVisible(true);
		
		setResizable(false); //프레임 크기 조정 불가
	}//UseJList
	

	public JList<String> getJlFriends() {
		return jlFriends;
	}

	public JList<String> getJlBlockFriends() {
		return jlBlockFriends;
	}

	public DefaultListModel<String> getDlmFriends() {
		return dlmFriends;
	}

	public DefaultListModel<String> getDlmBlockFriends() {
		return dlmBlockFriends;
	}

	public JTextField getJtfInputName() {
		return jtfInputName;
	}

	public JScrollPane getJspFriends() {
		return jspFriends;
	}

	public JScrollPane getJspBlockFriends() {
		return jspBlockFriends;
	}

	public static void main(String[] args) {
		new UseJList();
	}//main
}//class
