package projectEx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EmpTab1Evt implements ActionListener {

	private EmpTab1 et1;
	public EmpTab1Evt(EmpTab1 et1) {
		this.et1=et1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(et1, "버튼1 클릭됨");
	}

}
