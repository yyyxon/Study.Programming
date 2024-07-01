package kr.co.sist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.domain.EmpDomain;
import kr.co.sist.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService ts;
	
	@GetMapping("/")
	public String main(Model model) {
		List<EmpDomain> empList = ts.selectAllEmp();
		model.addAttribute("msg","쭈고~");
		model.addAttribute("empList",empList);
		
		System.out.println("@@@" + empList);
		
		return "main";
	}//main


}//class
