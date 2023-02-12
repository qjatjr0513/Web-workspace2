package com.kh.cookie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookieController
 */
@WebServlet("/deleteCookie.do")
public class DeleteCookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 저장된 쿠키 삭제하기
		String cookieId = request.getParameter("cookieId");
		
		//1. 쿠키의 key값을 이용하여 유효기간을 조정하여 삭제하기.
		Cookie c = new Cookie(cookieId, "");
		c.setMaxAge(0);// 동일한 이름의 key값의 cookie를 생성해서 유효기간을 0으로 설정하면 cookie가 삭제됨.
		response.addCookie(c);
		
		response.sendRedirect(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
