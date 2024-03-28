package day0706;

import java.util.Calendar;

public class Work0704 {
	private Calendar cal;
	
	public Work0704() { //필드는 선언만
		cal = Calendar.getInstance();
	}

	public StringBuilder calendar() {
		StringBuilder sb = new StringBuilder();
		//1일을 출력하기전 공백
		
		for (int j = 0; j < cal.get(Calendar.DAY_OF_WEEK); j++) {
			sb.append("    ");
		} // end for
		int tempDay = 1; //가상의 일자 tempDay
		while (tempDay <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) { //이번달의 마지막 날
			cal.set(Calendar.DAY_OF_MONTH, tempDay);
			sb.append(tempDay).append("   ");
			switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SATURDAY:
				sb.append("\n");
			}//같은지를 물어볼 땐 switch case
				tempDay++;
		} // end while

		return sb;
	}// calendar

	// 2번
	public String[][] yearMonth(int year, int month) {
		cal.set(year, month - 1, 1);
		//매월마다 행이 다르다. 다른 행을 얻는다.
		int monthRowCnt = 0;
		monthRowCnt = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		String[][] calendar = new String[monthRowCnt][7];

		int day = 1;
		for (int i = 0; i < monthRowCnt; i++) {
			for (int j = 0; j < Calendar.SATURDAY; j++) { //Constant 활용~!
				if (i == 0 && cal.get(Calendar.DAY_OF_WEEK) > j + 1) {
					calendar[i][j] = "  ";
				} else if (day > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
					calendar[i][j] = " ";

				} else {
					calendar[i][j] = String.format("%2d", day);
					day++;

				} // end else
			} // end for
		} // end for
		return calendar;
	}// end yearMonth

}// class
