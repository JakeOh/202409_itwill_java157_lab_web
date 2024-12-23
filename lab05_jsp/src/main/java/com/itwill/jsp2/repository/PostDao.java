package com.itwill.jsp2.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.datasourceutil.DataSourceUtil;
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

}
