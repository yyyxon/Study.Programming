package day0707;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Work0706 {
	
	private List<WorkVO2> studentList;
	public Work0706() {
		studentList = new ArrayList<WorkVO2>();
	}
	
	public void selectMenu() {
		boolean exitFlag = false;
		String inputData = "";
		String[] tempData = null;
		do {
			inputData = JOptionPane.showInputDialog("이름,자바점수,오라클 점수를 입력\n\"출력\"을 입력하시면 출력합니다."
					+ "\n종료는 Y[y]를 입력해주세요.");
			inputData = inputData.replace(" ", ""); //white space 처리
			if(inputData != null && !inputData.equals(" ")) {
				//객체가 생성이 되었으면서 Empty가 아니면 실행
				tempData = inputData.split(",");
				if(tempData.length == 3) {
					dataInput(tempData);
				}//입력
				if(inputData.equals("출력")) {
					printData();
				}//출력
				if(inputData.toUpperCase().equals("Y")) {
					exitFlag = exitProgram();
					JOptionPane.showConfirmDialog(null, "사용해주셔서 감사용");
				}//종료
			}
		}while(!exitFlag);	
	}
	
	public void dataInput(String[] data) {
		//입력된 배열을 사용하여 VO를 생성하고 리스트에 추가
		studentList.add(new WorkVO2(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
	}
	
	public void printData() {
		System.out.println("번호\t이름\t자바\t오라클\t총점");
		if(studentList.isEmpty()) { //size() == 0 보다 isEmpty!!!
			System.out.println("데이터가 없습니다. (^.~)");
		} else {
			WorkVO2 wVO = null;
			for(int i = 0; i < studentList.size(); i++) {
				wVO = studentList.get(i); //리스트의 값을 얻어 VO저장
				System.out.printf("%d\t%s\t%d\t%d\t%d\n",i+1, wVO.getName(), wVO.getJavaScore(),
						wVO.getOracleScore(),wVO.getJavaScore()+wVO.getOracleScore());
			}
		}
	}
	
	public boolean exitProgram() {
		return true;
	}
	
	public static void main(String[] args) {
		Work0706 w = new Work0706();
		w.selectMenu();
	}//main
}
//class