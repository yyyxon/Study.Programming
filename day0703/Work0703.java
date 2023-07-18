package day0703;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Work0703 {
	
	public static final int KOREA = 0;
	public static final int US = 1;
	public static final int JAPAN = 2;
	public static final int CANADA = 3;
	
	public String[] dataTokenizer(String csvData) {
		String[] csvArr = null;
		int i = 0;
		StringTokenizer csvToken = new StringTokenizer(csvData," ,.~");
		csvArr = new String[csvToken.countTokens()];
		while(csvToken.hasMoreTokens()) {
			csvArr[i] = csvToken.nextToken();
			if(csvArr[i].indexOf("김") == 0) {
				csvArr[i] = csvArr[i].substring(1);
			}
			i++;
		}
		
		return csvArr;
	}
	
	public String toDate(int country) {
		SimpleDateFormat sdf = null;
		String date = "";

		if(country > -1 && country < 4) {
			switch(country) {
			case KOREA :
				sdf = new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a EEEE");
				break;
			case US :
				sdf = new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a EEEE",Locale.US);
				break;
			case JAPAN :
				sdf = new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a EEEE",Locale.JAPAN);
				break;
			case CANADA :
				sdf = new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a EEEE",Locale.CANADA);	
				break;
			}
			
			date = sdf.format(new Date()).toString();
			
		} else {
			date = "0~3의 숫자를 입력해주세요. 0:한국, 1:미국, 2:일본, 3:캐나다";
		}
		
		return date;
	}
	
	public static void main(String[] args) {
		String csvData = "강다연,김다영 김선경.김인영,김주민~박상준,박서현,서효민";
		Work0703 w = new Work0703();
		for(String data : w.dataTokenizer(csvData)) {
			System.out.print(data + " ");
		}
		
		System.out.println();
		
		System.out.println(w.toDate(0));
	}

}
