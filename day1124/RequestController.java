package kr.co.sist.controller.day1124;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestController {
	
	//@RequestMapping("/request_get.do")
	@RequestMapping(value="/request_get.do", method=RequestMethod.GET)
	public String requestGet(Model model, HttpServletRequest request) {
		
		model.addAttribute("method",request.getMethod());
		
		return "day1124/response";
	}//requestGet


	@GetMapping("/request_get2.do")
	public String requestGet2(Model model, HttpServletRequest request) {
		
		model.addAttribute("method",request.getMethod());
		
		return "day1124/response";
	}//requestGet2

	@RequestMapping(value="/request_post.do", method=RequestMethod.POST)
	public String requestPost(Model model, HttpServletRequest request) {
		
		model.addAttribute("method",request.getMethod());
		
		return "day1124/response";
	}//requestGet2

	@PostMapping("/request_post2.do")
	public String requestPost2(Model model, HttpServletRequest request) {
		
		model.addAttribute("method",request.getMethod());
		
		return "day1124/response";
	}//requestGet2

	@GetMapping("/temp/req.do")
	public String request(Model model, HttpServletRequest request) {
		
		model.addAttribute("method",request.getMethod());
		
		System.out.println("---------- 가상 경로");
		
		return "day1124/response";
	}//requestGet2
	

}
