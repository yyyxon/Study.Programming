package day0821.work;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class Work0821Evt extends MouseAdapter{
	
	private Work0821 w;
	
	public Work0821Evt() {
	}
	
	public Work0821Evt(Work0821 w) {
		this.w = w;
		w.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				w.dispose();
			}
		});
		setEmpnos();
	}//Work0821Evt

	public void setEmpnos() {
		Work0821DAO wDAO = Work0821DAO.getInstance();
		List<Integer> empnoList;
		
		try {
			empnoList = wDAO.selectEmpnos();
			for(int empno : empnoList) {
				w.getDlmEmpno().addElement(empno);
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//setEmpnos

	public void useSelectEmpInfo() {
		int empno = w.getDlmEmpno().getElementAt(w.getJlEmpno().getSelectedIndex());
		Work0821DAO wDAO = Work0821DAO.getInstance();
		Work0821SubView wSV = Work0821SubView.getInstance(w);
		
		try {
			Work0821VO wVO = wDAO.selectEmpInfo(empno);
			
			if(wVO == null) {
				JOptionPane.showMessageDialog(w, empno + "번 사원은 존재하지 않습니다.");
				return;
			}
			
			wSV.subView();
			wSV.getJtfEmpno().setText(String.valueOf(wVO.getEmpno()));
			wSV.getJtfEname().setText(wVO.getEname());
			wSV.getJtfHireDate().setText(String.valueOf(wVO.getHiredate()));
			wSV.getJtfJob().setText(wVO.getJob());
			wSV.getJtfSal().setText(String.valueOf(wVO.getSal()));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//useSelectEmpInfo
	
	@Override
	public void mouseClicked(MouseEvent me) {
		switch(me.getButton()) {
		case MouseEvent.BUTTON1: 
			useSelectEmpInfo();
			break;
		}//end switch
		
	}//mouseClicked

}
