package day0727;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author user
 *
 */
@SuppressWarnings("serial")
public class MultiChatClient extends JFrame {

	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalkDisplay;
	private JTextField jtfServerAddr;
	private JTextField jtfUserNick;
	private JTextField jtfTalk;

	private JButton jbtnConnect;
	private JButton jbtnCapture;

	public MultiChatClient() {
		super("채팅 클라이언트");

		jtaTalkDisplay = new JTextArea();
		jspJtaTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jspJtaTalkDisplay.setBorder(new TitledBorder("대화내용"));

		jtfServerAddr = new JTextField("192.168.10.", 10);
		jtfUserNick = new JTextField(10);
		jtfTalk = new JTextField();

		jtfTalk.setBorder(new TitledBorder("대화"));

		jbtnConnect = new JButton("접속");
		jbtnCapture = new JButton("캡처");

		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("서버주소"));
		jpNorth.add(jtfServerAddr);
		jpNorth.add(new JLabel("대화명"));
		jpNorth.add(jtfUserNick);
		jpNorth.add(jbtnConnect);
		jpNorth.add(jbtnCapture);

		add("North", jpNorth);
		add("Center", jspJtaTalkDisplay);
		add("South", jtfTalk);

		MultiChatClientEvt mcce = new MultiChatClientEvt(this);
		jbtnConnect.addActionListener(mcce);
		jbtnCapture.addActionListener(mcce);
		jtfTalk.addActionListener(mcce);

		addWindowListener(mcce);

		setBounds(100, 100, 600, 400);
		setVisible(true);

	}// MultiChatClient

	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}

	public JScrollPane getJspJtaTalkDisplay() {
		return jspJtaTalkDisplay;
	}

	public JTextField getJtfServerAddr() {
		return jtfServerAddr;
	}

	public JTextField getJtfUserNick() {
		return jtfUserNick;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public JButton getJbtnConnect() {
		return jbtnConnect;
	}

	public JButton getJbtnCapture() {
		return jbtnCapture;
	}

	public static void main(String[] args) {
		new MultiChatClient();
	}// main

}// class
