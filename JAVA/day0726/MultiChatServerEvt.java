package day0726;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MultiChatServerEvt extends WindowAdapter implements ActionListener, Runnable {
	
	private MultiChatServer mcs;
	private ServerSocket server;
	private Thread serverThread;
	public static List<ChatHelper> connectList;
	
	public MultiChatServerEvt() {
		
	}
	
	//has a
	public MultiChatServerEvt(MultiChatServer mcs) {
		this.mcs = mcs;
		connectList = new Vector<ChatHelper>(20); //동시처리를 위해
	}//MultiChatServerEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		try {
			closeServer();
		} catch (IOException e1) {
			e1.printStackTrace();
		}//end catch
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(JFrame.ABORT);
	}

	@Override
	public void run() {
		//1.서버 소켓 열기
		try {
			server = new ServerSocket(36500);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			JTextArea JtaConnectListView = mcs.getJtaConnectList();
			JtaConnectListView.setText(sdf.format(new Date())+ "에 서버가 실행되었습니다.\n");
			
			Socket tempClient = null;
			ChatHelper ch = null;
			
			if(connectList.size() < 21) {
				for(int i = 0; ; i++) {
					//2.접속자 소켓 받기
					tempClient = server.accept();
					//String nick = tempClient.
					//new MultiChatClientEvt().getNick();
					try {//Stream이 제대로 연결되면 수행, 그렇지 않으면(예외 발생) 아무것도 하지 않음
						//3.Helper 생성하여 접속자 소켓을 넣기
						ch = new ChatHelper(tempClient, i, JtaConnectListView, 
								mcs.getJspJtaConnectListClient());
						//4.List에 추가
						connectList.add(ch);
						//5.Helper에 Thread 돌림
						ch.start(); //run() => 접속자가 보내오는 메시지를 무한루프로 읽는다.						
					}catch(IOException ie) {
						System.err.println("Helper에서 발생한 예외");
						ie.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openServer() {
		if(serverThread!=null) {
			//serverThread가 null이 아니면 서버가 동작하고있는 것
			JOptionPane.showMessageDialog(mcs, "서버가 동작 중 입니다.");
			return; //early return, else나 else if를 대체할 수 있음
		}//end if
		serverThread = new Thread(this);
		serverThread.start(); //run() 호출
		
	}//openServer
	
	public void closeServer() throws IOException {
		try {
			if(server != null) server.close();
		}finally {
			mcs.dispose(); //dispose -> windowClosed 호출
		}//end finally
	}//closeServer

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mcs.getJbtnOpenServer()) {
			openServer();
		}
		
		if(ae.getSource() == mcs.getJbtnCloseServer()) {
			try {
				closeServer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//actionPerformed
	
}//class
