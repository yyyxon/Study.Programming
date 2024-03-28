package day0821.work;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Work0821SubView extends JDialog{
	
	private static Work0821SubView wSV;
	private Work0821 w;
	private JTextField jtfEmpno;
	private JTextField jtfEname;
	private JTextField jtfHireDate;
	private JTextField jtfJob;
	private JTextField jtfSal;
	
	private Work0821SubView() {
		
	}
	
	private Work0821SubView(Work0821 w) {
		super(w,"사원 정보");
		this.w = w;
	}
	
	public static Work0821SubView getInstance(Work0821 w) {
		if(wSV == null) {
			wSV = new Work0821SubView(w);
		}
		
		return wSV;
	}//getInstance
	
	public void subView() {
		//JLabel
		JLabel jlEmpno = new JLabel("사원번호");
		JLabel jlEname = new JLabel("사원명");
		JLabel jlHireDate = new JLabel("입사일");
		JLabel jlJob = new JLabel("직무");
		JLabel jlSal = new JLabel("연봉");
		
		//JTextField
		jtfEmpno = new JTextField();
		jtfEname = new JTextField();
		jtfHireDate = new JTextField();
		jtfJob = new JTextField();
		jtfSal = new JTextField();
		
		jtfEmpno.setEditable(false);
		jtfEname.setEditable(false);
		jtfHireDate.setEditable(false);
		jtfJob.setEditable(false);
		jtfSal.setEditable(false);
		
		//Font
		Font font = new Font("맑은 고딕",Font.PLAIN,20);
		Font jtfFont = new Font("맑은 고딕",Font.PLAIN,15);
		
		jlEmpno.setFont(font);
		jlEname.setFont(font);
		jlHireDate.setFont(font);
		jlJob.setFont(font);
		jlSal.setFont(font);
		
		jtfEmpno.setFont(jtfFont);
		jtfEname.setFont(jtfFont);
		jtfHireDate.setFont(jtfFont);
		jtfJob.setFont(jtfFont);
		jtfSal.setFont(jtfFont);
		
		jtfEmpno.setBackground(Color.white);
		jtfEname.setBackground(Color.white);
		jtfHireDate.setBackground(Color.white);
		jtfJob.setBackground(Color.white);
		jtfSal.setBackground(Color.white);
		
		setLayout(null);
		
		jlEmpno.setBounds(50,40,100,30);
		jtfEmpno.setBounds(160,40,150,30);
		
		jlEname.setBounds(50,90,100,30);
		jtfEname.setBounds(160,90,150,30);
		
		jlHireDate.setBounds(50,140,100,30);
		jtfHireDate.setBounds(160,140,150,30);
		
		jlJob.setBounds(50,190,100,30);
		jtfJob.setBounds(160,190,150,30);
		
		jlSal.setBounds(50,240,100,30);
		jtfSal.setBounds(160,240,150,30);
		
		add(jlEmpno);
		add(jtfEmpno);
		add(jlEname);
		add(jtfEname);
		add(jlHireDate);
		add(jtfHireDate);
		add(jlJob);
		add(jtfJob);
		add(jlSal);
		add(jtfSal);
		
		setBounds(w.getX()+300,w.getY(),390,360);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//subView

	public JTextField getJtfEmpno() {
		return jtfEmpno;
	}

	public JTextField getJtfEname() {
		return jtfEname;
	}

	public JTextField getJtfHireDate() {
		return jtfHireDate;
	}

	public JTextField getJtfJob() {
		return jtfJob;
	}

	public JTextField getJtfSal() {
		return jtfSal;
	}
	
}
