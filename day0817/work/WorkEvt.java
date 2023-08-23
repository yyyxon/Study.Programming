package day0817.work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class WorkEvt extends WindowAdapter implements ActionListener{
	
	private Work0817 w;
	
	public WorkEvt(Work0817 w) {
		this.w = w;
		setTableNames();
	}
	
	public void setTableNames() {
		WorkDAO wDAO = WorkDAO.getInstance();
		List<String> tableName;
		try {
			tableName = wDAO.selectTableName();
			for(String tname : tableName) {
				w.getJcbTableName().addItem(tname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void searchTableInfo() {
		WorkDAO wDAO = WorkDAO.getInstance();
		String tableName = w.getJcbTableName().getSelectedItem().toString();
		try {
			List<WorkVO> list = wDAO.searchTableInfo(tableName);
			
			//JTable에 설정된 모든 행을 삭제 - setRowCount
			w.getDtmTableInfo().setRowCount(0);
			
			String[] rowData = null;
			//String columnName, String dataType, int dataSize, int isNull, String isDefault
			for(WorkVO wVO : list) {
				//1.검색된 행을 채울 1차원 배열 생성
				rowData = new String[5];
				StringBuilder dataType = new StringBuilder();
				dataType
				.append(wVO.getDataType())
				.append("(")
				.append(wVO.getDataSize())
				.append(")");
				//2.생성된 배열에 값을 설정
				rowData[0] = wVO.getColumnName();
				rowData[1] = dataType.toString();
				rowData[2] = wVO.getIsNull().equals("Y") ? "" : "not null";
				rowData[3] = wVO.getIsDefault();
				
				//값을 가진 일차원 배열을 JTable에 설정하기 위해
				//Model 객체를 사용 - addRow
				w.getDtmTableInfo().addRow(rowData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//catch			
	}//end if
			
	@Override
	public void actionPerformed(ActionEvent e) {
		searchTableInfo();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		w.dispose();
	}
}
