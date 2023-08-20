package day0814.work;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import kr.co.sist.dao.DbConn;
import kr.co.sist.statement.UseStatementDAO;

@SuppressWarnings("serial")
public class Work0814_2 extends JFrame{
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	DbConn dc = null;
	
	public Work0814_2() throws SQLException {
		super("Table name");
		dc = DbConn.getInstance();
		con = dc.getConnection("localhost", "scott", "tiger");
		stmt = con.createStatement();		
		rs = stmt.executeQuery("select tname from tab");
	}
	
	public void comboBox() throws SQLException {
		try {
			setLayout(new FlowLayout());
			DefaultComboBoxModel<String> dcbTableName = new DefaultComboBoxModel<String>();
			JComboBox<String> jcbTableName = new JComboBox<String>(dcbTableName);
			
			while(rs.next()) {
				dcbTableName.addElement(rs.getString("tname"));
			}
			
			add(jcbTableName);
			setSize(585,300);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}finally {
			dc.closeDB(rs, stmt, con);
		}
		
	}
	
	public void radioBtn() throws SQLException {
		UseStatementDAO usDAO = new UseStatementDAO();
		try {
			List<String> tableNameList = usDAO.selectTableName();
			if(tableNameList.isEmpty()) {
				System.out.println("테이블이 존재하지 않습니다.");
			}else {
				ButtonGroup bg = new ButtonGroup();
				JRadioButton jrb = null;
				setLayout(new FlowLayout());
				
				for(String tName : tableNameList) {
					jrb = new JRadioButton(tName);
					bg.add(jrb);
					add(jrb);
				}
				
				setBounds(100,200,585,300);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			new Work0814_2().radioBtn();
			new Work0814_2().comboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
