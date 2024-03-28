package day0707;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class Work0707 {

	private Map<Integer,WorkVO> studentMap;
	private WorkVO wVO = null;
	public static final int INPUT = 1;
	public static final int SEARCH = 2;
	public static final int EXIT = 3;
	
		
	public Work0707() {
		studentMap = new HashMap<Integer,WorkVO>();
	}
		
	public void selectMenu() {
		boolean exitFlag = false;
		String menu = "";
		System.out.println("번호\t이름\t자바\t오라클\t총점\t평균");
		do {
			menu = JOptionPane.showInputDialog("메뉴\n1.입력 2.검색 3.종료");
			menu = menu.replace(" ", ""); //white space 처리
			if(menu != null && !menu.equals(" ")) {
				//객체가 생성이 되었으면서 Empty가 아니면 실행
				switch (Integer.parseInt(menu)) {
				case INPUT:
					dataInput();
					break;
				case SEARCH:
					printData();
					break;
				case EXIT:
					exitFlag = exitProgram();
					JOptionPane.showConfirmDialog(null, "사용해주셔서 감사용");
					break;
				default:
					JOptionPane.showInternalMessageDialog(null,"1.입력 2.검색 3.종료입니다.");
				}
			}
		}while(!exitFlag);	
	}
		
	public void dataInput() {
		//입력된 배열을 사용하여 VO를 생성하고 리스트에 추가
		String inputData = JOptionPane.showInputDialog("학생의 정보를 아래처럼 입력해주세요.\n"
				+ "예)학생번호,이름,자바,오라클").replace(" ", "");
		if(inputData != null && !inputData.equals(" ")) {
			String[] dataArr = inputData.split(",");
			if(dataArr.length == 4) {
				wVO = new WorkVO(Integer.parseInt(dataArr[0]),
						dataArr[1],Integer.parseInt(dataArr[2]),Integer.parseInt(dataArr[3]));
				if(studentMap.containsKey(wVO.getNumber())) {
					JOptionPane.showInternalMessageDialog(null,"학생번호가 존재합니다.");
				}else{						
					studentMap.put(wVO.getNumber(), wVO);				
				}
			}
		}
	}
		
	public void printData() {
		int stuNum = Integer.parseInt(JOptionPane.showInputDialog("검색하려는 학생 번호를 입력해주세요."));
		if(studentMap.containsKey(stuNum)) { //size() == 0 보다 isEmpty!!!
			wVO = studentMap.get(stuNum);
			int java = wVO.getJavaScore();
			int oracle = wVO.getOracleScore();
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\n", wVO.getNumber(), wVO.getName(), 
							java, oracle, (java+oracle), (java+oracle)/2);
		} else {
			System.out.println("데이터가 없습니다. (^.~)");
		}
	}
		
	public boolean exitProgram() {
		return true;
	}

}
