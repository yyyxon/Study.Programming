package day0712.Work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Work0712 extends JFrame implements ActionListener{
	private JTextField nameField;
	private JTextArea jta;
	private StringBuilder sb;
	
	public Work0712() {
		super("숙제");
		//이름
		JLabel nameLabel = new JLabel("이름");
		nameField = new JTextField(10);
		
		//입력
		JButton inputBtn = new JButton("입력");
		
		//출력
		jta = new JTextArea();
		jta.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(jta);
		sb = new StringBuilder();
				
		JPanel jp = new JPanel();
		jp.add(nameLabel);
		jp.add(nameField);
		jp.add(inputBtn);

		add("North",jp);
		add(jsp);

		inputBtn.addActionListener(this);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText().replace(" ", "");
		if(!name.isEmpty()) {
			sb.append(name).append("님\n");
			jta.setText(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		new Work0712();
	}


}
