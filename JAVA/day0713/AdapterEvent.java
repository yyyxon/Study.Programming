package day0713;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * XxxAdapter 클래스를 상속 받아 Override할 method를 최소화할 수 있다.
 * 인터페이스 상속 -> 모든 method를 Override 해야함
 * Adapter 클래스 상속 -> Override할 method 선택 가능
 * alt+shift+s
 * @author user
 */
public class AdapterEvent extends WindowAdapter{
	
	private AdapterDesign ad;
	
	public AdapterEvent(AdapterDesign ad) {
		this.ad = ad;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		ad.dispose();
	}//windowClosing
	
}//class
