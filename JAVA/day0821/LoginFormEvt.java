package day0821;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginFormEvt extends WindowAdapter implements ActionListener{
	
	private LoginForm lf;
	
	public LoginFormEvt(LoginForm lf) {
		this.lf = lf;
	}//LoginFormEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		lf.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		chkEmpty();			
	}//actionPerformed
	
	private void chkEmpty() {
		//아이디가 비어있다면 경고창으로 아이디 입력을 보여준다.
		String id = lf.getJtfId().getText().trim();
		
		if("".equals(id)) {
			JOptionPane.showMessageDialog(lf,"아이디를 입력해주세요.");
			lf.getJtfId().requestFocus();
			return;
		}
		
		//비밀번호가 비어있다면 경고창으로 비밀번호 입력을 보여준다.
		String pass = new String(lf.getJpfPass().getPassword());
		
		if("".equals(pass)) {
			JOptionPane.showMessageDialog(lf,"비밀번호를 입력해주세요.");
			lf.getJpfPass().requestFocus();
			return;
		}
		
//		id = injectionBlock(id); //id와 비밀번호에 SQLInjection에 해당하는 값이 존재하면 제거
//		pass = injectionBlock(pass);
		
		//아이디와 비밀번호 모두 입력되었다면 loginCheck() 호출
		LoginVO lVO = new LoginVO(id,pass);
		loginCheck(lVO);
	}
	
	public String injectionBlock(String sql) {
		String resultSql = sql;
		//공백을 허용하지 않음, SQL주석 막기, 쿼리문에 해당하는 문자열 막기
		resultSql = resultSql.replaceAll(" ", "").replaceAll("--", "").replaceAll("select", "")
		.replaceAll("insert", "").replaceAll("delete", "");
		
		return resultSql;
	}
	
	private void loginCheck(LoginVO lVO) {
		InjectionTestDAO itDAO = InjectionTestDAO.getInstance();
		
		try {
//			LoginResultVO lrVO = itDAO.useStatementLogin(lVO);
			//PreparedStatement는 값이 SQLInjection에 해당되면 자동으로 처리 함
			LoginResultVO lrVO = itDAO.usePreparedStatementLogin(lVO);
			
			if(lrVO == null) {
				JOptionPane.showMessageDialog(lf, "아이디나 비밀번호를 확인해주세요.");
				lf.getJlblOutput().setText("");
				return;
			}//end if
			
			lf.getJlblOutput().setText(lrVO.getName() + "님 로그인 하셨습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(lf, "아이디나 비밀번호를 확인해주세요.");
		}
		
	}
	
}
