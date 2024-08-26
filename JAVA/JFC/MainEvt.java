package projectEx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainEvt extends WindowAdapter implements ActionListener {
	private TestMain tm;
	private JPanel EmpPanel;
	
	public MainEvt(TestMain tm) {
		this.tm=tm;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		tm.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		EmpPanel = new EmpPanel();
		tm.add("Center",EmpPanel);
	}
	
	
}
