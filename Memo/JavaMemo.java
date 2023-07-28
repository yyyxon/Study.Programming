package day0714.Work;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import day0720.UserData;

@SuppressWarnings("serial")
public class JavaMemo extends JFrame {
	
	private JMenuItem jmiNew;
	private JMenuItem jmiOpen;
	private JMenuItem jmiSave;
	private JMenuItem jmiNewSave;
	private JMenuItem jmiClose;
	private JMenuItem jmiFont;
	private JMenuItem jmiHelp;
	private JTextArea jtaNote;
	private FontVO fontStyleVO;
	
	public JavaMemo() throws ClassNotFoundException, IOException {
		super("메모장");
		
		JMenuBar jmb = new JMenuBar();
		
		//메뉴
		JMenu jmFile = new JMenu("파일");
		JMenu jmStyle = new JMenu("서식");
		JMenu jmHelp = new JMenu("도움말");
		
		//파일
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiNewSave = new JMenuItem("다른 이름으로 저장");
		jmiClose = new JMenuItem("닫기");
		
		//서식
		jmiFont = new JMenuItem("글꼴");
		
		//도움말
		jmiHelp = new JMenuItem("메모장 정보");
		
		//본문
		jtaNote = new JTextArea();
		//jtaNote.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(jtaNote);
		//JScrollBar jb = jsp.getVerticalScrollBar();
		//jb.setValue(jb.getMaximum());

		//파일 add
		jmFile.add(jmiNew);
		jmFile.addSeparator();
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.add(jmiNewSave);
		jmFile.addSeparator();
		jmFile.add(jmiClose);
		
		//서식 add
		jmStyle.add(jmiFont);
		
		//도움말 add
		jmHelp.add(jmiHelp);
		
		//본문 add
		add(jsp);
		
		//메뉴바 add
		jmb.add(jmFile);
		jmb.add(jmStyle);
		jmb.add(jmHelp);
		setJMenuBar(jmb);
		
		//폰트
		FontVO font = new FontVO();
		Font menuFont = new Font("맑은 고딕",ABORT,15);
		Font itemFont = new Font("맑은 고딕",ABORT,14);
		jmFile.setFont(menuFont);
		jmStyle.setFont(menuFont);
		jmHelp.setFont(menuFont);
		jmiNew.setFont(itemFont);
		jmiOpen.setFont(itemFont);
		jmiSave.setFont(itemFont);
		jmiNewSave.setFont(itemFont);
		jmiClose.setFont(itemFont);
		jmiFont.setFont(itemFont);
		jmiHelp.setFont(itemFont);
		//writeFont();
		if(new File("/Users/yeon/dev/temp/fontFile.dat").exists()) {
			readFont();			
			jtaNote.setFont(new Font(fontStyleVO.getFontName(),fontStyleVO.getFontStyle(),fontStyleVO.getFontSize()));
		}else {
			jtaNote.setFont(new Font("돋움",Font.PLAIN,15));
		}
		
		//addAction
		JavaMemoEvt jme = new JavaMemoEvt(this);
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiNewSave.addActionListener(jme);
		jmiClose.addActionListener(jme);
		jmiFont.addActionListener(jme);
		jmiHelp.addActionListener(jme);
		addWindowListener(jme);
		
		setBounds(getX()+600,getY()+230,500,500);
		setVisible(true);
	}

	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public JMenuItem getJmiNewSave() {
		return jmiNewSave;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiHelp() {
		return jmiHelp;
	}
	
	public JTextArea getJtaNote() {
		return jtaNote;
	}
	
	public FontVO readFont() throws IOException, ClassNotFoundException {
		//1.스트림 생성
		ObjectInputStream ois = null;
		try {
			//2.스트림에서 객체 읽기
			ois = new ObjectInputStream(new FileInputStream(new File("/Users/yeon/dev/temp/fontFile.dat")));
			FontVO fVO = (FontVO) ois.readObject(); //readObject 반환형 Object 
											//=> 자식 객체에 부모를 넣을 수 없음 => 캐스팅
			fontStyleVO = new FontVO(fVO.getFontName(), fVO.getFontStyle(), fVO.getFontSize());

		}finally {
			//4.연결 끊기
			if(ois!=null) {ois.close();} //close는 IOException을 throws
		}
		
		return fontStyleVO;
	}
}
