package day0724;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket
 * 실행되면 컴퓨터에 지정한 PORT를 열고 
 * 접속자 Socket이 접속하기를 대기하는 일 
 * @author user
 */
public class TestServerSocket {
	
	public TestServerSocket() throws IOException {
		//1.서버소켓을 생성 : 지정한 PORT 열림
		ServerSocket server = new ServerSocket(65000);
		
		System.out.println("서버 실행 중...");
		
		//3.접속자 소켓을 받는다. -> 연결만 수행
		Socket client = server.accept();
		
		System.out.println("접속자가 접속하였습니다." + client.getInetAddress());
		
		server.close();
		
		//netstat -a - 열려있는 port 확인
		//LISTENING - 기다리고 있는 상태
		//ESTABLISHED - 회선확립이 되어있는 상태
		
	}//TestServerSocket

	public static void main(String[] args) {

		try {
			new TestServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//main

}//class
