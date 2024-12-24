package com.itwill.jsp2.repository;

import static com.itwill.jsp2.datasourceutil.DataSourceUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.datasourceutil.DataSourceUtil;
import com.itwill.jsp2.domain.Post;
import com.zaxxer.hikari.HikariDataSource;

// 웹 MVC 아키텍쳐에서 영속성/저장소 계층(persistence/repository layer)을 담당하는 객체.
// DB CRUD(create/read/update/delete) 기능을 갖고 있는 싱글톤 객체.
// DAO(Data Access Object).
public enum PostDao {
	INSTANCE; // 싱글톤 객체
	
	private static final Logger log = LoggerFactory.getLogger(PostDao.class);
	private final HikariDataSource ds = DataSourceUtil.INSTANCE.getDataSource();
	
	// 포스트 목록 검색에서 사용할 SQL
	private static final String SQL_SELECT_ALL = 
			"select * from posts order by id desc";
	
	public List<Post> select() {
		log.debug(SQL_SELECT_ALL);
		
		List<Post> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Post post = toPostFromResultSet(rs);
				list.add(post);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 리소스 해제(커넥션 풀에 사용했던 커넥션 반환).
			close(conn, stmt, rs);
		}

		return list;
	}

	// 포스트 저장(새 글 작성)에서 필요한 SQL 문장을 선언.
	private static final String SQL_INSERT = "";
	
	public int insert(Post post) {
		
		return 0;
	}
	
	private Post toPostFromResultSet(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("ID");
		String title = rs.getString("TITLE");
		String content = rs.getString("CONTENT");
		String author = rs.getString("AUTHOR");
		Timestamp createdTime = rs.getTimestamp("CREATED_TIME");
		Timestamp modifiedTime = rs.getTimestamp("MODIFIED_TIME");
		
		Post post = Post.builder()
				.id(id).title(title).content(content).author(author)
				.createdTime(createdTime).modifiedTime(modifiedTime)
				.build();
		
		return post;
	}
	
}
