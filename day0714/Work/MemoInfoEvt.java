package day0714.Work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MemoInfoEvt extends WindowAdapter implements ActionListener {
	
	private MemoInfo mi;

	public MemoInfoEvt(MemoInfo mi) {
		this.mi = mi;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		windowClosing(null);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		mi.dispose();
	}

}
