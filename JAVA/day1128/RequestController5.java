package kr.co.sist.controller.day1128;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestController5 {
	
	//HttpServeltReuqest
	@GetMapping("/day1128/use_send_value.do")
	public String useHttpServeltReuqest(HttpServletRequest request) {
		
		//값 설정
		request.setAttribute("name", "농담곰");
		request.setAttribute("uri", request.getRequestURI());
		
		String[] hobby = {"독서", "게임", "자바"};
		request.setAttribute("hobby", hobby);
		
		return "day1128/data_view";
	}
	
	//Model
	@GetMapping("/day1128/use_send_value2.do")
	public String useModel(Model model) {
		//Model 값 설정 => HttpServletRequest에 값이 설정된다.
		model.addAttribute("name", "신짱구");
		model.addAttribute("uri", "/day1128/use_send_value2.do");
		
		String[] hobby = {"유튜브", "게임", "독서", "부리부리"};
		model.addAttribute("hobby", hobby);
		
		return "day1128/data_view";
	}
	
	//ModelAndView
	@GetMapping("/day1128/use_send_value3.do")
	public ModelAndView useModelAndView() {
		//1.ModelAndView 생성
		ModelAndView mav = new ModelAndView();
		
		//2.view 페이지 설정
		mav.setViewName("day1128/data_view");
		
		//3.데이터 추가
		mav.addObject("name", "흰둥이");
		mav.addObject("uri", "/day1128/use_send_value2.do");
		
		String[] hobby = {"밥먹기", "공 만들기", "짖기"};
		mav.addObject("hobby", hobby);
		
		//4.반환
		return mav;
	}
	
	//redirect를 사용하여 .do의 이동
	@GetMapping("/day1128/use_redirect.do")
	public String userRedirectDo() {
		return "redirect:/day1128/use_send_value2.do";
	}
	
	//redirect를 사용하여 .jsp의 이동
	@GetMapping("/day1128/use_redirect2.do")
	public String useRedirectJSP() {
		return "redirect:../index.jsp";
	}
}
