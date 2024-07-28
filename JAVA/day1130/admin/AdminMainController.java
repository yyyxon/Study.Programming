package kr.co.sist.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("adminId")
@Controller
public class AdminMainController {
	
	@RequestMapping("/admin/login_frm.do")
	public String loginFrm(Model model) {
		model.addAttribute("adminId","admin");
		
		return "admin/login_frm";
	}
}
