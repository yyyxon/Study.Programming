package day0719;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener {
	
	private JLabel jlblOutput;
	private JProgressBar jpb;
	int value;
	
	public FileCopy() {
		super("파일복사");
		jpb = new JProgressBar();
		jlblOutput = new JLabel("  ");
		jlblOutput.setBorder(new TitledBorder("출력창"));
		JButton jbtnFileSelect = new JButton("파일 선택");
		JPanel jpCenter = new JPanel();
		
		jpCenter.setLayout(new BorderLayout());
		jpCenter.add("North",jbtnFileSelect);
		jpCenter.add("South",jpb);
		
		add(jpCenter,"Center");
		add(jlblOutput,"South");
		
		jbtnFileSelect.addActionListener(this);
		
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//FileCopy

	public void selectFile() {
		FileDialog fdOpen = new FileDialog(this,"복사할 파일 선택",FileDialog.LOAD);
		fdOpen.setVisible(true);
		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();
		if(path!=null) {
			jpb.setValue(0);
			value = 0;
			try {
				fileCopy(path+name);	
				JOptionPane.showMessageDialog(this, "파일을 복사하였습니다.");
			}catch(IOException ie) {
				JOptionPane.showMessageDialog(this, "뎨둉합니다. \n파일을 복사하는 도중 문제 발생");
				ie.printStackTrace();
			}
		}//end if
	}//selectFile
	
	private void fileCopy(String path) throws IOException{
		//1.파일을 생성
		File originalFile = new File(path);
		//복사할 파일명은 원본 파일명에 _bak 붙은 이름으로 생성
		//예) a.txt => a_bak.txt
		StringBuilder tempPath = new StringBuilder(originalFile.getAbsolutePath());
		tempPath.insert(tempPath.lastIndexOf("."), "_bak");
		File copyFile = new File(tempPath.toString());
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//2.입력 스트림을 생성
			fis = new FileInputStream(originalFile);
			
			//3.출력 스트림을 생성
			fos = new FileOutputStream(copyFile);
			
			//4.파일에서 읽어들인 내용을 출력 스트림을 통해 내보낸다.
			int readCnt = 0;
			int readByte = 0;
			int cnt = 0;
			byte[] readData = new byte[512]; //하드디스크에서 읽어들인 값을 저장할 배열 
			while((readCnt = fis.read(readData))!=-1) {
				//배열의 길이만큼 값을 읽고 해당 배열에 값 저장, 읽은 바이트수를 리턴
				//방에 값을 저장하고, 저장한 방의 개수를 반환
				fos.write(readData,0,readCnt);
				//쓸 값,시작위치,길이
				readByte += readCnt; //읽은 누적 byte 값
				//총 크기에서 누적 byte값을 나눔 => 어느정도 읽었는지
				//jpb.setValue((int)(readByte*100/originalFile.length()));
				cnt++;
			}
			
			jpb.setMaximum(cnt);
			for(int i = 0; i < jpb.getMaximum(); i++) {
				jpb.setValue(++value);
			}

			//5.스트림의 내용을 분출
			fos.flush();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.스트림 연결 해제
			if(fis!=null) fis.close();
			if(fos!=null) fos.close();
		}
	}//fileCopy
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jpb.setValue(0);
		value = 0;
		selectFile();
	}

	public static void main(String[] args) {
		new FileCopy();
	}

}
