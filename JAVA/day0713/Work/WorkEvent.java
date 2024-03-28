package day0713.Work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WorkEvent implements ActionListener {
	
	private Work0713 w;
	private JTextField idField;
	private JPasswordField pwField;
	private JLabel printLogin;
	private Map<String,String> login;
	
	public WorkEvent(Work0713 w) {
		this.w = w;
		idField = w.getIdField();
		pwField = w.getPwField();
		printLogin = w.getPrintLogin();
		login = new HashMap<String, String>();
		setMap();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = idField.getText();
		String pw = String.valueOf(pwField.getPassword());
		
		if(ae.getSource() == idField) {			
			if(login.containsKey(id)) {
				pwField.requestFocus();
			}else {
				printLogin.setText("아이디 땡~!");
			}
		}
		
		if(ae.getSource() == pwField) {
			if(login.containsKey(id)) {
				if(pw.equals(login.get(id))){
					String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
					printLogin.setText(id + "님 " + date + "초에 로그인 하셨습니다.");
				}else {
					printLogin.setText("비밀번호 땡~!");
				}
			}
		}

	}
	
	public void setMap() {
		login.put("admin", "1234");
		login.put("kang", "test1234");
		login.put("kim", "4321");
		login.put("lee", "sunkyung");
	}

}
