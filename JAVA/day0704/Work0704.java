package day0704;

import java.util.Calendar;

public class Work0704 {
	
	public void July() {
		Calendar cal = Calendar.getInstance();
		int week = 0;
		//0-1, 1-2, 2-3, 3-4, 4-5, 5-6, 6-7,....
		cal.set(2023, 6, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH)+1; i++) {
			if(i == 1) {
				for(int j = 0; j < dayOfWeek-1; j++, week++) {
					System.out.print("\t");
				}
			}
			
			if(week%7 == 0) {
				System.out.println();
			}
			
			System.out.print(i + "\t");
			week++;
		}
	}
	
	public String[][] selectCalendar(int year, int month){
		Calendar cal = Calendar.getInstance();
		Calendar lastCal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int week = 0;
		int day = 1;
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1일의 요일
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //마지막날
		lastCal.set(year, month-1, lastDay);
		String[][] calArr = setCalendarArr(lastCal); //new String[lastWeek][];
		
		System.out.printf("\t\t     %d년 %d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i = 0; i < calArr.length; i++) {
			
			if(i == 0) {
				for(int j = 0; j < dayOfWeek-1; j++, week++) {
					calArr[i][j] = "\t";
				}
			} 				
				
			for(int j = week; j < calArr[i].length; j++, day++) {	
				calArr[i][j] = String.valueOf(day).concat("\t");

				week = week < 7 ? 0 : week++;
			}
		}
		return calArr;
	}

	public String[][] setCalendarArr(Calendar lastCal){
		int lastWeek = lastCal.get(Calendar.WEEK_OF_MONTH); //마지막날의 주
		int lastDayOfWeek = lastCal.get(Calendar.DAY_OF_WEEK); //마지막날의 요일
		
		String[][] calArr = new String[lastWeek][];
		
		for(int i = 0; i < lastWeek; i++) {
			calArr[i] = new String[7];
			if(i == lastWeek-1) {
				calArr[i] = new String[lastDayOfWeek];
			}
		}
		
		return calArr;
	}
	
	public static void main(String[] args) {

		Work0704 w = new Work0704();
		w.July();
		
		System.out.println();
		
		String[][] calArr = w.selectCalendar(2023, 1);
		
		for(String[] week : calArr) {
			for(String day : week) {
				System.out.print(day);
			}
			System.out.println();
		}
		
	}

}
