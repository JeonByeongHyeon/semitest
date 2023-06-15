package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/*
 * Singleton Design Pattern : 시스템 상에서 단 한번 하나의 객체를 생성해서
 * 								여러 곳에서 공유해 사용하는 설계 패턴
*/
public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DataSource dataSource;

	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		if (preparedStatement != null)
			preparedStatement.close();
		if (connection != null)
			connection.close(); // connection을 dbcp에 반환한다
	}

	public void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
			throws SQLException {
		if (resultSet != null)
			resultSet.close();
		closeAll(preparedStatement, connection);
	}

	public MemberVO login(String id, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MemberVO memberVO = null;
		try {
			connection = dataSource.getConnection();
			String sql = "select name from community_member where id = ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				memberVO = new MemberVO(id, password, resultSet.getString("name"));
			}
		} finally {
			closeAll(resultSet, preparedStatement, connection);
		}
		return memberVO;
	}
}
