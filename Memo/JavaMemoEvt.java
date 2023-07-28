package day0714.Work;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class JavaMemoEvt extends WindowAdapter implements ActionListener{

	private JavaMemo jm;
	private boolean flag;
	private FileDialog fdOpen;
	private FileDialog fdSave;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jm.getJmiNew()) {
			try {
				clearNote();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == jm.getJmiOpen()) {
			try {
				fileOpen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == jm.getJmiSave()) {
			try {
				fileSave();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == jm.getJmiNewSave()) {
			try {
				fileNewSave();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == jm.getJmiClose()) {
			memoClose();
		}
		
		if(ae.getSource() == jm.getJmiFont()) {
			font();
		}
		
		if(ae.getSource() == jm.getJmiHelp()) {
			help();
		}
		
	}
	
	public void clearNote() throws IOException {
		boolean saveFlag = false;
		boolean cleanFlag = false;
		
		if(flag) {
			//열기 한 상태
			File file = new File(fdOpen.getDirectory()+fdOpen.getFile());
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuilder fileContent = new StringBuilder();
			String tempContent = "";
				
			while((tempContent = br.readLine()) != null) {
				fileContent.append(tempContent + "\n");
			}
						
			String noteLastWord = String.valueOf(jm.getJtaNote().getText().charAt(jm.getJtaNote().getText().length()-1));
			if(!noteLastWord.equals("\n")) {
				int fileNewLine = fileContent.toString().lastIndexOf("\n");
				fileContent.deleteCharAt(fileNewLine);
			}
			
			if(fileContent.toString().equals(jm.getJtaNote().getText())) {
				cleanFlag = true;
				flag = false;
			}else {
				System.out.println("!" + fileContent + "!");
				System.out.println("!" + jm.getJtaNote().getText() + "!");
				saveFlag = true;
			}				
			
			if(fileContent.toString().equals("")) {
				jm.setTitle("메모장 - 새글");
				flag = false;
			}

		}else {//열기 안 한 상태
			if(fdSave!=null) {
				StringBuilder fileContent = new StringBuilder();
				File getFile = new File(fdSave.getDirectory()+fdSave.getFile()+".txt");
				if(!jm.getJtaNote().getText().equals("")) {
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getFile)));
					String tempContent = "";
					
					while((tempContent = br.readLine()) != null) {
						fileContent.append(tempContent + "\n");
					}		
					
					String noteLastWord = String.valueOf(jm.getJtaNote().getText().charAt(jm.getJtaNote().getText().length()-1));
					
					if(!noteLastWord.equals("\n")) {
						int fileNewLine = fileContent.toString().lastIndexOf("\n");
						fileContent.deleteCharAt(fileNewLine);
					}
					
					if(!fileContent.toString().equals(jm.getJtaNote().getText())) {
						int confirm = JOptionPane.showConfirmDialog(jm, "저장 하시겠습니까?");
						switch (confirm) {
						case JOptionPane.OK_OPTION:
							saveFlag = true;
							cleanFlag = true;
							break;
						case JOptionPane.NO_OPTION:
							cleanFlag = true;
						}				
					}else {
						cleanFlag = true;
					}
				}
			}else {				
				if(jm.getJtaNote().getText().equals("")) {
					cleanFlag = true;		
				}else {					
					saveFlag = true;
				}
			}
		}
			
		if(saveFlag) {
			int confirm = JOptionPane.showConfirmDialog(jm, "저장 하시겠습니까?");
			switch (confirm) {
			case JOptionPane.OK_OPTION:
				fileSave();
			case JOptionPane.NO_OPTION:
				cleanFlag = true;
				flag = false;
			default:
				break;
			}
		}
		
		if(cleanFlag) {
			jm.setTitle("메모장 - 새글");
			jm.getJtaNote().setText("");
		}
	}
	
	public void fileOpen() throws IOException {
		boolean saveFlag = false;
		boolean openFlag = true;
		StringBuilder fileContent = new StringBuilder();
		
		if(flag) {
			File getFile = new File(fdOpen.getDirectory()+fdOpen.getFile());
			if(!jm.getJtaNote().getText().equals("")) {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getFile)));
				String tempContent = "";
				
				while((tempContent = br.readLine()) != null) {
					fileContent.append(tempContent + "\n");
				}		
				
				String noteLastWord = String.valueOf(jm.getJtaNote().getText().charAt(jm.getJtaNote().getText().length()-1));
				
				if(!noteLastWord.equals("\n")) {
					int fileNewLine = fileContent.toString().lastIndexOf("\n");
					fileContent.deleteCharAt(fileNewLine);
				}
				
				if(!fileContent.toString().equals(jm.getJtaNote().getText())) {
					int confirm = JOptionPane.showConfirmDialog(jm, "저장 하시겠습니까?");
					switch (confirm) {
					case JOptionPane.OK_OPTION:
						saveFlag = true;
						break;
					case JOptionPane.CANCEL_OPTION:
						openFlag = false;
						break;
					}				
				}
			}
		}else {
			if(!jm.getJtaNote().getText().equals("")) {
				if(fdSave.getDirectory()!=null) {
					File getFile = new File(fdSave.getDirectory()+fdSave.getFile()+".txt");
					if(!jm.getJtaNote().getText().equals("")) {
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getFile)));
						String tempContent = "";
						
						while((tempContent = br.readLine()) != null) {
							fileContent.append(tempContent + "\n");
						}		
						
						String noteLastWord = String.valueOf(jm.getJtaNote().getText().charAt(jm.getJtaNote().getText().length()-1));
						
						if(!noteLastWord.equals("\n")) {
							int fileNewLine = fileContent.toString().lastIndexOf("\n");
							fileContent.deleteCharAt(fileNewLine);
						}
						
						if(!fileContent.toString().equals(jm.getJtaNote().getText())) {
							int confirm = JOptionPane.showConfirmDialog(jm, "저장 하시겠습니까?");
							switch (confirm) {
							case JOptionPane.OK_OPTION:
								saveFlag = true;
								break;
							case JOptionPane.CANCEL_OPTION:
								openFlag = false;
								break;
							}				
						}
					}
				}else {
					int confirm = JOptionPane.showConfirmDialog(jm, "저장 하시겠습니까?");
					switch (confirm) {
					case JOptionPane.OK_OPTION:
						saveFlag = true;
						break;
					case JOptionPane.CANCEL_OPTION:
						openFlag = false;
						break;
					}				
				}
			}
		}
		
		if(saveFlag) fileSave();
		
		if(openFlag) {
			fdOpen = new FileDialog(jm,"열기",FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			if(fdOpen.getDirectory()!=null) {
				flag = true;
				BufferedReader br = null;
				jm.setTitle("메모장 - " + fdOpen.getFile());
				try {
					String tempContent = "";
					File file = new File(fdOpen.getDirectory()+fdOpen.getFile());
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					jm.getJtaNote().setText("");
					
					while((tempContent = br.readLine())!=null) {
						jm.getJtaNote().append(tempContent+"\n");							
					}
				}finally {
					if(br!=null) br.close();
				}	
			}
		}
	}
	
	public void fileSave() throws IOException {
		FileOutputStream fos = null;
		if(flag) { //열기 한 상태
			File file = new File(fdOpen.getDirectory()+fdOpen.getFile());
			try {
				fos = new FileOutputStream(file);
				byte[] byteNote = jm.getJtaNote().getText().getBytes();
				fos.write(byteNote);
				fos.flush();
			}finally {
				if(fos!=null) fos.close();
			}
		}else { //열기안 한 상태
			fdSave = new FileDialog(jm,"저장",FileDialog.SAVE);
			fdSave.setVisible(true);
			if(fdSave.getDirectory()!=null) {
				jm.setTitle("메모장 - " + fdSave.getFile());
				fos = null;
				try {
					fos = new FileOutputStream(fdSave.getDirectory()+fdSave.getFile()+".txt");
					
					byte[] byteNote = jm.getJtaNote().getText().getBytes();
					
					fos.write(byteNote);
					fos.flush();
					
				}finally {
					if(fos!=null) fos.close();
				}
			}
		}
	}
	
	public void fileNewSave() throws IOException {
		FileDialog fdNewSave = new FileDialog(jm,"다른 이름으로 저장",FileDialog.SAVE);
		fdNewSave.setVisible(true);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fdNewSave.getDirectory()+fdNewSave.getFile()+".txt");
		
			byte[] byteNote = jm.getJtaNote().getText().getBytes();
		
			fos.write(byteNote);
			fos.flush();
		
		}finally {
			if(fos!=null) fos.close();
		}
	}
	
	public void memoClose() {
		windowClosing(null);
	}
	
	public void font() {
		new JavaMemoFont(jm);
	}
	
	public void help() {
		new MemoInfo(jm);
	}
	
	@Override
	public void windowClosing(WindowEvent we) {

		jm.dispose();
	}
}
