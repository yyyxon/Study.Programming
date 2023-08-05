package day0726;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {

	private MultiChatClient mcc;
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	private Thread clientThread;
	
	private String nick;
	
	public MultiChatClientEvt() {
		
	}
	
	public MultiChatClientEvt(MultiChatClient mcc) throws IOException {
		this.mcc = mcc;
		nick = mcc.getJtfUserNick().getText(); //서버 실행시 들어옴
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mcc.getJbtnConnect()) { //서버에 접속
			try {
				connectToServer();
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(mcc, "서버를 몰루");
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mcc, "접속 문제 발생");
				e.printStackTrace();
			}
		}//end if
		
		if(ae.getSource() == mcc.getJbtnCapture()) { //대화내용 저장
			try {
				capture();				
			}catch(IOException ie) {
				ie.printStackTrace();
			}
		}//end if
		
		if(ae.getSource() == mcc.getJtfTalk()) { //대화 입력
			try {
				sendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
	}//actionPerformed
	
	public void connectToServer() throws UnknownHostException, IOException {
		//MultiChatServer mcs = null;
		//JTextArea jtaConnectListView = mcs.getJtaConnectList();
		
		if(clientThread != null) {
			JOptionPane.showMessageDialog(mcc, "서버에 이미 접속되어 있습니다.");
			return;
		}//end if
		
		String ipAddr = mcc.getJtfServerAddr().getText().replaceAll(" ", "");
		nick = mcc.getJtfUserNick().getText().trim();
		getNick();
		if(nick.isEmpty()) {
			JOptionPane.showMessageDialog(mcc, "대화명은 필수입니다.");
			return;
		}
		//jtaConnectListView.append(nick + "님이 입장하셨습니다.");
		
		someClient = new Socket(ipAddr,36500);
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		clientThread = new Thread(this);
		clientThread.start(); //연결 성공시 Thread 시작 -> run()호출
		
	}//connectToServer
	
	public void capture() throws IOException {
		String captureData = mcc.getJtaTalkDisplay().getText();
		if(!captureData.isEmpty()) {
			File directory = new File("e:/java_chat/capture");
			if(!directory.exists()) {
				directory.mkdirs();
			}//end if
			
			File file = new File(directory.getAbsoluteFile() + "" + System.currentTimeMillis() + ".txt");
			
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				fw.write(captureData);
				fw.flush();
			}finally {
				if(fw!=null) fw.close();
			}			
		}
	}//capture
	
	public void sendMsg() throws IOException{
		if(dosWriteStream == null) {
			JOptionPane.showMessageDialog(mcc, "서버에 접속이 되지 않은 상태입니다.");
			return;
		}//end if
		
		JTextField jtfTalk = mcc.getJtfTalk();
		StringBuilder msg = new StringBuilder();
		msg.append("[").append(nick).append("] ").append(jtfTalk.getText());
		dosWriteStream.writeUTF(msg.toString()); //메시지를 서버로 전송한다.
		jtfTalk.setText("");
	}//sendMsg

	@Override
	public void run() {
		if(disReadStream != null) { //disReadStream이 생성됐을경우 실행
			String revMsg = "";
			try {
				while(true) {
					revMsg = disReadStream.readUTF(); //서버에서 읽어온 데이터를
					mcc.getJtaTalkDisplay().append(revMsg + "\n"); //jta에 추가하고
					//스크롤바를 이동시킴
					mcc.getJspJtaTalkDisplay().getVerticalScrollBar()
					.setValue(mcc.getJspJtaTalkDisplay().getVerticalScrollBar().getMaximum());
					
				}							
			}catch(IOException ie) {
				//메세지를 읽지 못하는 상태라면 서버가 종료된 것
				JOptionPane.showMessageDialog(mcc, "채팅 서버가 종료되었습니다.");
				ie.printStackTrace();
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		try {
			closeClient();
		} catch (IOException ie) {
			ie.printStackTrace();
		}finally {
			mcc.dispose();
		}
	}//windowClosed

	@Override
	public void windowClosed(WindowEvent we) {
		//인스턴스가 살아있어도 관련된 인스턴스 전부를 없애고 종료
		System.exit(JFrame.ABORT);
	}//windowClosed
	
	public void closeClient() throws IOException {
		if(disReadStream != null) disReadStream.close();
		if(dosWriteStream != null) dosWriteStream.close();
		if(someClient != null) someClient.close();
	}

	public void getNick() {
		System.out.println(nick +"님");
	}
	
	public void test() {
		System.out.println("하");
	}

}
