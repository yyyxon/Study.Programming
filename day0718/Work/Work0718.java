package day0718.Work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Work0718 {
	
	public void printFileList() throws IOException {
		String path = JOptionPane.showInputDialog("디렉토리 경로를 입력해주세요.");
		File file = new File(path);
		if(file.exists()) {
			File[] fileList = file.listFiles();
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────");
			System.out.printf("이름\t\t\t\t\t|수정한 날짜\t\t|유형\t|크기\n");
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────");
			for(int i = 0; i < fileList.length; i++) {
				Date lastModiDate = new Date(fileList[i].lastModified());
				System.out.printf("%-40s|%s\t|%s\t|%s\n",
						fileList[i].getName(),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(lastModiDate),
						fileList[i].isFile()?"파일":"폴더",
						fileList[i].isFile()?String.valueOf(fileList[i].length()):"");
				if(i!=fileList.length-1) {					
					System.out.println("‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥‥");
				}
			}
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────");
		}else {
			JOptionPane.showMessageDialog(null, "디렉토리 경로가 존재하지 않습니다.");
		}
	}
	
	public void usePrintFileList() {
		try {
			printFileList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
