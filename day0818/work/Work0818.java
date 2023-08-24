package day0818.work;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Work0818 extends JFrame{
	
	public Work0818() {

	}
	
	public void useSearchCarInfo() {
		WorkDAO wDAO = WorkDAO.getInstance();
		String maker = JOptionPane.showInputDialog(null, "차량의 제조사를 입력해주세요.").replace(" ", "");
		
		try {
			List<WorkVO> carInfoList = wDAO.searchCarInfo(maker);
			if(carInfoList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "조회된 차량 정보가 없습니다.");
				return;
			}
			
			JTextArea jtaCarInfo = new JTextArea();
			jtaCarInfo.setEditable(false);
			jtaCarInfo.setBackground(new Color(0xCEFBC9));
			
			StringBuilder info = new StringBuilder();
			info.append("[제조국]\t[제조사]\t[모델명]\t[연식]\t[가격]\t[옵션]\n");
			
			for(WorkVO carInfo : carInfoList){
				info
				.append(carInfo.getCountry())
				.append("\t")
				.append(carInfo.getMaker())
				.append("\t")
				.append(carInfo.getModel())
				.append("\t")
				.append(carInfo.getCar_year())
				.append("\t")
				.append(carInfo.getPrice())
				.append("\t")
				.append(carInfo.getCar_option())
				.append("\n");
			}
			
			jtaCarInfo.setText(info.toString());
			
			JOptionPane.showMessageDialog(null, jtaCarInfo, maker + " 차량 정보", JOptionPane.PLAIN_MESSAGE);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Work0818().useSearchCarInfo();	
	}
}
