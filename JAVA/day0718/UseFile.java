package day0718;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class UseFile {
	
	public UseFile() {
		
	}
	
	public void fileInfo() {		
		File file = new File("e:/dev/temp/java_read.txt");
		System.out.println(file);
		
		//exists() 파일이 존재하는지 (존재 여부)
		if(file.exists()) {
			//isFile() 파일인지 아닌지 (파일 여부)
			System.out.println(file.isFile() ? "파일":"디렉토리");
			//isDirectory() 디렉토리인지 아닌지 (디렉토리 여부)
			System.out.println(file.isDirectory() ? "디렉토리":"파일");
			//canRead() 파일을 읽어올 수 있는지 (읽기 여부)
			System.out.println("읽기 " + (file.canRead() ? "쌉가능":"불가능"));
			//canWrite() 파일을 쓸 수 있는지 (쓰기 여부) - 읽기 전용인 경우 불가능함
			System.out.println("쓰기 " + (file.canWrite() ? "쌉가능":"불가능"));
			//isHidden() 파일이 숨겨져 있는지 (숨김 여부)
			System.out.println(file.isHidden() ? "숨김파일":"일반파일");
			//length() 파일의 길이(크기)
			System.out.println(file.length());
			//getAbsolutePath() 파일의 절대경로
			System.out.println(file.getAbsolutePath());
			//getCanonicalPath() 파일의 규범경로 (변경x)
			try {
				System.out.println(file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//canExecute() 파일의 실행가능 여부
			System.out.println(file.canExecute() ? "실행 가능":"불가능");
			//getParent() 파일이 위치하는 디렉토리명
			System.out.println("파일이 위치하는 디렉토리명 : " + file.getParent());
			//getName() 파일명
			System.out.println("파일명 : " + file.getName());
			//lastModified() 마지막으로 수정된 날짜
			Date date = new Date(file.lastModified());
			System.out.println("파일이 마지막으로 수정된 날짜 : " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}//fileInfo
	
	public void createDirectory() {
		//상위 디렉토리가 존재하면 file.mkdir()과 file.mkdirs()가 동일한 동작을 수행
		/*
		File file = new File("e:/dev/temp/ysy");
		if(file.mkdirs()) {
			System.out.println("디렉토리 생성");
		}else {
			System.out.println("디렉토리 생성 실패");
		}//end else
		*/
		
		//mkdirs() 부모 디렉토리가 없다면 부모 디렉토리와 모든 하위 디렉토리 생성
		//mkdir() 부모 디렉토리가 없다면 하위 디렉토리를 생성하지 못함
		//mkdir,mkdirs는 '디렉토리'를 생성하는 것, '파일'을 생성하려면 outputStream 이용
		File file = new File("e:/dev222/temp/ysy");
		if(file.mkdir()) {
			System.out.println("디렉토리 생성");
		}else {
			System.out.println("디렉토리 생성 실패");
		}//end else
		
		//1.InputDialog를 제공하여 사용자에게 생성할 디렉토리 경로를 입력받는다.
		//e:/dev/abc
		//2.디렉토리가 존재하지 않으면 "디렉토리가 존재하지않습니다. 생성할까요?"
		//라는 confirmDialog를 제공하고 "예"가 눌리면 디렉토리를 생성 후
		//3.messageDialog로 "생성되었습니다."를 보여준다.
		String dirPath = JOptionPane.showInputDialog("생성할 디렉토리 경로를 입력해주세요.");
		File dirFile = new File(dirPath);
		if(!dirFile.exists()) {
				int dirConfirm = JOptionPane.showConfirmDialog(null, "디렉토리가 존재하지 않습니다. 생성할까요?");
				switch (dirConfirm) {
				case JOptionPane.OK_OPTION:
					dirFile.mkdirs();
					JOptionPane.showMessageDialog(null, "생성되었습니다.");
					break;
				default:
					break;
				}
		}else {
			JOptionPane.showMessageDialog(null, "디렉토리가 존재합니다.");
		}
	}//createDirectory
	
	//delete() 파일 삭제
	public void removeFile() {
		//1.삭제할 파일의 경로로 파일을 생성
		File file = new File("e:/dev/temp/a.txt");
		//2.삭제
		if(file.delete()) {
			System.out.println("파일 삭제");
		}else {
			System.out.println("파일이 삭제되지 않았습니다.");
		}//end else
		
	}
	
	public void rename() {
		//1. 변경 전 이름을 가진 객체 생성
		File file = new File("e:/dev/temp/b.txt");
		//2. 변경 할 이름을 가진 객체 생성
		File newFile = new File("e:/dev/temp/ysy.txt");
		//3.변경
		if(file.renameTo(newFile)) {
			System.out.println("파일명이 변경되었습니다.");
		}else {
			System.out.println("파일명이 변경되지않았습니다.");
			//기존 파일이 없는 경우
		}//end else
		
	}

	public static void main(String[] args) {
		UseFile uf = new UseFile();
		uf.fileInfo();
		//uf.createDirectory();
		uf.removeFile();
		uf.rename();
	}

}
