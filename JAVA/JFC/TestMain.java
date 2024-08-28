package projectEx;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TestMain extends JFrame {

	private JTabbedPane jtp;
	private JButton jbtn;
	
	public TestMain() {
		super("test");
		jtp=new JTabbedPane();
		
		jbtn = new JButton("패널");
		
		EmpTab1 et1=new EmpTab1();
		EmpTab2 et2=new EmpTab2();
		EmpPanel ep = new EmpPanel();
		
		jtp.add(et1,"사원정보");
		jtp.add(et2,"근태정보");
		
		//add("Center", jtp);
		add("South", jbtn);
		MainEvt me=new MainEvt(this);
		addWindowListener(me);
		jbtn.addActionListener(me);
		
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestMain();
	}//main
	
	public JButton getJbtn() {
		return jbtn;
	}

}//class
