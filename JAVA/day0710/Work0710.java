package day0710;

import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Work0710 extends JFrame {
	
	public Work0710() {
		super("7월");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	
		int monthRow = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		int calNum = monthRow * 7;
		
		setLayout(new GridLayout(monthRow,7));
		JButton[] jbtnCal = new JButton[calNum];
				
		for(int i = 0, day = 1; i < jbtnCal.length; i++) {
			if(i < firstDay-1) {
				jbtnCal[i] = new JButton("\t");
			} else if(day > lastDay) {
				jbtnCal[i] = new JButton("\t");				
			} else {
				jbtnCal[i] = new JButton(String.valueOf(day));
				day++;
			}
			add(jbtnCal[i]);
		}
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		new Work0710();
	}
		
}
