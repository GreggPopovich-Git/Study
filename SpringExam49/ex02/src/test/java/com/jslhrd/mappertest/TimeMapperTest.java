package com.jslhrd.mappertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jslhrd.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class TimeMapperTest {
	@Setter(onMethod_=@Autowired)
	private TimeMapper timeMapper;
	
	/*
	@Test
	public void testGetTime() {
		try {
			log.info("클래스 : " + timeMapper.getClass().getName());
			log.info("메소드 호출 : " + timeMapper.getTime());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	@Test
	public void testGetTime2() {
		log.info("메소드 호출 : " + timeMapper.getTime2());
	}
}
