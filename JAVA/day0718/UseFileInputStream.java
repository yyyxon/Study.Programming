package day0718;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UseFileInputStream {
							//FileNotFoundException은 IOException의 자식 클래스
	public UseFileInputStream() throws IOException { 
		//8bit stream을 사용하여 File에 연결하고 파일 내용을 읽기
		JFrame jframe = new JFrame();
		FileDialog fdOpen = new FileDialog(jframe,"파일을 선택해주세요.",FileDialog.LOAD);
		String path = fdOpen.getDirectory();
		fdOpen.setVisible(true);
		
		if(path!=null) {
			File file = new File(path+fdOpen.getFile());
			if(file.exists()) {//파일이 존재한다면
				//1.스트림을 파일에 연결
				FileInputStream fis = new FileInputStream(file); 
				//2.반복문을 사용하여 파일에서 데이터를 읽어온 후 데이터를 출력
				int data = 0;
				while((data=fis.read()) != -1) {
					System.out.print((char)data);
				}
				//3.스트림 연결 끊기
				fis.close();
			}else {
				JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다.");
			}
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
