package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!request.getMethod().equals("POST")) {
			throw new ServletException("POST METHOD 방식만 로그인 가능");
		}
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO memberVO = MemberDAO.getInstance().login(id, password);
		if (memberVO == null) {
			return "redirect:member/login-fail.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", memberVO);
			return "redirect:FindPostList.do";
		}
	}
}
