package day0727;

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
import javax.swing.JTextField;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {

	private MultiChatClient mcc;
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;

	private Thread clientThread;
	private String nick;

	public MultiChatClientEvt(MultiChatClient mcc) {
		this.mcc = mcc;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			closeClient();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			mcc.dispose();
		} // end finally
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(JFrame.ABORT);
	}// windowClosed

	public void closeClient() throws IOException {
		if (disReadStream != null) {
			disReadStream.close();
		} // end if
		if (dosWriteStream != null) {
			dosWriteStream.close();
		} // end if
		if (someClient != null) {
			someClient.close();
		} // end if
	}// closeClient

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mcc.getJbtnConnect()) { // 서버에 접속
			try {
				connectToServer();
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(mcc, "서버를 몰라용");
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mcc, "접속 문제 발생");
				e.printStackTrace();
			} // end catch
		} // end if

		if (ae.getSource() == mcc.getJbtnCapture()) { // 대화내용 저장

			try {
				capture();
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch

		} // end if

		if (ae.getSource() == mcc.getJtfTalk()) { // 대화 입력
			try {
				sendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} // end if
	}// actionPerformed

	public void connectToServer() throws UnknownHostException, IOException {
		if (clientThread != null) {
			JOptionPane.showMessageDialog(mcc, "서버에 이미 접속되어 있습니다.");
			return;
		} // end if

		String ipAddr = mcc.getJtfServerAddr().getText().replaceAll(" ", "");
		nick = mcc.getJtfUserNick().getText().trim();

		if (nick.isEmpty()) {
			JOptionPane.showMessageDialog(mcc, "대화명은 필수 입력입니다");
			return;
		} // end if

		someClient = new Socket(ipAddr, 36500); // 서버로 연결
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());

		// 서버로 대화명을 전송
		dosWriteStream.writeUTF(nick);
		dosWriteStream.flush();

		clientThread = new Thread(this);
		clientThread.start();// run()

	}// connectToServer

	public void capture() throws IOException {
		String captrueData = mcc.getJtaTalkDisplay().getText();
		if (!captrueData.isEmpty()) {

			File directory = new File("e:/java_chat/capture");
			if (directory.exists()) {
				directory.mkdirs();
			} // end if
			File file = new File(directory.getAbsolutePath() + System.currentTimeMillis() + ".txt");

			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				fw.write(captrueData);
				fw.flush();
			} finally {
				if (fw != null) {
					fw.close();
				} // end if
			} // end finally
		} // end if
	}// capture

	public void sendMsg() throws IOException {

		if (dosWriteStream == null) {
			JOptionPane.showMessageDialog(mcc, "서버에 접속이 되지 않은 상태입니다.");
			return;
		} // end if
		JTextField jtfTalk = mcc.getJtfTalk();
		StringBuilder msg = new StringBuilder();
		msg.append("[ ").append(nick).append(" ] ").append(jtfTalk.getText());

		dosWriteStream.writeUTF(msg.toString()); // 메시지를 서버로 전송한다.

		jtfTalk.setText("");

	}// sendMsg

	@Override
	public void run() {
		if (disReadStream != null) {
			String revMsg = "";
			try {
				while (true) {
					revMsg = disReadStream.readUTF(); // 서버에서 읽어온 데이터를
					mcc.getJtaTalkDisplay().append(revMsg + "\n"); // J.T.A에 추가하고
					// 스크롤 바를 이동시킨다
					mcc.getJspJtaTalkDisplay().getVerticalScrollBar()
							.setValue(mcc.getJspJtaTalkDisplay().getVerticalScrollBar().getMaximum());

				} // end while
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mcc, "채팅 서버가 종료되었습니다");
				ie.printStackTrace();
			} // end catch
		} // end if
	}// run

}// class
