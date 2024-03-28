package day0720;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseDataStream {
	
	public UseDataStream() throws IOException {
		//1.스트림 연결
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			File file = new File("e:/dev/temp/data_stream.dat");
			dos = new DataOutputStream(new FileOutputStream(file));
			dis = new DataInputStream(new FileInputStream(file));			
			int day=20;
			
			//2.데이터를 쓰기
			dos.writeInt(day);
			
			//3.분출
			dos.flush();
			
			//4.데이터를 읽기 //int형으로 읽어옴
			System.out.println("읽어온 데이터 : " + dis.readInt());	
		
		}finally {
			//5.연결 해제
			if(dis!=null) dis.close();
			if(dos!=null) dos.close();
		}		
	}//UseDataStream

	public static void main(String[] args) {
		try {
			new UseDataStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
