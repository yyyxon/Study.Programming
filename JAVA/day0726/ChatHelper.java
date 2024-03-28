package day0726;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatHelper extends Thread {

	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	private JScrollPane jsp;
	private JTextArea jtaConnectListView;
	private int cnt;
	private String nick;
	private MultiChatClient mcc;
	
	public ChatHelper(Socket someClient, int cnt, JTextArea jtaConnectListView, JScrollPane jsp) throws IOException {
		this.someClient = someClient;
		this.cnt = cnt;
		this.jtaConnectListView = jtaConnectListView;
		this.jsp = jsp;
		//스트림 연결
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		nick = mcc.getJtfUserNick().toString();
		
		String msg = nick + "님이 접속하였습니다.\n";
		jtaConnectListView.append(msg); //서버창에 메시지 출력
		setVerticalScrollValue();
		broadcast(msg); //모든 접속자에게도 메시지 출력
	}//ChatHelper
	
	public void setVerticalScrollValue() {
		//ScrollBar 변경
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum()); 
	}

	//메시지 읽음
	@Override
	public void run() {
		//대화상대가 메시지를 보내면 읽어들이고 모든 접속자에게 뿌려준다.
		String msg = "";
		try {
			while(true) {
				msg = disReadStream.readUTF();
				broadcast(msg);
			}//end while		
		}catch(IOException ie) {
			//메시지를 읽거나 쓸 수 없는 상태 : 접속자가 접속을 종료 - List에서 삭제
			MultiChatServerEvt.connectList.remove(this);
			try {
				broadcast(nick + "님이 접속을 종료하였습니다.\n");
				setVerticalScrollValue();
				broadcast(msg);
				
				if(disReadStream != null) disReadStream.close(); //end if
				if(dosWriteStream != null) dosWriteStream.close(); //end if
				if(someClient != null) someClient.close(); //end if
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end catch(multi catch)
	}//run
	
	//Thread 한 개씩 호출
	//메시지 출력
	public synchronized void broadcast(String msg)throws IOException{
		List<ChatHelper> connectList = MultiChatServerEvt.connectList;
		Iterator<ChatHelper> ita = connectList.iterator(); //접속한 사용자 목록
		ChatHelper ch = null;
		
		while(ita.hasNext()) {
			ch = ita.next();
			ch.dosWriteStream.writeUTF(msg); //접속한 모든 사용자에게 메시지를 출력
		}
	}//boardcast
}
