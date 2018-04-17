package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.itstep.ApplicationRunner;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.service.LessonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class LessonControllerTest {

	@Autowired
	TestRestTemplate restTemplate;
	
	@MockBean
	LessonService lessonService;
	
	@Test
	public void testSave() throws URISyntaxException {
		Lesson lesson = new Lesson();
		
		Subject subject = new Subject();
		subject.setName("Java");
		
		lesson.setSubject(subject);
		
		
		Mockito.when(lessonService.save(Mockito.any(Lesson.class))).thenReturn(lesson);
		RequestEntity<Lesson> request = new RequestEntity<Lesson>(lesson, HttpMethod.POST, new URI("/lesson"));
		ResponseEntity<Lesson> response = restTemplate.exchange(request, Lesson.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode()); 
		assertEquals("Java", response.getBody().getSubject().getName());
		
		Mockito.verify(lessonService , Mockito.times(1)).save(Mockito.any(Lesson.class));
	}

	
	@Test
	public void testUpdate() {
	}

	@Test
	public void testGetOne() {
	}

}
