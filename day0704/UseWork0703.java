package day0704;

public class UseWork0703 {
	
	public void useDataTokenizer() {
		String csvData = "강다연,김다영 김선경.김인영,김주민~박상준,박서현,서효민";
		Work0703 w = new Work0703();
		//1번 업무를 처리하는 method를 호출하여 업무처리 결과를 받아 사용(출력)한다.
		for(String data : w.dataTokenizer(csvData)) {
			System.out.print(data + " ");
		}//end for
	}//useCsvNames
	
	public void useDate() {
		Work0703 w = new Work0703();
		String value = w.date(1);
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		UseWork0703 w = new UseWork0703();
		//1번
		w.useDataTokenizer();
		
		System.out.println();
		
		//2번
		w.useDate();
	}//main

}
