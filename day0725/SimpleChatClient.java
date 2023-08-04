package day0725;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener, Runnable{
	
	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalkScorll;
	private JTextField jtfTalk;
	
	private Socket client;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	public SimpleChatClient() {
		super("::::::::::::::::::::::::::::채팅 클라이언트:::::::::::::::::::::::::::::::::::::::::::");
		
		jtaTalkDisplay=new JTextArea();
		jspJtaTalkScorll=new JScrollPane(jtaTalkDisplay);
		jtfTalk=new JTextField();
		
		jtaTalkDisplay.setEditable(false);
		
		jspJtaTalkScorll.setBorder(new TitledBorder("대화내용"));
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		add("Center",jspJtaTalkScorll);
		add("South", jtfTalk);
		
		setBounds(100,100,400,500);
		setVisible(true);
		
		jtfTalk.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					closeClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					System.exit(JFrame.ABORT);
				}//end catch
			}//windowClosed
			
		});
		
		jtfTalk.requestFocus();
		
		try {
			connectToServer();
			Thread thread = new Thread(this);
			thread.run();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}//end catch
	}//SimpleChatClient
	
	public void closeClient() throws IOException {
		if(disReadStream!=null) disReadStream.close(); //end if
		if(dosWriteStream!=null) dosWriteStream.close(); //end if
		if(client!=null) client.close(); //end if
	}
	
	private String nick;
	public void connectToServer() throws UnknownHostException, IOException {
		String ip = JOptionPane.showInputDialog("접속 서버의 주소", 137);
		nick = JOptionPane.showInputDialog("닉네임", 160);
		//2. 소켓 생성(서버소켓의 포트에 접속 요청)
		client = new Socket("192.168.10."+ip ,55000);
		//client = new Socket("127.0.0.1",55000); //내 컴퓨터에 연결
		
		//4. 스트림 연결
		disReadStream = new DataInputStream(client.getInputStream());
		dosWriteStream = new DataOutputStream(client.getOutputStream());
		jtaTalkDisplay.setText("서버에 접속하였습니다.\n");
	}//connectToServer
	
	public void sendMsg() throws IOException {
		//대화를 보내고
		dosWriteStream.writeUTF("[" + nick + "]" + jtfTalk.getText());
		dosWriteStream.flush();
		//내 창에 대화를 올린다.
		jtaTalkDisplay.append("[" + nick + "]" + jtfTalk.getText() + "\n");
		jtfTalk.setText("");		
	}//sendMsg
	
	@Override
	public void run() {
		try {
			while(true) {
				jtaTalkDisplay.append(disReadStream.readUTF() + "\n");
			}			
		}catch(IOException e) {
			jtaTalkDisplay.append("대화상대가 퇴장하였습니다.");
			e.printStackTrace();
		}
	}//revMsg

	public static void main(String[] args) {
		new SimpleChatClient();
	}//main

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			e1.printStackTrace();
		}//end catch
	}//actionPerformed

}//class
