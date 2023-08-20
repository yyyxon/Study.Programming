package day0814.work;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.co.sist.dao.DbConn;

public class Work0814 extends JFrame{
	
	public Work0814() throws SQLException {
		super("Table name");
		DbConn dc = DbConn.getInstance();
		Connection con = null;
		Statement stmt = null;		
		ResultSet rs = null;
		
		try {
			con = dc.getConnection("localhost", "scott", "tiger");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select num from ttest");
			
			if(rs.next() == false) {
				JOptionPane.showMessageDialog(null, "레코드가 존재하지 않습니다.");
				return;
			}	
			
			setLayout(new FlowLayout());
			DefaultComboBoxModel<String> dcbTableName = new DefaultComboBoxModel<String>();
			JComboBox<String> jcbTableName = new JComboBox<String>(dcbTableName);
			
			while(rs.next()) {
				dcbTableName.addElement(rs.getString("tname"));
			}
			
			add(jcbTableName);
			setBounds(600,300,585,300);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}finally {
			dc.closeDB(rs, stmt, con);
		}
	}
	
	public static void main(String[] args) {
		try {
			new Work0814();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
