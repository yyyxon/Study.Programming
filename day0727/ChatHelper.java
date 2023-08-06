package day0727;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatHelper extends Thread {

	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;

	private JTextArea jtaConnectListView;
	private int cnt;
	private JScrollPane jsp;
	private String nick;

	public ChatHelper(Socket someClient, int cnt, JTextArea jtaConnectListView, JScrollPane jsp) throws IOException {
		this.someClient = someClient;
		this.cnt = cnt;
		this.jtaConnectListView = jtaConnectListView;
		this.jsp = jsp;
		// Stream 연결
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());

		// 접속자가 보내오는 대화명을 받을 수 있다
		nick = disReadStream.readUTF();

		String msg = nick + "님이 " + cnt + " 번 째로 접속자가 접속하였습니다\n";
		jtaConnectListView.append(msg); // 서버창에 메시지 출력
		setVerticalScrollValue();
		broadcast(msg); // 모든 접속자에게도 메시지 출력

	}// ChatHelper

	public void setVerticalScrollValue() {
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());

	}// setVerticalScrollValue

	@Override
	public void run() {
		// 대화상대가 메시지를 보내면 읽어들이고 모든 접속자에게 뿌려준다
		String msg = "";
		try {
			while (true) {
				msg = disReadStream.readUTF(); // 메시지 읽기
				broadcast(msg); // 메시지 보내기
			} // end while
		} catch (IOException ie) {
			// 메시지를 읽거나 쓸 수 없는 상태 : 접속자가 접속을 종료
			MultiChatServerEvt.connectList.remove(this);
			try {
				msg = nick + "님이 접속을 종료하였습니다.\n";
				jtaConnectListView.append(msg);
				setVerticalScrollValue();
				broadcast(msg);

				if (disReadStream != null) {
					disReadStream.close();
				} // end if
				if (dosWriteStream != null) {
					dosWriteStream.close();
				} // end if
				if (someClient != null) {
					someClient.close();
				} // end if

			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} // end catch
	}// run

	public synchronized void broadcast(String msg) throws IOException {
		List<ChatHelper> connList = MultiChatServerEvt.connectList;
		Iterator<ChatHelper> ita = connList.iterator();

		ChatHelper ch = null;
		while (ita.hasNext()) {
			ch = ita.next();
			ch.dosWriteStream.writeUTF(msg);

		} // end for

	}// broadCast
}// class
