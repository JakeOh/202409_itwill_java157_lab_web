package com.itwill.springboot4.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.domain.QPost;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostQuerydslImpl extends QuerydslRepositorySupport 
		implements PostQuerydsl {

	public PostQuerydslImpl() {
		// 상위 클래스 QuerydslRepositorySupport는 기본 생성자를 갖고 있지 않기 때문에
		// 하위 클래스의 생성자에서는 아규먼트를 갖는 생성자를 명시적으로 호출해야 함.
		super(Post.class); //-> 아규먼트: 엔터티 클래스
	}

	@Override
	public Post searchById(Long id) {
		log.info("searchById(id={})", id);
		
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post);  // select p from Post p
		query.where(post.id.eq(id));  // where p.id = ?
		Post entity = query.fetchOne();  // SQL 실행 & 결과 처리
		
		return entity;
	}
	
	@Override
	public List<Post> searchByKeyword(String keyword) {
		log.info("searchByKeyword(keyword={})", keyword);
		
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post)  // select p from Post p
				.where(
						post.title.containsIgnoreCase(keyword) // where p.title like ?
						.or(post.content.containsIgnoreCase(keyword)) // or p.content like ?
				)  // where ...
				.orderBy(post.id.desc());  // order by p.id desc
		List<Post> result = query.fetch();
		
		return result;
	}
	
	@Override
	public List<Post> searchByModifiedTime(LocalDateTime start, LocalDateTime end) {
		log.info("searchByModifiedTime(start={}, end={})", start, end);
		
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post)
				.where(post.modifiedTime.between(start, end))
				.orderBy(post.modifiedTime.desc());
		List<Post> result = query.fetch();
		
		return result;
	}
	
}
