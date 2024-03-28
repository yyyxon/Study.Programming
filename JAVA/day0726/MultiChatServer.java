package day0726;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MultiChatServer extends JFrame{

	private JTextArea jtaConnectList;
	private JScrollPane jspJtaConnectListClient;
	private JButton jbtnOpenServer;
	private JButton jbtnCloseServer;
	
	
	public MultiChatServer() {
		super(":::::::::::::::채팅서버:::::::::::::::::::::::");
		
		jtaConnectList=new JTextArea();
		jspJtaConnectListClient=new JScrollPane(jtaConnectList);
		jtaConnectList.setEditable(false);
		
		jspJtaConnectListClient.setBorder(new TitledBorder("접속자목록"));
		
		jbtnOpenServer=new JButton("서버실행");
		jbtnCloseServer=new JButton("종료");
		
		JPanel jpSouth=new JPanel();
		
		jpSouth.add( jbtnOpenServer );
		jpSouth.add( jbtnCloseServer );
		
		add("Center", jspJtaConnectListClient);
		add("South",jpSouth);
		
		MultiChatServerEvt mcse = new MultiChatServerEvt(this);
		jbtnCloseServer.addActionListener(mcse);
		jbtnOpenServer.addActionListener(mcse);
		addWindowListener(mcse);
		
		setBounds(100, 100, 400, 500);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new MultiChatServer();
	}

	public JTextArea getJtaConnectList() {
		return jtaConnectList;
	}

	public JScrollPane getJspJtaConnectListClient() {
		return jspJtaConnectListClient;
	}

	public JButton getJbtnOpenServer() {
		return jbtnOpenServer;
	}

	public JButton getJbtnCloseServer() {
		return jbtnCloseServer;
	}
	
}
