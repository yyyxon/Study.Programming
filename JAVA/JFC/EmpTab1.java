package projectEx;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmpTab1 extends JPanel {
	private JButton jbtn;
	public EmpTab1() {
		
				
		jbtn=new JButton("탭1의 버튼");
		
		EmpTab1Evt et=new EmpTab1Evt(this);
		jbtn.addActionListener(et);
		add(jbtn);
	}
	public JButton getJbtn() {
		return jbtn;
	}
	
	
}
