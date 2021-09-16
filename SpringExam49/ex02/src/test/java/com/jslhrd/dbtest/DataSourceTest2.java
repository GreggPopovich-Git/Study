package com.jslhrd.dbtest;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class DataSourceTest2 {
	//@Setter(onMethod_=@Autowired)
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Connection conn = sqlSession.getConnection();
			log.info("세션객체 : " + sqlSession);
			log.info("커넥션 : " + conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
