package org.kosta.myproject.test.step2;

import java.sql.SQLException;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class TestUnitFindPostDetail {
	public static void main(String[] args) {
		try {
			long no = 1;
			PostVO postVO = BoardDAO.getInstance().findPostDetail(no);
			System.out.println(postVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
