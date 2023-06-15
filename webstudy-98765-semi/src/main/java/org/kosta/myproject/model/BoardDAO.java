package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private DataSource dataSource;

	private BoardDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static BoardDAO getInstance() {
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

	public ArrayList<PostVO> findPostList() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<PostVO> arrayList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b.no, b.title, m.name, TO_CHAR(b.time_posted, 'yyyy.mm.dd') AS time_posted, b.hits ");
			sql.append("FROM BOARD b ");
			sql.append("JOIN COMMUNITY_MEMBER m ON m.id = b.id ");
			sql.append("ORDER BY b.no DESC");
			preparedStatement = connection.prepareStatement(sql.toString());
//			String sql = "select b.no, b.title, m.name, to_char(b.time_posted, 'yyyy.mm.dd') as time_posted, b.hits from BOARD b, COMMUNITY_MEMBER m where m.id = b.id order by b.no desc";
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PostVO postVO = new PostVO();
				postVO.setNo(resultSet.getLong("no"));
				postVO.setTitle(resultSet.getString("title"));
				postVO.setContent(null);
				postVO.setHits(resultSet.getLong("hits"));
				postVO.setTimePosted(resultSet.getString("time_posted"));
				MemberVO memberVO = new MemberVO(null, null, resultSet.getString("name"));
				postVO.setMemberVO(memberVO);
				arrayList.add(postVO);
			}
		} finally {
			closeAll(resultSet, preparedStatement, connection);
		}
		return arrayList;
	}

	public PostVO findPostDetail(long no) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PostVO postVO = null;
		try {
			connection = dataSource.getConnection();
			String sql = "SELECT b.no, b.title, m.name, TO_CHAR(b.time_posted, 'yyyy.mm.dd') AS time_posted, b.hits, b.content "
					+ "FROM BOARD b " + "JOIN COMMUNITY_MEMBER m ON m.id = b.id " + "WHERE b.no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, no);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				postVO = new PostVO();
				postVO.setNo(resultSet.getLong("no"));
				postVO.setTitle(resultSet.getString("title"));
				MemberVO memberVO = new MemberVO(null, null, resultSet.getString("name"));
				postVO.setMemberVO(memberVO);
				postVO.setHits(resultSet.getLong("hits"));
				postVO.setTimePosted(resultSet.getString("time_posted"));
				postVO.setContent(resultSet.getString("content"));
			}
		} finally {
			closeAll(resultSet, preparedStatement, connection);
		}
		return postVO;
	}

}
