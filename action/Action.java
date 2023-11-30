package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	/**
	 * web parameter 받기, 관계 유지 객체(session, cookie) 사용, 응답 페이지명 설정,
	 * 응답 페이지 이동방식 설정, XxxService 사용, View페이지로 데이터 전달(Scope 객체 사용)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
	/**
	 * 이동 페이지의 URL을 반환
	 * @return
	 */
	public String movePage();
	
	/**
	 * 페이지의 이동 방식 설정
	 * @return
	 */
	public boolean isForward();

}
