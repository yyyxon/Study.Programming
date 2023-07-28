package day0714.Work;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JavaMemoFont extends JDialog {
	
	private DefaultListModel<String> dlmFont;
	private DefaultListModel<String> dlmStyle;
	private DefaultListModel<Integer> dlmSize;
	
	private JList<String> jlFont;
	private JList<String> jlStyle;
	private JList<Integer> jlSize;
	
	private JTextField jtfFont;
	private JTextField jtfStyle;
	private JTextField jtfSize;
	
	private JLabel jlblPreview;
	
	private JButton jbtnOk;
	private JButton jbtnCancel;
	
	private JTextArea jtaNote;
	
	public JavaMemoFont(JavaMemo jm) {
		super(jm,"글꼴",true);
		
		jtaNote = jm.getJtaNote();
		Font noteFont = jtaNote.getFont();
		
		dlmFont = new DefaultListModel<String>();
		dlmStyle = new DefaultListModel<String>();
		dlmSize = new DefaultListModel<Integer>();
		
		jlFont = new JList<String>(dlmFont);
		jlStyle = new JList<String>(dlmStyle);
		jlSize = new JList<Integer>(dlmSize);
		
		JScrollPane jspFont = new JScrollPane(jlFont);
		JScrollPane jspStyle = new JScrollPane(jlStyle);
		JScrollPane jspSize = new JScrollPane(jlSize);
		
		jtfFont = new JTextField(noteFont.getFontName());
		jtfStyle = new JTextField(getStyleStr(noteFont.getStyle()));
		jtfSize = new JTextField(String.valueOf(noteFont.getSize()));
		jtfFont.setFont(new Font(jtfFont.getText(),Font.PLAIN,13));
		jtfStyle.setFont(new Font(jtfFont.getText(),noteFont.getStyle(),13));
		
		jbtnOk = new JButton("확인");
		jbtnCancel = new JButton("취소");
		jbtnOk.setBackground(Color.lightGray);
		jbtnCancel.setBackground(Color.lightGray);
		
		JLabel jlblFont = new JLabel("글꼴(F):");
		JLabel jlblStyle = new JLabel("글꼴 스타일(Y):");
		JLabel jlblSize = new JLabel("크기(S):");
		
		jlblPreview = new JLabel("AaBbYyZz");
		jlblPreview.setBorder(new TitledBorder("보기"));
		jlblPreview.setFont(jm.getJtaNote().getFont());
		
		setLayout(null);
		
		jlblFont.setBounds(12,10,50,20);
		jlblStyle.setBounds(200,10,100,20);
		jlblSize.setBounds(347,10,50,20);
		
		jtfFont.setBounds(12,30,173,23);
		jtfStyle.setBounds(200,30,131,23);
		jtfSize.setBounds(347,30,64,23);
		
		//jlFont.setBounds(12, 60, 172, 110);
		//jlStyle.setBounds(200, 60, 130, 110);
		//jlSize.setBounds(347, 60, 63, 100);
		
		jspFont.setBounds(12, 60, 172, 110);
		jspStyle.setBounds(200, 60, 130, 110);
		jspSize.setBounds(347, 60, 63, 100);
		
		jlblPreview.setBounds(199, 180, 213, 84);
		
		jbtnOk.setBounds(248,405,75,22);
		jbtnCancel.setBounds(335,405,75,22);
		
		add(jlblFont);
		add(jlblStyle);
		add(jlblSize);
		add(jtfFont);
		add(jtfStyle);
		add(jtfSize);
		add(jspFont);
		add(jspStyle);
		add(jspSize);
		add(jlblPreview);
		add(jbtnOk);
		add(jbtnCancel);
		
		setBounds(jm.getX()+50,jm.getY()+100,441,478);
		setResizable(false);
		
		JavaMemoFontEvt jmfe = new JavaMemoFontEvt(this);
		jlFont.addListSelectionListener(jmfe);
		jlStyle.addListSelectionListener(jmfe);
		jlSize.addListSelectionListener(jmfe);
		jbtnOk.addActionListener(jmfe);
		jbtnCancel.addActionListener(jmfe);
		addWindowListener(jmfe);
		
		setVisible(true);
		
	}

	public JTextArea getJtaNote() {
		return jtaNote;
	}

	public JButton getJbtnOk() {
		return jbtnOk;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}

	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}

	public DefaultListModel<String> getDlmStyle() {
		return dlmStyle;
	}

	public DefaultListModel<Integer> getDlmSize() {
		return dlmSize;
	}

	public JList<String> getJlFont() {
		return jlFont;
	}

	public JList<String> getJlStyle() {
		return jlStyle;
	}

	public JList<Integer> getJlSize() {
		return jlSize;
	}

	public JTextField getJtfFont() {
		return jtfFont;
	}

	public JTextField getJtfStyle() {
		return jtfStyle;
	}

	public JTextField getJtfSize() {
		return jtfSize;
	}

	public JLabel getJlblPreview() {
		return jlblPreview;
	}
	
	public String getStyleStr (int style) {
		String styleStr = "";
		
		if(style == Font.PLAIN) {
			styleStr = "일반";
		}else if(style == Font.BOLD) {
			styleStr = "굵게";
		}else if(style == Font.ITALIC) {
			styleStr = "기울임꼴";
		}else {
			styleStr = "굵은 기울임꼴";
		}
		
		return styleStr;
	}

}
