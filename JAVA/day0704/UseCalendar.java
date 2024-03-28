package day0704;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UseCalendar {
	
	public UseCalendar() {
		StringBuilder sb = new StringBuilder();

		//날짜 정보 - Calendar가 처리하는 시간 정보
		System.out.println(System.currentTimeMillis());
		
		//Calendar class는 abstract class로 직접 객체화 불가
		//1. instance를 얻는 static method를 사용하여 객체화
		Calendar cal = Calendar.getInstance(); //시스템의 현재 날짜
		
		//2. 자식 클래스를 사용하여 객체화
		Calendar cal2 = new GregorianCalendar();
		
		//object의 toString을 오버라이드하여 주소가 아닌 메시지가 출력 됨
		//System.out.println(cal);
		//System.out.println(cal2);
		
		//append의 반환형은 StringBuilder 이므로 method chain 가능
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //일요일(1) 월요일(2) 화요일(3)~
		String[] weekTitle = "일,월,화,수,목,금,토".split(",");
		String amTitle = "";
		int amPm = cal.get(Calendar.AM_PM);
		
		//조건문보다는 배열이 더 좋음! 상수를 비교용으로 사용해보는 예제임
		switch (amPm) {
		case Calendar.AM: //get이나 set에 넣어 사용하는 상수가 아니라면 비교용으로 사용한다.
			amTitle = "오전";
			break;
		default:
			amTitle = "오후";
			break;
		}
		
		sb.append(cal.get(Calendar.YEAR)).append("년 ")
		.append(cal.get(Calendar.MONTH)+1).append("월 ") //월은 해당 월에서 1 적게 나온다. 0~11월
		.append(cal.get(Calendar.DAY_OF_MONTH)).append("일 ")
		.append(weekTitle[dayOfWeek-1]).append("요일 ")
		.append("오늘은 이번 연도의 ").append(cal.get(Calendar.DAY_OF_YEAR)).append("일째 ")
		.append("\n오전/오후 ").append(amTitle).append(" ")
		//.append(cal.get(Calendar.HOUR)).append(" ") //12시간제
		.append(cal.get(Calendar.HOUR_OF_DAY)).append("시 ") //24시간제
		.append(cal.get(Calendar.MINUTE)).append("분 ")
		.append(cal.get(Calendar.SECOND)).append("초");
		
		System.out.println(sb);
	}//UseCalendar
	
	public UseCalendar calendarSet() {
		String[] dayTitle = "일,월,화,수,목,금,토".split(",");
		
		//1.Calendar 생성
		Calendar cal = Calendar.getInstance();
		
		//2.method 호출
		//변경 전
		System.out.println(cal.get(Calendar.YEAR) + "-" + 
				(cal.get(Calendar.MONTH)+1) + "-" + 
				cal.get(Calendar.DAY_OF_MONTH) + "-" +
				dayTitle[cal.get(Calendar.DAY_OF_WEEK)-1]);
		
		//연도 변경
		cal.set(Calendar.YEAR, 2024);
		
		//월 변경 - 자바는 0월부터 11월까지를 반환한다.
		cal.set(Calendar.MONTH, 11);
		
		//일 변경 - 없는 날짜를 입력하면 다음 달의 +초과한 일수로 반환
		cal.set(Calendar.DAY_OF_MONTH, 25);

		//변경 후
		System.out.println(cal.get(Calendar.YEAR) + "-" + 
				(cal.get(Calendar.MONTH)+1) + "-" + 
				cal.get(Calendar.DAY_OF_MONTH) + "-" +
				dayTitle[cal.get(Calendar.DAY_OF_WEEK)-1]);
		
		return this;
	}//calendarSet
	
	public void calSet2() {
		String[] dayTitle = "일,월,화,수,목,금,토".split(",");
		
		//1.Calendar 생성
		Calendar cal = Calendar.getInstance();
		
		//2.method 호출
		//일 변경 - 현재 월에 없는 일이 설정되면 다음 달의 +초과한 일수로 반환
		cal.set(Calendar.DAY_OF_MONTH, 32);
		
		System.out.println(cal.get(Calendar.YEAR) + "-" + 
				(cal.get(Calendar.MONTH)+1) + "-" + 
				cal.get(Calendar.DAY_OF_MONTH) + "-" +
				dayTitle[cal.get(Calendar.DAY_OF_WEEK)-1]);
	}

	public static void main(String[] args) {
		//calendarSet의 반환형을 UseCalendar로 바꾸어 method Chain
		new UseCalendar().calendarSet().calSet2();
	}//main

}//class
