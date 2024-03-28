package day0816.work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.co.sist.dao.DbConn;

public class Work0816Event implements ActionListener{
	
	private Work0816 w;
	private String name;
	private int age;
	private int num;
	private String img;
	
	public Work0816Event(Work0816 w) {
		this.w = w;
	}
	
	public void setData() {
		num = Integer.parseInt(w.getJtfNum().getText());
		name = w.getJtfName().getText();
		img = new StringBuilder("E:/dev/workspace/jdbc_prj/src/kr/co/sist/work/img/img")
				.append(w.getJcbImg().getSelectedItem())
				.append(".png").toString();
		age = Integer.parseInt(w.getJtfAge().getText());
	}
	
	public void insertUser() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("localhost", "scott", "tiger");
			String insertUser = "insert into work_user(num,name,img,age) values(?,?,?,?)";
			pstmt = con.prepareStatement(insertUser);
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, img);
			pstmt.setInt(4, age);
			
			pstmt.executeUpdate();
		}finally {
			db.closeDB(null, pstmt, con);
		}
		
	}
	
	public void selectUser(int num) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = DbConn.getInstance();
		ResultSet rs = null;
		
		try {
			con = db.getConnection("localhost", "scott", "tiger");
			String selectUser = "select num, name, img, age from work_user where num = ?";
			pstmt = con.prepareStatement(selectUser);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//String imgItem = rs.getString("img").substring(rs.getString("img").lastIndexOf(".")-1,1);
				w.getJtfNum().setText(String.valueOf(rs.getInt("num")));
				w.getJtfName().setText(rs.getString("name"));
				System.out.println(imgItem);
				w.getJcbImg().setSelectedItem(imgItem);
				w.getJtfAge().setText(String.valueOf(rs.getInt("age")));
			}
		}finally {
			db.closeDB(rs, pstmt, con);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == w.getJbtnAdd()) {
			setData();
			try {
				insertUser();
				JOptionPane.showMessageDialog(null, "학생 정보가 추가되었습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == w.getJbtnSearch()) {
			try {
				selectUser(Integer.parseInt(w.getJtfNum().getText()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
