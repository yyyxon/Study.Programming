package day0816.work;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Work0816 extends JFrame{
	
	private JButton jbtnAdd;
	private JButton jbtnSearch;
	private JTextField jtfName;
	private JTextField jtfAge;
	private JTextField jtfNum;
	private JComboBox<String> jcbImg;
	private JLabel img;
	
	public Work0816() {
		super("Student Info");
		Font font = new Font("맑은 고딕", ABORT, 20);
		
		JLabel jlbName = new JLabel("이름");
		JLabel jlbImg = new JLabel("이미지");
		JLabel jlbAge = new JLabel("나이");
		JLabel jlbNum = new JLabel("번호");
		
		jtfName = new JTextField();
		jtfAge = new JTextField();
		jtfNum = new JTextField();
		
		jbtnAdd = new JButton("정보 추가");
		jbtnSearch = new JButton("정보 검색");
		
		jcbImg = new JComboBox<String>();
		
		ImageIcon defaultImg = new ImageIcon("E:/dev/workspace/jdbc_prj/src/kr/co/sist/work/img/defualt.png");
		img = new JLabel(defaultImg);
		
		jbtnAdd.setBounds(170,200,100,30);
		jbtnSearch.setBounds(280,200,100,30);
		
		img.setBounds(350,30,150,150);
		
		jcbImg.addItem("1");
		jcbImg.addItem("2");
		jcbImg.addItem("3");
		jcbImg.addItem("4");
		
		jlbName.setFont(font);
		jlbImg.setFont(font);
		jlbAge.setFont(font);
		jlbNum.setFont(font);
		jbtnAdd.setFont(new Font("맑은 고딕",ABORT,13));
		jbtnSearch.setFont(new Font("맑은 고딕",ABORT,13));
		
		jlbName.setBounds(50,30,70,30);
		jlbImg.setBounds(50,70,70,30);
		jlbAge.setBounds(50,110,70,30);
		jlbNum.setBounds(50,150,70,30);
		
		jtfName.setBounds(130,30,200,30);
		jcbImg.setBounds(130,70,200,30);
		jtfAge.setBounds(130,110,200,30);
		jtfNum.setBounds(130,150,200,30);
		
		add(jlbName);
		add(jlbImg);
		add(jlbAge);
		add(jlbNum);
		add(img);
		add(jtfName);
		add(jcbImg);
		add(jtfAge);
		add(jtfNum);
		add(jbtnAdd);
		add(jbtnSearch);
		
		Work0816Event event = new Work0816Event(this);
		jbtnAdd.addActionListener(event);
		jbtnSearch.addActionListener(event);
		
		setLayout(null);
		setBounds(650,300,600,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JButton getJbtnAdd() {
		return jbtnAdd;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAge() {
		return jtfAge;
	}

	public JTextField getJtfNum() {
		return jtfNum;
	}

	public JComboBox<String> getJcbImg() {
		return jcbImg;
	}
	
	public JLabel getImg() {
		return img;
	}

	public static void main(String[] args) {
		new Work0816();
	}

}
