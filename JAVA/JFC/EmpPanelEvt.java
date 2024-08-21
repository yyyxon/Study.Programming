package projectEx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class EmpPanelEvt implements ActionListener{
	
	private EmpPanel ep;
	
	public EmpPanelEvt(EmpPanel ep) {
		this.ep = ep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(ep, "버튼 클릭됨");		
	}

}
