package day0706;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TestInputDialog {
		
	List<WorkVO> dataList;
	public TestInputDialog() {
		dataList = new ArrayList<WorkVO>();
		inputDialog();
	}
	
	public void inputDialog() {
		WorkVO dataVO;
		String data;
		String[] dataArr = null;
		int java, oracle;
		boolean flag;
		
		while(true) {
			data = JOptionPane.showInputDialog("이름,자바점수,오라클 점수를 입력\n\"출력\"을 입력하시면 출력합니다."
					+ "\n그만두시려면 Y[y]를 입력해주세요.");
			dataArr = data.split(",");
			flag = dataArr.length == 3 && !(dataArr[0].isEmpty() || 
					dataArr[1].isEmpty() || dataArr[2].isEmpty());
			if(flag) {
				dataVO = new WorkVO(dataArr);
				java = dataVO.getJava();
				oracle = dataVO.getOracle();
				if(java < 0 || java > 100 || oracle < 0 || oracle > 100) {
					System.out.println("점수는 0~100사이의 값 입니다. 다시 입력해주세요.");
					continue;
				}
				dataList.add(dataVO);
			}else if(data.equals("출력")) {
				System.out.println("이름\t자바\t오라클\t총점");
				for(int i = 0; i < dataList.size(); i++) {
					System.out.printf("%s\t\n",dataList.get(i).toString());
				}
				break;
			}else if(data.equals("Y") || data.equals("y")) {
				break;
			}else {
				System.out.println("이름,자바점수,오라클점수를 입력해주세요.");
			}
		}
		
	}//inputDialog
}//class
