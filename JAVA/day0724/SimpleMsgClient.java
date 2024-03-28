package day0724;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 서버에 접속하여 서버에서 제공하는 메시지를 읽는 일
 * @author user
 */
public class SimpleMsgClient {
	
	public SimpleMsgClient() throws IOException {
		String ip = JOptionPane.showInputDialog(
				"서버의 ip를 입력해주세요.\n132,133,134,135,136,137,138,139,142,141,151,140,145,146,147,148,149,150,160","137");
		Socket client = null;
		DataInputStream dis = null; //메시지를 읽기 위한 스트림
		DataOutputStream dos = null; //메시지를 보내기 위한 스트림
		
		if(ip!=null && !"".equals(ip)) { //ip가 null이 아니면서 empty가 아닐 때
			try {
				//2.소켓 생성하여 서버에 접속 (Constant 이용하여 가독성 높이면 좋음)
				client = new Socket("192.168.10." + ip,1025);
				System.out.println("서버에 접속하였습니다.");
				//4.서버에서 제공하는 메시지 받기위한 스트림 연결
				dis = new DataInputStream(client.getInputStream()); //읽기 위한
				dos = new DataOutputStream(client.getOutputStream()); //보내기 위한
				//5.메시지 받기	
				String msg = dis.readUTF();
				String sendMsg = JOptionPane.showInputDialog(ip + "에서 수신한 메시지\n └>" + msg);
				
				//메시지 보내기
				dos.writeUTF("136이 보냄" + sendMsg);
				dos.flush();
			}finally {
				//6.연결 끊기
				if(dis!=null) dis.close();
				if(dos!=null) dos.close();
				if(client!=null) client.close();
			}		
		}
		
	}//SimpleMsgClient

	public static void main(String[] args) {
		try {
			new SimpleMsgClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
