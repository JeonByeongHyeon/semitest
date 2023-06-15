package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class PostDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no = Long.parseLong(request.getParameter("no"));
		PostVO postVO = BoardDAO.getInstance().findPostDetail(no);
		request.setAttribute("postDetail", postVO);
		return "/board/post-detail.jsp";
	}

}
