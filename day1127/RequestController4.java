package kr.co.sist.controller.day1127;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

@Controller
public class RequestController4 {
	
	/**
	 * 요청 parameter 명과 응답 JSP명이 같다면 반환형을 기술할 필요가 없다.
	 * 요청 파라미터명 - param_frm2.do / 응답 jsp명 - param_frm2.jsp
	 */
	@GetMapping("/day1127/param_frm2.do")
	public void paramFrm() {
		System.out.println("paramFrm 호출");
	}//paramFrm
	
//	@GetMapping("/day1127/use_request_param.do")
//	public String useRequestParam2(ParamVO pVO) {
//		System.out.println(pVO.getName());
//		System.out.println("나이 : " + pVO.getAge());
//		System.out.println(pVO.getHobby());
//		return "day1127/request_param";
//	}
	
	@GetMapping("/day1127/use_request_param.do")
	public String useRequestParam(@RequestParam(required=true) String name, 
			@RequestParam(required = false, defaultValue = "0")int age, String[] hobby) {
		System.out.println(name);
		System.out.println("나이 : " + age);
		System.out.println(hobby);
		return "day1127/request_param";
	}
	
}
