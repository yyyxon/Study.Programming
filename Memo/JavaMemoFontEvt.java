package day0714.Work;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JavaMemoFontEvt extends WindowAdapter implements ActionListener, ListSelectionListener {
	
	private JavaMemoFont jmf;
	private DefaultListModel<String> dlmFont;
	private DefaultListModel<String> dlmStyle;
	private DefaultListModel<Integer> dlmSize;
	private JList<String> jlFont;
	private JList<String> jlStyle;
	private JList<Integer> jlSize;
	private String fontType;
	private int style;
	private int size;
	private String styleStr;
	private Font font;
	
	public JavaMemoFontEvt(JavaMemoFont jmf) {
		this.jmf = jmf;
		
		dlmFont = jmf.getDlmFont();
		dlmStyle = jmf.getDlmStyle();
		dlmSize = jmf.getDlmSize();
		
		jlFont = jmf.getJlFont();
		jlStyle = jmf.getJlStyle();
		jlSize = jmf.getJlSize();
		
		dlmFont.addElement("돋움");
		dlmFont.addElement("맑은 고딕");
		dlmFont.addElement("궁서체");
		dlmFont.addElement("Serif");
		dlmFont.addElement("SansSerif");

		dlmStyle.addElement("일반");
		dlmStyle.addElement("굵게");
		dlmStyle.addElement("기울임꼴");
		dlmStyle.addElement("굵은 기울임꼴");
		
		for(int i = 8; i < 81; i++) {
			if(i < 11) {
				dlmSize.addElement(i);				
			}else{
				dlmSize.addElement(i+1);
				i = i+1;
			}	
		}
		
		font = jmf.getJtaNote().getFont();
		fontType = font.getFontName();
		style = font.getStyle();
		size = font.getSize();
		styleStr = jmf.getStyleStr(style);
		JTextField jtfFont = jmf.getJtfFont();
		
		//필드명 바꿔줌
		//맑은 고딕 Bold -> 맑은 고딕, Serif.Bold -> Serif ... 등
		if(fontType.contains("맑은 고딕")) {
			fontType = "맑은 고딕";
			jtfFont.setText("맑은 고딕");
			jtfFont.setFont(new Font("맑은 고딕",Font.PLAIN,13));
		}else if(fontType.contains("Serif")) {
			if(fontType.substring(0, 5).equals("Serif")) {
				fontType = "Serif";
				jtfFont.setText("Serif");
				jtfFont.setFont(new Font("Serif",Font.PLAIN,13));
			}else {
				fontType = "SansSerif";
				jtfFont.setText("SansSerif");
				jtfFont.setFont(new Font("SansSerif",Font.PLAIN,13));
			}
		}
	}
	
	public void setTextFont() {
		jmf.getJtaNote().setFont(font);
		
		windowClosing(null);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		font = new Font(fontType, style, size);
		jmf.getJlblPreview().setFont(font);
		jmf.getJtfFont().setText(fontType);
		jmf.getJtfFont().setFont(new Font(fontType,Font.PLAIN,13));
		jmf.getJtfStyle().setText(styleStr);
		jmf.getJtfStyle().setFont(new Font(fontType,style,13));
		jmf.getJtfSize().setText(String.valueOf(size));
		
		if(lse.getValueIsAdjusting()) {			
			if(lse.getSource() == jlFont) {
				fontType = dlmFont.getElementAt(jlFont.getSelectedIndex());
			}
			
			if(lse.getSource() == jlStyle) {
				styleStr = dlmStyle.getElementAt(jlStyle.getSelectedIndex());
				if(styleStr.equals("일반")) {
					style = Font.PLAIN;
				}else if(styleStr.equals("굵게")) {
					style = Font.BOLD;
				}else if(styleStr.equals("기울임꼴")) {
					style = Font.ITALIC;
				}else {
					style = Font.BOLD + Font.ITALIC;
				}
			}
			
			if(lse.getSource() == jlSize) {
				size = dlmSize.getElementAt(jlSize.getSelectedIndex());
			}
		}
	}

	public void writeFont() throws IOException {
		
		ObjectOutputStream oos = null;
		try {
			File dir = new File("/Users/yeon/dev/temp");
			if(!dir.exists()) { //디렉토리가 존재하지 않으면
				dir.mkdirs(); //디렉토리를 생성
			}
			oos = new ObjectOutputStream(new FileOutputStream(new File(dir.getAbsolutePath() + "/fontFile.dat")));
			oos.writeObject(new FontVO(fontType,style,size));
			oos.flush();
		}finally {
			//5.연결 해제
			if(oos!=null) oos.close();			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jmf.getJbtnOk()) {
			setTextFont();
			try {
				writeFont();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == jmf.getJbtnCancel()) {
			windowClosing(null);
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		jmf.dispose();
	}
}
