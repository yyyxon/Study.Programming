package day0719;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class UseFileOutputStream {
	
	public void useFileOutputStream() throws IOException {
		//1.File 생성
		File file = new File("e:/dev/temp/my_data.txt");
		//2.스트림 연결
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			//3.스트림에 데이터 쓰기
			//기본형 데이터형은 flush 하지 않아도 써짐
//			int data = 67;
//			fos.write(data);
//			byte[] byteData = {13,65,66,67};
//			fos.write(byteData);
			
			byte[] byteData = "오전시간은 Steam에 대해서 배웠습니다.".getBytes();
			fos.write(byteData);
			
			//4.목적지로 분출
			fos.flush();
		}finally {			
			//5.스트림 연결 끊기
			//write에서 예외가 생기면 IOException으로 넘어가서 close가 되지 않음
			if(fos!=null) fos.close();
		}

	}
	
	public void combinationStream() throws IOException {
		//파일이 존재하는지 물어보고 파일이 없다면 파일을 생성하고,
		//파일이 존재한다면 덮어쓸 것인지 물어본 후(confirm Dialog)
		//예가 눌리면 덮어쓰고, 아니오나 취소가 눌리면 파일 쓰기를 하지 않는다.
		
		//1.파일 생성
		File file = new File("e:/dev/temp/string_write.txt");
		boolean writeFlag = false;
		
		//제어하는 부분
		if(file.exists()) {
			switch (JOptionPane.showConfirmDialog(null, file.getName()+"이 존재합니다. 덮어쓰시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				writeFlag = true;
				break;
			}
		}else {
			writeFlag = true;
		}
		
		//동작하는 부분
		if(writeFlag) {
			OutputStreamWriter osw = null;
			try{				
				//2.스트림 연결(FileOutputStream은 파일이 존재하지 않으면 생성함)
				osw = new OutputStreamWriter(new FileOutputStream(file));
				String msg = JOptionPane.showInputDialog("내용을 입력하세요.");
				//3.스트림에 데이터를 기록
				osw.write(msg);
				//4.목적지로 분출
				osw.flush();
			}finally {			//5.연결 해제
				if(osw!=null) { osw.close(); }
			}
		}
	}

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			//ufos.useFileOutputStream();
			ufos.combinationStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
