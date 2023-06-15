package org.kosta.myproject.test.step2;

import java.sql.SQLException;

import org.kosta.myproject.model.MemberDAO;

public class TestUnitLogin {
	public static void main(String[] args) {
		try {
			String id = "java";
			String password = "a";
			System.out.println(MemberDAO.getInstance().login(id, password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
