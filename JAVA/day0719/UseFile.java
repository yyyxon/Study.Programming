package day0719;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UseFile {
	
	/**
	 * 8bit와 16bit stream을 사용하여 한글이 깨지지 않도록 읽어들이기
	 * @throws IOException 
	 */
	public void useByteStream() throws IOException{
		//1.File생성
		//image File은 x 문자만
		File file = new File("e:/dev/temp/java_read.txt");
		//2.파일이 존재하면 stream을 연결
		if(file.exists()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				//3.파일의 내용을 줄단위로 읽어들임
				String temp = "";
				while((temp=br.readLine())!=null) {
					System.out.println(temp);
				}//end while
		
			}finally {
				//4.stream 연결 끊기(가장 중요,예외가 생겨도 끊어져야함 -> try~finally사용)
				//null인 경우 close하지 않아도 됨 
				//-> null인데 close할 경우 NullPointerException 발생 -> if로 처리
				if(br!=null) br.close(); //if로 NullPointerException				
			}
		}
	}
	
	public void useStringStream() throws IOException {
		//1.파일정보얻기
		File file = new File("e:/dev/temp/java_read.txt");
		if(file.exists()) {
			//2.파일에 스트림 연결
			BufferedReader br =null;
			try {
				br = new BufferedReader(new FileReader(file));
				//3.파일의 내용을 줄단위로 읽기
				String temp = "";
				StringBuilder sbData = new StringBuilder();
				while((temp = br.readLine()) != null){
					sbData.append(temp).append("\n");
				}
				JTextArea jta = new JTextArea(10,80);
				jta.setText(sbData.toString());
				JScrollPane jsp = new JScrollPane(jta);
				JOptionPane.showMessageDialog(null, jsp);
			}finally {
				//4.연결 끊기
				if(br!=null) br.close();
			}
		}		
	}

	public static void main(String[] args) {
		UseFile uf = new UseFile();
		try {
			uf.useByteStream();
			uf.useStringStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
