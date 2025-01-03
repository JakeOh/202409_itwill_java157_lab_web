package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class PostDaoTest {

	@Autowired
	private PostDao postDao;
	
	@Test
	public void testPostDao() {
		Assertions.assertNotNull(postDao);
		log.debug("postDao={}", postDao);
	}
	
	@Test
	public void testSelectOrderByIdDesc() {
		List<Post> list = postDao.selectOrderByIdDesc();
		list.forEach(x -> log.debug("{}", x));
	}
	
}
