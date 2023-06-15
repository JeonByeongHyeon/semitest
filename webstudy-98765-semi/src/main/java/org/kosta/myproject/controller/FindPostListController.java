package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class FindPostListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<PostVO> posts = BoardDAO.getInstance().findPostList();
		request.setAttribute("postList", posts);
		return "board/list.jsp";
	}
}