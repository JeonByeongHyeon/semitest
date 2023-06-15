package org.kosta.myproject.test.step1;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class TestUnitFindPostList {
	public static void main(String[] args) {
		try {
			BoardDAO boardDAO = BoardDAO.getInstance();
			ArrayList<PostVO> arrayList = boardDAO.findPostList();
			for (PostVO postVO : arrayList) {
				System.out.println(postVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
