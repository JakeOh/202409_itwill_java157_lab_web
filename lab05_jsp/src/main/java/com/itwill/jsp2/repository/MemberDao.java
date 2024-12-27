package com.itwill.jsp2.repository;

import static com.itwill.jsp2.datasourceutil.DataSourceUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.datasourceutil.DataSourceUtil;
import com.itwill.jsp2.domain.Member;
import com.zaxxer.hikari.HikariDataSource;

public enum MemberDao {
	INSTANCE; // 싱글톤

	private static final Logger log = LoggerFactory.getLogger(MemberDao.class);
	private final HikariDataSource ds = DataSourceUtil.INSTANCE.getDataSource();
	
	// 회원 가입에 필요한 SQL, 메서드
	private static final String SQL_INSERT = 
			"insert into members (username, password, email, created_time, modified_time) "
			+ "values (?, ?, ?, systimestamp, systimestamp)";
	
	public int insert(Member member) {
		log.debug("insert(member={})", member);
		log.debug(SQL_INSERT);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, member.getUsername());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getEmail());
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt);
		}
		
		return result;
	}
	
}
