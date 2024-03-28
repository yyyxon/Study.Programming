package day0817.work;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Work0817 extends JFrame {
	
	private JComboBox<String> jcbTableName;
	private DefaultTableModel dtmTableInfo;
	
	public Work0817() throws SQLException{
		super("테이블 구조");
		
		//ComboBox
		jcbTableName = new JComboBox<String>();
		
		//JPanel
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		
		//JTable
		String[] colName = {"컬럼명","데이터형","null허용","default"};
		dtmTableInfo = new DefaultTableModel(null,colName);
		JTable jtbTableInfo = new JTable(dtmTableInfo);
		JScrollPane jspTableInfo = new JScrollPane(jtbTableInfo);
		
		jpNorth.add(jcbTableName);
		jpCenter.add(jspTableInfo);
		
		add("North", jpNorth);
		add("Center", jpCenter);
		
		WorkEvt wEvt = new WorkEvt(this);
		jcbTableName.addActionListener(wEvt);
		addWindowListener(wEvt);
		
		setBounds(600,300,585,300);
		setVisible(true);
	}
	
	public DefaultTableModel getDtmTableInfo() {
		return dtmTableInfo;
	}

	public JComboBox<String> getJcbTableName() {
		return jcbTableName;
	}
	
	public static void main(String[] args) {
		try {
			new Work0817();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
