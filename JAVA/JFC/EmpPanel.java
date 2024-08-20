package projectEx;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmpPanel extends JPanel{
	
	private JButton jbtn;
	public EmpPanel() {
		
		jbtn=new JButton("패널의 버튼");
		
		EmpPanelEvt epe = new EmpPanelEvt(this);
		jbtn.addActionListener(epe);
		add(jbtn);
	}
	
	public JButton getJbtn() {
		return jbtn;
	}

}
