package com.itwill.spring2.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class DataSourceTest {

	/*
	 * 의존성 주입(DI: Dependency Injection), 제어의 역전(IoC: Inversion of Control)
	 * 전통적인 자바 개발 방법에서는 객체를 사용하는 곳에서 객체를 생성하고, 그 기능을 이용함.
	 * 스프링 프레임워크에서는 스프링 컨테이너가 필요한 객체들을 미리 생성하고 관리하고 있다가
	 * 객체를 필요로 하는 곳에서는 변수 선언과 애너테이션으로
	 * 스프링 컨테이너가 관리하는 빈(자바 객체)을 주입받아서 사용.
	 * application-context.xml 파일: 스프링 컨테이너가 생성/관리하는 빈들을 설정하는 파일.
	 * 
	 * 스프링 프레임워크: 모델2 MVC(위임 패턴) 아키텍처를 제공하고, 의존성 주입을 제공하는 프레임워크.
	 */
	
	@Autowired //-> 스프링 컨테이너에서 생성/관리하는 빈(객체)을 주입받음.
	private HikariDataSource ds;
	
	@Autowired
	private SqlSessionFactoryBean sqlSession;
	
	@Test
	public void testDataSource() throws SQLException {
		Assertions.assertNotNull(ds);
		log.debug("ds={}", ds);
		
		Connection conn = ds.getConnection();
		Assertions.assertNotNull(conn);
		log.debug("conn={}", conn);
		
		conn.close();
		log.debug("커넥션 객체를 풀에 반환.");
	}
	
	@Test
	public void testSqlSession() {
		Assertions.assertNotNull(sqlSession);
		log.debug("sqlSession={}", sqlSession);
	}
	
}
