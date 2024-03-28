package day0817;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


//직렬화
@SuppressWarnings("serial")
public class ZipcodeSearchDesign extends JFrame {
	private DefaultTableModel dtmZipcode;
	private JTable jtZipcode;
	private JScrollPane jspJtZipcode;
	private JTextField jtfDong, jtfSelZipcode, jtfSelAddr;
	private JButton jbtnSearch;
	
	public ZipcodeSearchDesign() {
		super("우편번호 검색");
		//Model객체화
		String[] columnNames = {"우편번호","주소"};
		
		JLabel jlblDong = new JLabel("동 이름");
		jtfDong = new JTextField(10);
		
		jbtnSearch = new JButton("조회");
		
		jtfSelZipcode = new JTextField(5);
		jtfSelAddr = new JTextField(20);
		
		dtmZipcode = new DefaultTableModel(null, columnNames);
		
		jtZipcode = new JTable(dtmZipcode);
		
		jspJtZipcode = new JScrollPane(jtZipcode);
		jspJtZipcode.setBorder(new TitledBorder("우편번호 검색"));
		
		//컬럼 크기 변경 - 컬럼객체 얻고 setPreferredWidth
		jtZipcode.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtZipcode.getColumnModel().getColumn(1).setPreferredWidth(420);
		
		//행크기 변경 - setRowHeight
		jtZipcode.setRowHeight(25);
		
		JPanel jpNorth = new JPanel();
		jpNorth.add(jlblDong);
		jpNorth.add(jtfDong);
		jpNorth.add(jbtnSearch);
		
		JPanel jpSouth = new JPanel();
		jpSouth.add(new JLabel("우편 번호"));
		jpSouth.add(jtfSelZipcode);
		jpSouth.add(new JLabel("주소"));
		jpSouth.add(jtfSelAddr);
		
		add("North",jpNorth);
		add("Center",jspJtZipcode);
		add("South",jpSouth);
		
		ZipcodeSearchEvt zse = new ZipcodeSearchEvt(this);
		jbtnSearch.addActionListener(zse);
		jtfDong.addActionListener(zse);
		jtZipcode.addMouseListener(zse);
		
		setVisible(true);
		setBounds(680,200,500,600);
		
	}//ZipcodeSearchDesign

	public DefaultTableModel getDtmZipcode() {
		return dtmZipcode;
	}

	public JTable getJtZipcode() {
		return jtZipcode;
	}

	public JScrollPane getJspJtZipcode() {
		return jspJtZipcode;
	}

	public JTextField getJtfDong() {
		return jtfDong;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}
	
	public JTextField getJtfSelZipcode() {
		return jtfSelZipcode;
	}

	public JTextField getJtfSelAddr() {
		return jtfSelAddr;
	}

	public static void main(String[] args) {
		new ZipcodeSearchDesign();

	}//main

}//class
